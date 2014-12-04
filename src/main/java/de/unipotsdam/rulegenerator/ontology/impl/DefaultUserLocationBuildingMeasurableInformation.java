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
 * Source Class: DefaultUserLocationBuildingMeasurableInformation <br>
 * @version generated on Thu Dec 04 13:00:54 CET 2014 by tobias
 */
public class DefaultUserLocationBuildingMeasurableInformation extends WrappedIndividualImpl implements UserLocationBuildingMeasurableInformation {

    public DefaultUserLocationBuildingMeasurableInformation(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://motivate-project.de/ontology/knowledge.owl#hasContextInformationParameter
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
     * Data Property http://motivate-project.de/ontology/knowledge.owl#hasValueOperator
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
