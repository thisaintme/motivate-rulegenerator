package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.List;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.MeasurableContextInformation;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnit;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMeasurableContextInformation;
import de.unipotsdam.rulegenerator.rules.Fact;
import de.unipotsdam.rulegenerator.rules.FactSet;

public class MyLearningUnit extends DefaultLearningUnit implements LearningUnit {
	public MyLearningUnit(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	public void description() {
		this.description(0, true);
	}

	public void description(Integer indent) {
		this.description(indent, true);
	}

	public void description(Integer indent, Boolean deep) {
		System.out.println(this.getIndentSpace(indent + 1) + "<IRI>"
				+ this.getIRIShort() + "</IRI>");
		System.out.println(this.getIndentSpace(indent + 1) + "<LID>"
				+ this.getID() + "</LID>");
		if (deep) {
			System.out.println(this.getIndentSpace(indent + 1)
					+ "<LogicalOperator>" + this.getLogicalOperator()
					+ "</LogicalOperator>");
			if (this.hasContextInformation()) {
				System.out.println(this.getIndentSpace(indent + 1)
						+ "<ContextInformation>");
				for (MyMeasurableContextInformation contextInformation : this
						.getContextInformation()) {
					contextInformation.description(indent + 2);
				}
				System.out.println(this.getIndentSpace(indent + 1)
						+ "</ContextInformation>");
			} else {
				System.out.println(this.getIndentSpace(indent + 1)
						+ "<ContextInformation/>");
			}
			if (this.hasRelations()) {
				System.out.println(this.getIndentSpace(indent + 1) + "<Relations>");
				if (this.hasAlternatives()) {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Alternatives>");
					for (WrappedIndividual alternative : this.getAlternatives()) {
						MyLearningUnit learningUnit = (MyLearningUnit) alternative;
						learningUnit.description(indent + 3, false);
					}
					System.out.println(this.getIndentSpace(indent + 2)
							+ "</Alternatives>");
				} else {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Alternatives/>");
				}
				if (this.hasPrerequisites()) {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Prerequisites>");
					for (WrappedIndividual prerequisite : this.getPrerequisites()) {
						MyLearningUnit learningUnit = (MyLearningUnit) prerequisite;
						learningUnit.description(indent + 3, false);
					}
					System.out.println(this.getIndentSpace(indent + 2)
							+ "</Prerequisites>");
				} else {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Prerequisites/>");
				}
				System.out
						.println(this.getIndentSpace(indent + 1) + "</Relations>");
			} else {
				System.out
						.println(this.getIndentSpace(indent + 1) + "<Relations/>");
			}
		}
	}

	// IRI

	public String getIRIShort() {
		return this.getOwlIndividual().getIRI().getFragment();
	}

	// ID

	public String getID() {
		Object[] ids = this.getHasLID().toArray();
		if (ids.length > 0)
			return (String) ids[0];
		else
			return "NO_VALUE";
	}

	// Logical Operator

	public String getLogicalOperator() {
		Object[] operators = this.getHasLearningUnitLogicalOperator().toArray();
		if (operators.length > 0)
			return (String) operators[0];
		else
			return "NO_VALUE";
	}

	// Context Information

	public Boolean hasContextInformation() {
		return this.getContextInformationCount() > 0;
	}

	public Integer getContextInformationCount() {
		return this.getContextInformation().toArray().length;
	}

	public Collection<MyMeasurableContextInformation> getContextInformation() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASMEASURABLECONTEXTINFORMATION,
				MyMeasurableContextInformation.class);
	}

	public Collection<? extends MeasurableContextInformation> getHasMeasurableContextInformation() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASMEASURABLECONTEXTINFORMATION,
				DefaultMeasurableContextInformation.class);
	}

	// Relations

	public Boolean hasRelations() {
		return this.hasAlternatives() || this.hasPrerequisites() || this.hasHelp();
	}

	// Alternatives

	public Boolean hasAlternatives() {
		return this.getAlternativesCount() > 0;
	}

	public Integer getAlternativesCount() {
		return this.getAlternatives().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getAlternatives() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASALTERNATIVE,
				MyLearningUnit.class);
	}
	
	// Prerequisite
	
	public Boolean hasPrerequisites() {
		return this.getPrerequisiteCount() > 0;
	}

	public Integer getPrerequisiteCount() {
		return this.getPrerequisites().toArray().length;
	}
	
	public Collection<? extends WrappedIndividual> getPrerequisites() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASPREREQUISITE,
				MyLearningUnit.class);
	}
	
	// Help

	public boolean hasHelp() {
		return this.getHelpCount() > 0;
	}
	
	public Integer getHelpCount() {
		return this.getHelp().toArray().length;
	}
	
	public Collection<? extends WrappedIndividual> getHelp() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASHELP,
				MyLearningUnit.class);
	}
	
	// Facts
	
	public FactSet getFacts() throws Exception {
		FactSet learningUnitFacts = new FactSet();
		// create facts for the context information associated to the learning unit
		int i = 0;
		for (MyMeasurableContextInformation contextInformation : this.getContextInformation()) {
			Fact learningUnitFact = new Fact();
			learningUnitFact.setContextInformation(contextInformation.getIRIShort());
			learningUnitFact.setValue(contextInformation.getValue().toString());
			learningUnitFact.setOperator(FactOperator.valueOf(contextInformation.getValueOperator()));
			learningUnitFacts.addFact(learningUnitFact);
			if (i < this.getContextInformationCount() - 1) learningUnitFacts.addLogicalOperator(LogicalOperator.valueOf(this.getLogicalOperator()));
			i++;
		}
		return learningUnitFacts;
	}
}