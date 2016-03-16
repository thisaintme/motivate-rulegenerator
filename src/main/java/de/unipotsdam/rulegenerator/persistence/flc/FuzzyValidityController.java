package de.unipotsdam.rulegenerator.persistence.flc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import de.unipotsdam.rulegenerator.persistence.generator.FISGenerator;
import de.unipotsdam.rulegenerator.persistence.parser.ContextInformationParser;
import de.unipotsdam.rulegenerator.persistence.parser.Information;
import de.unipotsdam.rulegenerator.statistics.Reason;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import org.antlr.runtime.RecognitionException;

/**
 * Created by martinhertel on 08/08/15.
 */
public class FuzzyValidityController {
    private static final double VALIDITY_THRESHOLD = 0.75;
    private StatisticsList statistics;
    private Hashtable<String, Information> informationHashTable;
    private Hashtable<String, FunctionBlock> functionBlocks = new Hashtable<String, FunctionBlock>();


    /**
     * This class controls the context information validation process and is the interface between MOTIVATE's statistics collection process and the validation process.
     * The constructor initializes the context information parser and generates the functions blocks for later use.
     */
    public FuzzyValidityController()   {

        try {
            ContextInformationParser contextInformationParser = new ContextInformationParser();
            this.informationHashTable = contextInformationParser.getResolvedInformationNodes();

            for( String informationID : this.informationHashTable.keySet() )
            {
                this.functionBlocks.put( informationID, this.buildFunctionBlock( this.informationHashTable.get(informationID) ) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method performs the validation based on a list of statistics items and an action name.
     * @param statistics: 	List of context information collected
     * @param actionName: 	Name of action context information items are related to
     * @return 				List of successfully validated statistics items
     */
    public List<Reason> runValidation( StatisticsList statistics, String actionName ) {
        List<Reason> validatedInformations = new ArrayList<Reason>();
        Hashtable< String, List<InformationValue> > usableStatisticsValues = new Hashtable< String, List<InformationValue> >();
        this.statistics = statistics;

        DateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");	// the time stamps in the Reason objects are expected to be of this format
        boolean addRecordedContextInformation;
        Date currentRecordedTime, currentActionTime;
        Information currentInformation;
        List<InformationValue> currentUsableStatisticsValues;

        // compose list of usable statistics items; their values will be used as inputs to the fis
        for( Reason statistics_item : this.statistics.getList() )
        {

            addRecordedContextInformation = true;
            currentRecordedTime = new Date();
            currentActionTime = new Date();
            try {
                currentRecordedTime = df.parse( statistics_item.getRecordedTime().toString() );
                currentActionTime = df.parse( statistics_item.getActionTime().toString() );
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            if( statistics_item.getAction().toString().equals(actionName) && currentActionTime.before( currentRecordedTime ) )
            {
                currentInformation = this.informationHashTable.get( statistics_item.getRecordedContextInformation().toString() );
                currentUsableStatisticsValues = usableStatisticsValues.get( currentInformation.getId() );
                if( !currentInformation.isMultiplicity() )
                {
                    // only take into account required actions and which weren't executed before the recorded time
                    if( currentUsableStatisticsValues != null )
                    {
                        // set flag to false if existing statistics value is more recent than current
                        for( InformationValue currentInformationValue : currentUsableStatisticsValues )
                        {
                            addRecordedContextInformation = currentInformationValue.isMoreRecent( currentRecordedTime );
                        }
                        if( addRecordedContextInformation )
                        {
                            // remove existing informationValue
                            usableStatisticsValues.remove( currentInformation.getId() );
                        }
                    }
                }


                if( addRecordedContextInformation )
                {
                    // add statistics value
                    if( currentUsableStatisticsValues == null )
                    {
                        currentUsableStatisticsValues = new ArrayList<InformationValue>();
                    }
                    currentUsableStatisticsValues.add( new InformationValue( statistics_item.getRecordedContextInformation().toString(),
                            statistics_item.getRecordedValue().toString(),
                            currentRecordedTime,
                            statistics_item ));

                    // first remove old list and put new, updated list instead
                    usableStatisticsValues.remove( currentInformation.getId() );
                    usableStatisticsValues.put( currentInformation.getId(), currentUsableStatisticsValues );
                }
            }
        }


        // start validation
        FunctionBlock currentFunctionBlock;
        List<InformationValue> currentUsableInformationValues;

        boolean validateCurrentInformation;
        String currentRawValue;
        double currentValue;
        double currentValidity;
        for( String informationID : this.informationHashTable.keySet() )
        {
            // iterate over all registered information models
            validateCurrentInformation = true;
            currentValidity = 0;

            if( usableStatisticsValues.containsKey( informationID ) )
            {
                // validate if information model is contained in usable statistics list
                currentInformation = this.informationHashTable.get( informationID );
                currentFunctionBlock = this.functionBlocks.get( informationID );
                currentUsableInformationValues = usableStatisticsValues.get( informationID );

                for( InformationValue currentUsableInformationValue : currentUsableInformationValues )
                {
                    // iterate over all InformationValues to account for multiplicity
                    currentFunctionBlock.reset();

                    for( Information dependency : currentInformation.getDependencies() )
                    {
                        if( !usableStatisticsValues.containsKey( dependency.getId() ) )
                        {
                            validateCurrentInformation = false;
                            break;
                        }

                        // informations can only depend on non-multiplicity information nodes
                        currentRawValue = ( !dependency.getId().equals( informationID ) ) ? usableStatisticsValues.get( dependency.getId() ).get( 0 ).getValue() : currentUsableInformationValue.getValue();
                        currentValue = dependency.preprocessValue( currentRawValue );
                        currentFunctionBlock.setVariable( dependency.getId(), currentValue );
                    }

                    if( validateCurrentInformation ) {
                        currentFunctionBlock.evaluate();
                        currentValidity = currentFunctionBlock.getVariable("validity").defuzzify();
                    }

                    System.out.print( informationID + ": " );
                    System.out.println( currentValidity );
                    if( validateCurrentInformation && currentValidity >= FuzzyValidityController.VALIDITY_THRESHOLD )
                    {
                        validatedInformations.add( currentUsableInformationValue.getReason() );
                    }
                }
            }
        }

        return validatedInformations;
    }


    /**
     * This method generates the function block for a given information
     * @param information			The information for which the function block is to be created
     * @return						Returns the function block as a string
     * @throws RecognitionException	Exception in case a key term could not be recognized
     */
    private FunctionBlock buildFunctionBlock(Information information) throws RecognitionException   {
        FIS fis;
        FunctionBlock fb = null;

        String fcl = FISGenerator.generateFIS(information);

        try
        {
            fis = FIS.createFromString(fcl, true);
            fb = fis.getFunctionBlock(null);
        }
        catch(Exception e)
        {
            System.out.println( fcl );
            System.out.println( e.getMessage() );
        }

        return fb;
    }
}
