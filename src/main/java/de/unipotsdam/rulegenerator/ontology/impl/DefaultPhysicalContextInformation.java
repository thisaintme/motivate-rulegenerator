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
 * Source Class: DefaultPhysicalContextInformation <br>
 * @version generated on Tue Sep 02 15:45:18 CEST 2014 by tobias
 */
public class DefaultPhysicalContextInformation extends WrappedIndividualImpl implements PhysicalContextInformation {

    public DefaultPhysicalContextInformation(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://localhost:9998/owl/get-knowledge-ontology#hasContextInformationParameter
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


}
