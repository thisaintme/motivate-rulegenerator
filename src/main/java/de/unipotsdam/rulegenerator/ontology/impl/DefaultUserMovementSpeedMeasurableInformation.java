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
 * Source Class: DefaultUserMovementSpeedMeasurableInformation <br>
 * @version generated on Tue Aug 19 13:30:58 CEST 2014 by tobias
 */
public class DefaultUserMovementSpeedMeasurableInformation extends WrappedIndividualImpl implements UserMovementSpeedMeasurableInformation {

    public DefaultUserMovementSpeedMeasurableInformation(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.motivate-project.de/ontologies/knowledge#hasContextInformationParameter
     */
     
    public Collection<? extends ContextInformationParameter> getHasContextInformationParameter() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
                                               DefaultContextInformationParameter.class);
    }

    public boolean hasHasContextInformationParameter() {
	   return !getHasContextInformationParameter().isEmpty();
    }

    public void addHasContextInformationParameter(ContextInformationParameter newHasContextInformationParameter) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
                                       newHasContextInformationParameter);
    }

    public void removeHasContextInformationParameter(ContextInformationParameter oldHasContextInformationParameter) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
                                          oldHasContextInformationParameter);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasValueOperator
     */
     
    public Collection<? extends Object> getHasValueOperator() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUEOPERATOR, Object.class);
    }

    public boolean hasHasValueOperator() {
		return !getHasValueOperator().isEmpty();
    }

    public void addHasValueOperator(Object newHasValueOperator) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUEOPERATOR, newHasValueOperator);
    }

    public void removeHasValueOperator(Object oldHasValueOperator) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUEOPERATOR, oldHasValueOperator);
    }


}
