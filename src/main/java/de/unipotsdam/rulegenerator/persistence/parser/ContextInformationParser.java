package de.unipotsdam.rulegenerator.persistence.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

import de.unipotsdam.rulegenerator.persistence.parser.exceptions.CircularDependencyException;
import de.unipotsdam.rulegenerator.persistence.parser.exceptions.UnknownDependencyException;
import de.unipotsdam.rulegenerator.persistence.parser.exceptions.UnknownTermException;

public class ContextInformationParser {

    private Element rootNode;
    private Hashtable<String, Element> informationNodes = new Hashtable<String, Element>();
    private Hashtable<String, Information> information = new Hashtable<String, Information>();
    private Hashtable<String, Information> resolvedInformationNodes = new Hashtable<String, Information>();
    private List<String> seenInformationNodes = new ArrayList<String>();

    public ContextInformationParser() throws ParserConfigurationException, SAXException, IOException, JDOMException, Exception   {
        this.parseContextInformationXML();
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JDOMException, Exception   {
        ContextInformationParser main = new ContextInformationParser();
        main.parseContextInformationXML();
        System.out.println( "Information Data Structure valid" );
    }

    public Hashtable<String, Information> getResolvedInformationNodes()   {
        return this.resolvedInformationNodes;
    }

    /**
     * This method controls the reading and parsing of the measurable-context-information.xml file and creates instances needed to validate the measured values
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws JDOMException
     * @throws Exception
     */
    private void parseContextInformationXML() throws ParserConfigurationException, SAXException, IOException, JDOMException, Exception   {
		/*
		 * #############################
		 * Initialization
		 * #############################
		 */
        String FILE_NAME = "src/FuzzyControl/measurable-context-information.xml";
        SAXBuilder builder = new SAXBuilder();
        File file = new File(FILE_NAME);
        Document document = null;
        if ( ! (file.exists() && file.canRead()) ) {
            System.err.println("Error: cannot read "+ FILE_NAME + ".Exiting now.");
            System.exit(1);
        }

        try
        {
            document = (Document) builder.build(file);
        }
        catch( JDOMParseException e )
        {
            e.printStackTrace();
            System.exit(1);
        }


        // load root node containing information nodes
        ElementFilter contextInformationFilter = new ElementFilter("contextInformation");
        List<Element> contextInformationNodes = document.getContent(contextInformationFilter);
        this.rootNode = (Element) contextInformationNodes.get(0);

        // compile hash table with information nodes for quicker retrieval
        for(Element informationNode : this.rootNode.getContent(new ElementFilter("information")))
        {
            this.informationNodes.put(informationNode.getAttribute("id").getValue(), informationNode);
        }

		/*
		 * #############################
		 * Parsing and validation
		 * #############################
		 */
        for(String informationID : this.informationNodes.keySet())
        {
            if(!this.information.containsKey(informationID))
            {
                this.parseInformationNode(informationID);
            }
        }

        /*
		 * #############################
		 * validate rules (use of context and term IDs)
		 * #############################
		 */
        Information currentInformation;
        for( String informationID : this.resolvedInformationNodes.keySet() )
        {
            currentInformation = this.resolvedInformationNodes.get( informationID );
            for( Rule currentRule : currentInformation.getRules() )
            {
                this.verifyLogicalBlock( currentRule.getLogicalBlock() );
            }
        }
    }

    /**
     * This method returns the complete information node for a context information specified by an ID.
     * @param id	the id identifying the requested information node
     * @return		the element found, may also be an empty element instance
     */
    private Element getInformationNodeByID(String id)   {
        Element candidate = (this.informationNodes.containsKey(id)) ? this.informationNodes.get(id) : new Element("information");
        return candidate;
    }

    /**
     * This method parses an information
     * @param informationID						the ID of the node to be parsed
     * @return									returns an Information instance
     * @throws CircularDependencyException		in case a circular dependency is detected this exception is thrown
     * @throws UnknownDependencyException
     * @throws UnknownTermException
     */
    private Information parseInformationNode(String informationID) throws CircularDependencyException, UnknownDependencyException, UnknownTermException   {
        // read multiplicity
        boolean multiplicity = false;
        Element informationNode = this.getInformationNodeByID(informationID);
        if( informationNode == null )
        {
            throw new UnknownDependencyException( informationID );
        }
        if( informationNode.getAttribute( "multiplicity" ).getValue().equals( "MULTIPLE" ) )
        {
            multiplicity = true;
        }

        // get rules
        List<Rule> rules = this.parseRulesNode(informationID);

        // get terms
        List<Term> terms = this.parseTermsNode(informationID);

        // get value mappings
        List<ValueMapping> valueMappings = this.getValueMappings(informationID);

        // get dependencies
        List<Information> dependencies = this.buildDependencyGraph(informationID, multiplicity, terms, valueMappings);

        Information information = new Information(informationID, multiplicity, terms, dependencies, rules, valueMappings);

        // attach this information to resolved items
        resolvedInformationNodes.put(informationID, information);

        return information;
    }

    /**
     * This method parses the rule nodes of an information node
     * @param informationID		the ID of the node which will be used to fetch the node
     * @return					returns a list of Rule instances
     * @throws UnknownTermException
     */
    private List<Rule> parseRulesNode(String informationID) throws UnknownTermException   {
        Element informationNode = this.getInformationNodeByID(informationID);
        List<Rule> rules = new ArrayList<Rule>();

        Element validityNode = informationNode.getChild("validity");
        Element rulesNode = validityNode.getChild("rules");
        List<Element> ruleNodes = rulesNode.getContent(new ElementFilter("rule"));

        for(Element ruleNode : ruleNodes)
        {
            String name = ruleNode.getAttributeValue("name");
            String validity = ruleNode.getAttributeValue("validity");
            float weight = Float.parseFloat(ruleNode.getAttributeValue("weight"));
            LogicalBlock logicalBlock = this.parseLogicalBlockNode(ruleNode.getChild("logicalBlock"));

            rules.add( new Rule(name, validity, weight, logicalBlock) );
        }

        return rules;
    }

    /**
     * This method parses the term nodes of an information node
     * @param informationID		the ID of the node which will be used to fetch the node
     * @return					returns a list of Term instances
     */
    private List<Term> parseTermsNode(String informationID)   {
        Element informationNode = this.getInformationNodeByID(informationID);
        List<Term> terms = new ArrayList<Term>();

        Element validityNode = informationNode.getChild("validity");
        Element termsNode = validityNode.getChild("terms");
        List<Element> termNodes = termsNode.getContent(new ElementFilter("term"));

        for(Element termNode : termNodes)
        {
            String name = termNode.getAttributeValue("name");
            String definition = termNode.getAttributeValue("definition");

            terms.add( new Term(name, definition) );
        }

        return terms;
    }

    /**
     * This method recursively parses a logical block and all its child logical blocks
     * @param logicalBlockNode	the node representation of the logical block to be parsed
     * @return					returns a LogicalBlock instance
     * @throws UnknownTermException
     */
    private LogicalBlock parseLogicalBlockNode(Element logicalBlockNode) throws UnknownTermException   {
        LogicalBlock logicalBlock = null;

        if(logicalBlockNode != null)
        {
            List<Element> logicalBlockChildNodes = logicalBlockNode.getContent(new ElementFilter("logicalBlock"));
            List<LogicalBlock> logicalBlocks = new ArrayList<LogicalBlock>();
            String operator = logicalBlockNode.getAttributeValue("operator");
            RuleItem ruleItem = null;

            if(logicalBlockChildNodes.size() == 0)
            {
                // look for rule item
                Element ruleItemNode = logicalBlockNode.getChild("ruleItem");
                String informationID = ruleItemNode.getAttributeValue("informationID");
                String termID = ruleItemNode.getAttributeValue("termID");
                ruleItem = new RuleItem(informationID, termID);
            }

            for(Element logicalBlockChildNode : logicalBlockChildNodes)
            {
                // recursive parsing of child logical blocks
                logicalBlocks.add(this.parseLogicalBlockNode(logicalBlockChildNode));
            }
            logicalBlock = new LogicalBlock(operator, logicalBlocks, ruleItem);
        }

        return logicalBlock;
    }

    /**
     * This method builds the dependency graph for the node specified by the information ID
     * @param informationID					the information id identifying the information node for which the graph shall be built
     * @throws CircularDependencyException	throws CircularDependencyException if circular dependency is encountered
     * @throws UnknownDependencyException
     * @throws UnknownTermException
     */
    private List<Information> buildDependencyGraph(String informationID, boolean multiplicity, List<Term> selfTerms, List<ValueMapping> selfValueMappings) throws CircularDependencyException, UnknownDependencyException, UnknownTermException   {
        Element informationNode = this.getInformationNodeByID(informationID);
        List<Element> dependencyNodes = this.getDependencies(informationNode);
        List<Information> dependencies = new ArrayList<Information>();
        String tempInformationID = "";

        for(Element dependencyNode : dependencyNodes)
        {
            tempInformationID = dependencyNode.getAttribute("id").getValue();
            if(!this.resolvedInformationNodes.containsKey(tempInformationID))
            {
                if( !dependencyNode.getAttribute("id").getValue().equals( informationID )  )
                {
                    // if current node has not been resolved
                    if(!this.seenInformationNodes.contains(tempInformationID))
                    {
                        // it's either not been visited/seen yet, so try to resolve it
                        dependencies.add( this.parseInformationNode(tempInformationID) );
                    }
                    else
                    {
                        // or it's already been seen and thus a circular dependency
                        throw new CircularDependencyException("Circular dependency: " + informationID + " depending on " + tempInformationID);
                    }
                }
                else
                {
                    // insert self reference
                    dependencies.add( new Information( informationID, multiplicity, selfTerms, new ArrayList<Information>(), new ArrayList<Rule>(), selfValueMappings ) );
                }
            }
            else
            {
                // inserted already parsed nodes
                dependencies.add( this.resolvedInformationNodes.get( tempInformationID ) );
            }
        }

        return dependencies;
    }

    /**
     * This method returns a list of complete node elements that are referenced as dependencies in the validation process of a given context information.
     * @param informationNode	the complete information node instance for which the dependencies shall be retrieved
     * @return					the list of node elements on which the validity of the given node element depends
     */
    private List<Element> getDependencies(Element informationNode)   {
        List<Element> dependencies = new ArrayList<Element>();

        Element validityNode = informationNode.getChild( "validity" );
        if(validityNode != null)
        {
            Element dependenciesNode = validityNode.getChild( "dependencies" );
            if(dependenciesNode != null)
            {
                Element currentDependencyNode;
                for(Element dependencyNode : dependenciesNode.getChildren())
                {
                    // collect referenced nodes and add them to dependencies list
                    currentDependencyNode = ( !dependencyNode.getAttribute( "informationID" ).getValue().equals( "self" ) ) ? this.getInformationNodeByID( dependencyNode.getAttribute( "informationID" ).getValue() ) : informationNode;
                    dependencies.add( currentDependencyNode );
                }
            }
        }
        return dependencies;
    }

    /**
     * This method returns a list of value mappings for an information node.
     * @param informationID 	the information id identifying the information node for which the value mappings shall be retrieved
     * @return					the list of value mappings found in the element node
     */
    private List<ValueMapping> getValueMappings(String informationID) {
        Element informationNode = this.getInformationNodeByID(informationID);
        List<ValueMapping> valueMappings = new ArrayList<ValueMapping>();

        Element validityNode = informationNode.getChild( "validity" );
        if(validityNode != null)
        {
            Element valuePreprocessingNode = validityNode.getChild( "valuePreprocessing" );
            if( valuePreprocessingNode != null )
            {
                List<Element> valueMappingNodes = valuePreprocessingNode.getContent( new ElementFilter("valueMapping") );

                for( Element valueMappingNode : valueMappingNodes)
                {
                    valueMappings.add(
                            new ValueMapping( valueMappingNode.getAttributeValue("source"), valueMappingNode.getAttributeValue("target") )
                    );
                }
            }
        }

        return valueMappings;
    }

    private void verifyLogicalBlock( LogicalBlock logicalBlock ) throws UnknownTermException {

        if( logicalBlock.getRuleItem() != null )
        {
            this.resolvedInformationNodes.get( logicalBlock.getRuleItem().getInformationID() ).hasLinguisticTerm( logicalBlock.getRuleItem().getTermID() );
        }
        else
        {
            for( LogicalBlock currentLogicalBlock : logicalBlock.getLogicalBlocks() )
            {
                this.verifyLogicalBlock( currentLogicalBlock );
            }
        }

    }
}
