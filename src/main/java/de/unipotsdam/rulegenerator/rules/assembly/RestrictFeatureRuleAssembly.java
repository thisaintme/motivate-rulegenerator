package de.unipotsdam.rulegenerator.rules.assembly;

import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintRequirement;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyRestrictFeatureConstraint;
import de.unipotsdam.rulegenerator.rules.AdaptationRule;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.FactSet;
import de.unipotsdam.rulegenerator.rules.LearningUnitClassFactSet;
import de.unipotsdam.rulegenerator.rules.Situation;
import de.unipotsdam.rulegenerator.rules.Trigger;

public class RestrictFeatureRuleAssembly extends RuleAssembly {
	private Collection<? extends MyRestrictFeatureConstraint> restrictFeatureConstraints;

	public RestrictFeatureRuleAssembly(OWLOntology ontology) {
		super();

		// create ORM object factory
		MyFactory factory = new MyFactory(ontology);

		this.ontology = ontology;
		this.restrictFeatureConstraints = factory
				.getAllFeatureConstraintInstances();
	}

	@Override
	public AdaptationRuleList generateRules(
			LearningUnitClassFactSet hasLearningUnitClassConstraintFactSet,
			LearningUnitClassFactSet hasNotLearningUnitClassConstraintFactSet)
			throws Exception {
		for (MyRestrictFeatureConstraint restrictFeatureConstraint : this.restrictFeatureConstraints) {
			AdaptationRule featureConstraintRule = new AdaptationRule(
					java.util.UUID.randomUUID().toString(),
					ActionOperator.RESTRICT_FEATURE, restrictFeatureConstraint
							.getFeature().getIRIShort());
			featureConstraintRule.setTrigger(new Trigger(
					TriggeringMode.ON_ENTRY));
			Situation featureConstraintRuleSituation = new Situation();
			int i = 0;
			for (MyConstraintRequirement constraintRequirement : restrictFeatureConstraint
					.getConstraintRequirements()) {
				featureConstraintRuleSituation.addRelationFact(FactSet
						.FactSetFromConstraintRequirement(
								constraintRequirement, true));
				if (i < restrictFeatureConstraint
						.getConstraintRequirementsCount() - 1)
					featureConstraintRuleSituation
							.addRelationFact(restrictFeatureConstraint
									.getLogicalOperator().getOpposite());
				i++;
			}
			featureConstraintRule.setSituation(featureConstraintRuleSituation);
			adaptationRules.addAdaptationRule(featureConstraintRule);
		}
		return adaptationRules;
	}

}
