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
 * Source Class: DefaultCancelAction <br>
 * @version generated on Mon Feb 09 12:46:05 CET 2015 by tobias
 */
public class DefaultCancelAction extends WrappedIndividualImpl implements CancelAction {

    public DefaultCancelAction(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Data Property http://motivate-project.de/ontology/knowledge.owl#hasAID
     */
     
    public Collection<? extends String> getHasAID() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAID, String.class);
    }

    public boolean hasHasAID() {
		return !getHasAID().isEmpty();
    }

    public void addHasAID(String newHasAID) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAID, newHasAID);
    }

    public void removeHasAID(String oldHasAID) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAID, oldHasAID);
    }


}
