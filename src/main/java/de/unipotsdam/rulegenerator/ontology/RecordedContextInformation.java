package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: RecordedContextInformation <br>
 * @version generated on Thu Dec 04 13:00:54 CET 2014 by tobias
 */

public interface RecordedContextInformation extends ContextInformation {

    /* ***************************************************
     * Property http://motivate-project.de/ontology/knowledge.owl#hasContextInformationParameter
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
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
