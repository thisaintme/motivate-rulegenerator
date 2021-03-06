package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.ContextInformation;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultContextInformation;

public class MyContextInformation extends DefaultContextInformation implements
		ContextInformation {

	public MyContextInformation(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Types

	public Set<OWLClassExpression> getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}

	// ID

	public String getSpecificContextInformationType() {
		return this.hasHasCID() ? this.getHasCID().toArray()[0].toString()
				: "NO_VALUE";
	}

	// Parameters

	public Boolean hasContextInformationParameters() {
		return this.getContextInformationParameterCount() > 0;
	}

	public Integer getContextInformationParameterCount() {
		return this.getContextInformationParameters().toArray().length;
	}

	public Collection<MyContextInformationParameter> getContextInformationParameters() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
				MyContextInformationParameter.class);
	}

	// Value Operator

	public String getValueOperator() {
		Object[] valuesOperators = this.getHasValueOperator().toArray();
		if (valuesOperators.length > 0)
			return valuesOperators[0].toString();
		else
			return "NO_VALUE";
	}

	public Collection<? extends String> getHasValueOperator() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASVALUEOPERATOR, String.class);
	}

	// Value

	public Object getValue() {
		if (this.getValues().toArray().length > 0)
			return getValues().toArray()[0];
		else
			return "NO_VALUE";
	}

	public Collection<? extends Object> getValues() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASVALUE, Object.class);
	}

}
