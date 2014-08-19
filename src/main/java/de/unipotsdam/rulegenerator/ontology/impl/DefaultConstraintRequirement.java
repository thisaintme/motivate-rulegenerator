package de.unipotsdam.rulegenerator.ontology.impl;

import de.unipotsdam.rulegenerator.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultConstraintRequirement <br>
 * @version generated on Tue Aug 19 13:30:58 CEST 2014 by tobias
 */
public class DefaultConstraintRequirement extends WrappedIndividualImpl implements ConstraintRequirement {

    public DefaultConstraintRequirement(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasEndTime
     */
     
    public Collection<? extends Object> getHasEndTime() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASENDTIME, Object.class);
    }

    public boolean hasHasEndTime() {
		return !getHasEndTime().isEmpty();
    }

    public void addHasEndTime(Object newHasEndTime) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASENDTIME, newHasEndTime);
    }

    public void removeHasEndTime(Object oldHasEndTime) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASENDTIME, oldHasEndTime);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasStartingTime
     */
     
    public Collection<? extends Object> getHasStartingTime() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASSTARTINGTIME, Object.class);
    }

    public boolean hasHasStartingTime() {
		return !getHasStartingTime().isEmpty();
    }

    public void addHasStartingTime(Object newHasStartingTime) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASSTARTINGTIME, newHasStartingTime);
    }

    public void removeHasStartingTime(Object oldHasStartingTime) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASSTARTINGTIME, oldHasStartingTime);
    }


}
