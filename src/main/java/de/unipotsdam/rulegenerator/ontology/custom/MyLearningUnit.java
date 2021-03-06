package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.CancelAction;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.StartAction;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAction;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCancelAction;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnit;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultStartAction;
import de.unipotsdam.rulegenerator.rules.Fact;
import de.unipotsdam.rulegenerator.rules.FactSet;
import de.unipotsdam.rulegenerator.rules.FactSetElement;

public class MyLearningUnit extends DefaultLearningUnit implements LearningUnit {
	public MyLearningUnit(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
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

	public LogicalOperator getLogicalOperator() {
		if (this.getLogicalOperators().toArray().length > 0)
			return LogicalOperator.valueOf(getLogicalOperators().toArray()[0]
					.toString());
		else
			return LogicalOperator.NO_VALUE;
	}

	public Collection<? extends Object> getLogicalOperators() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASLOGICALOPERATOR, Object.class);
	}

	// Context Information

	public Boolean hasContextInformation() {
		return this.getContextInformationCount() > 0;
	}

	public Integer getContextInformationCount() {
		return this.getContextInformation().toArray().length;
	}

	public Collection<? extends MyContextInformation> getContextInformation() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASMEASURABLECONTEXTINFORMATION,
				MyContextInformation.class);
	}

	// Relations

	public Boolean hasRelations() {
		return this.hasAlternatives() || this.hasPrerequisites()
				|| this.hasHelp() || this.hasVersions() || this.hasBases()
				|| this.hasReferences() || this.hasExtensions();
	}

	// Alternatives

	public Boolean hasAlternatives() {
		return this.getAlternativesCount() > 0;
	}

	public Integer getAlternativesCount() {
		return this.getAlternatives().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getAlternatives() {
		return getDelegate()
				.getPropertyValues(getOwlIndividual(),
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

	public Collection<? extends MyLearningUnit> getPrerequisites() {
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
				Vocabulary.OBJECT_PROPERTY_HASHELP, MyLearningUnit.class);
	}

	// Version

	public boolean hasVersions() {
		return this.getVersionsCount() > 0;
	}

	public Integer getVersionsCount() {
		return this.getVersions().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getVersions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASVERSION, MyLearningUnit.class);
	}

	// Bases

	public boolean hasBases() {
		return this.getBasesCount() > 0;
	}

	public Integer getBasesCount() {
		return this.getBases().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getBases() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASBASIS, MyLearningUnit.class);
	}

	// References

	public boolean hasReferences() {
		return this.getReferencesCount() > 0;
	}

	public Integer getReferencesCount() {
		return this.getReferences().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getReferences() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASREFERENCE, MyLearningUnit.class);
	}

	// Extensions

	public boolean hasExtensions() {
		return this.getExtensionsCount() > 0;
	}

	public Integer getExtensionsCount() {
		return this.getExtensions().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getExtensions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASEXTENSION, MyLearningUnit.class);
	}

	// Facts

	public FactSetElement getFacts() throws Exception {
		FactSetElement learningUnitFacts;
		if (this.getContextInformationCount() > 1) {
			learningUnitFacts = new FactSet();
			// create facts for the context information associated to the
			// learning
			// unit
			int i = 0;
			for (MyContextInformation contextInformation : this
					.getContextInformation()) {
				Fact learningUnitFact = Fact
						.FactFromContextInformation(contextInformation);
				((FactSet) learningUnitFacts).addFact(learningUnitFact);
				if (i < this.getContextInformationCount() - 1)
					((FactSet) learningUnitFacts).addLogicalOperator(this
							.getLogicalOperator());
				i++;
			}
		} else {
			learningUnitFacts = Fact
					.FactFromContextInformation((MyContextInformation) this
							.getContextInformation().toArray()[0]);
		}

		return learningUnitFacts;
	}

	// Meta Data

	public Boolean hasMetaData() {
		return this.getMetaDataCount() > 0;
	}

	public Integer getMetaDataCount() {
		return this
				.getDelegate()
				.getPropertyValues(getOwlIndividual(),
						Vocabulary.DATA_PROPERTY_HASMETADATA, Object.class)
				.toArray().length;
	}

	public MetaDataMap getMetaData() {
		return new MetaDataMap(getOwlIndividual(), getOwlOntology(),
				getDelegate());
	}

	// Actions

	public Boolean hasActions() {
		return this.getActionCount() > 0;
	}

	public Integer getActionCount() {
		return this.getActions().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getActions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_ISREFERENCEDBYACTION,
				DefaultAction.class);
	}

	// Cancel Actions

	public Boolean hasCancelActions() {
		return this.getCancelActionCount() > 0;
	}

	public Integer getCancelActionCount() {
		return this.getCancelActions().toArray().length;
	}

	public Collection<? extends CancelAction> getCancelActions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_ISREFERENCEDBYCANCELACTION,
				DefaultCancelAction.class);
	}

	// Start Actions

	public Boolean hasStartActions() {
		return this.getStartActionCount() > 0;
	}

	public Integer getStartActionCount() {
		return this.getStartActions().toArray().length;
	}

	public Collection<? extends StartAction> getStartActions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_ISREFERENCEDBYSTARTACTION,
				DefaultStartAction.class);
	}
}