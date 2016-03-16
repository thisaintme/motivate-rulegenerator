package de.unipotsdam.rulegenerator.persistence.generator;

import de.unipotsdam.rulegenerator.persistence.parser.Information;
import de.unipotsdam.rulegenerator.persistence.parser.LogicalBlock;
import de.unipotsdam.rulegenerator.persistence.parser.Rule;
import de.unipotsdam.rulegenerator.persistence.parser.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martinhertel on 08/08/15.
 */

/**
 * This class generates the FIS for a given Information instance
 */
public class FISGenerator {
    private static String functionBlockTemplate =
            "FUNCTION_BLOCK %s\n\n" +

                    "VAR_INPUT\n" +
                    "%s" +
                    "END_VAR\n\n" +

                    "VAR_OUTPUT\n" +
                    "\tvalidity : REAL;\n" +
                    "END_VAR" +

                    "%s\n\n" +						// fuzzification

                    "DEFUZZIFY validity\n" +
                    "\tTERM low := (0,1) (0.5,0);\n" +
                    "\tTERM average := TRAPE 0.25 0.5 0.6 0.75;\n" +
                    "\tTERM high := (0.75,0) (1,1);\n" +
                    "\tMETHOD : COG;\n" +
                    "\tDEFAULT := 0;\n" +
                    "END_DEFUZZIFY\n\n" +

                    "RULEBLOCK No1\n" +
                    "\tAND : MIN;\n" +
                    "\tACT : MIN;\n" +
                    "\tACCU : MAX;\n\n" +

                    "%s\n" + 						// rules
                    "END_RULEBLOCK\n\n" +

                    "END_FUNCTION_BLOCK";

    private static String parameterTemplate = "\t%s : REAL;\n";

    private static String linguisticTermTermplate = "\tTERM %s := %s;\n";

    private static String fuzzificationBlockTemplate =
            "\n\nFUZZIFY %s\n" +
                    "%s" +
                    "END_FUZZIFY";

    private static String ruleTemplate = "\tRULE %s : IF %s THEN validity IS %s WITH %s;\n";


    /**
     * The main method that takes an Information instance and controls the generation process
     * @param information   The Information instance for which the FIS is to be generated
     * @return              Returns the FIS as a String
     */
    public static String generateFIS( Information information )   {
        String function_block = "";
        String varInputs, fuzzification = "", ruleBlock = "";

        varInputs = FISGenerator.composeVarInputs( information );
        fuzzification = FISGenerator.composeFuzzification( information );
        ruleBlock = FISGenerator.composeRuleBlock( information );

        function_block = String.format(FISGenerator.functionBlockTemplate,
                information.getId(), varInputs, fuzzification, ruleBlock
        );


        return function_block;
    }


    /**
     * This method generates the FIS input block
     * @param information   The Information instance for which the input block is to be generated
     * @return              Returns the input block as a string
     */
    private static String composeVarInputs( Information information ) {
        List<Information> dependencies = information.getDependencies();
        String varInputs = "";

        for ( Information dependency : dependencies ) {
            varInputs += String.format( FISGenerator.parameterTemplate, dependency.getId() );
        }

        return varInputs;
    }

    /**
     * This method generates the fuzzification block where crisp input values are mapped into linguistic terms
     * @param information   The Information instance for which the fuzzification block is to be generated
     * @return              Returns the fuzzification block as a String
     */
    private static String composeFuzzification( Information information )   {
        List<Information> dependencies = information.getDependencies();
        String fuzzification = "";
        String terms = "";

        for( Information dependency : dependencies )
        {
            terms = "";
            for( Term term : dependency.getTerms() )
            {
                terms += String.format( FISGenerator.linguisticTermTermplate,
                        term.getName(),
                        term.getDefinition()
                );
            }

            fuzzification += String.format( FISGenerator.fuzzificationBlockTemplate,
                    dependency.getId(),
                    terms
            );
        }

        return fuzzification;
    }

    /**
     * This method generates the rule block for a given Information instance
     * @param information   The Information instance for which the rule block is to be created
     * @return              Returns the rule block as a String
     */
    private static String composeRuleBlock( Information information )   {
        String ruleBlock = "";
        String ruleCondition = "";

        for( Rule rule : information.getRules() )
        {
            ruleCondition = FISGenerator.composeRuleCondition( rule.getLogicalBlock() );
            ruleBlock += String.format( FISGenerator.ruleTemplate,
                    rule.getName(),
                    ruleCondition,
                    rule.getValidity(),
                    rule.getWeight()
            );
        }

        return ruleBlock;
    }

    /**
     * This method generates individual rules to be inserted into a rule block
     * @param logicalBlock  The logical block holding the information for the rule
     * @return              Returns the rule as a String
     */
    private static String composeRuleCondition( LogicalBlock logicalBlock )   {
        String ruleCondition = "";
        if( logicalBlock != null )
        {
            if( logicalBlock.getOperator().equals("ATOMIC") ||logicalBlock.getOperator().equals("NOT") )
            {
                String ruleConditionValueNegator = ( logicalBlock.getOperator().equals( "ATOMIC" ) ) ? "" : "NOT ";
                ruleCondition = String.format("%s IS %s",
                        logicalBlock.getRuleItem().getInformationID(),
                        ruleConditionValueNegator + logicalBlock.getRuleItem().getTermID()
                );
            }
            else
            {
                List<String> ruleConditions = new ArrayList<String>();
                for( LogicalBlock logicalSubBlock : logicalBlock.getLogicalBlocks() )
                {
                    ruleConditions.add( FISGenerator.composeRuleCondition( logicalSubBlock) );
                }
                ruleCondition = String.join( String.format(" %s ", logicalBlock.getOperator()), ruleConditions );
            }
        }
        return ruleCondition;
    }
}
