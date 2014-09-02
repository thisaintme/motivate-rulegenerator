package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: UserStateOfMindOptimismMeasurableInformation <br>
 * @version generated on Tue Sep 02 15:45:19 CEST 2014 by tobias
 */

public interface UserStateOfMindOptimismMeasurableInformation extends MeasurableContextInformation {

    /* ***************************************************
     * Property http://localhost:9998/owl/get-knowledge-ontology#hasContextInformationParameter
     */
     
    /**
     * Gets all property values for the hasContextInformationParameter property.<p>
     * 
     * @returns a collection of values for the hasContextInformationParameter property.
     */
    Collection<? extends ContextInformationParameter> getHasContextInformationParameter();

    /**
     * Checks if the class has a hasContextInformationParameter property value.<p>
     * 
     * @return true if there is a hasContextInformationParameter property value.
     */
    boolean hasHasContextInformationParameter();

    /**
     * Adds a hasContextInformationParameter property value.<p>
     * 
     * @param newHasContextInformationParameter the hasContextInformationParameter property value to be added
     */
    void addHasContextInformationParameter(ContextInformationParameter newHasContextInformationParameter);

    /**
     * Removes a hasContextInformationParameter property value.<p>
     * 
     * @param oldHasContextInformationParameter the hasContextInformationParameter property value to be removed.
     */
    void removeHasContextInformationParameter(ContextInformationParameter oldHasContextInformationParameter);


    /* ***************************************************
     * Property http://localhost:9998/owl/get-knowledge-ontology#hasValueOperator
     */
     
    /**
     * Gets all property values for the hasValueOperator property.<p>
     * 
     * @returns a collection of values for the hasValueOperator property.
     */
    Collection<? extends Object> getHasValueOperator();

    /**
     * Checks if the class has a hasValueOperator property value.<p>
     * 
     * @return true if there is a hasValueOperator property value.
     */
    boolean hasHasValueOperator();

    /**
     * Adds a hasValueOperator property value.<p>
     * 
     * @param newHasValueOperator the hasValueOperator property value to be added
     */
    void addHasValueOperator(Object newHasValueOperator);

    /**
     * Removes a hasValueOperator property value.<p>
     * 
     * @param oldHasValueOperator the hasValueOperator property value to be removed.
     */
    void removeHasValueOperator(Object oldHasValueOperator);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
