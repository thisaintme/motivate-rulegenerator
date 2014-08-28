package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: LearningUnitClassConstraint <br>
 * @version generated on Wed Aug 27 16:33:38 CEST 2014 by tobias
 */

public interface LearningUnitClassConstraint extends Constraint {

    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasLearningUnitConstraintMetaDataLogicalOperator
     */
     
    /**
     * Gets all property values for the hasLearningUnitConstraintMetaDataLogicalOperator property.<p>
     * 
     * @returns a collection of values for the hasLearningUnitConstraintMetaDataLogicalOperator property.
     */
    Collection<? extends Object> getHasLearningUnitConstraintMetaDataLogicalOperator();

    /**
     * Checks if the class has a hasLearningUnitConstraintMetaDataLogicalOperator property value.<p>
     * 
     * @return true if there is a hasLearningUnitConstraintMetaDataLogicalOperator property value.
     */
    boolean hasHasLearningUnitConstraintMetaDataLogicalOperator();

    /**
     * Adds a hasLearningUnitConstraintMetaDataLogicalOperator property value.<p>
     * 
     * @param newHasLearningUnitConstraintMetaDataLogicalOperator the hasLearningUnitConstraintMetaDataLogicalOperator property value to be added
     */
    void addHasLearningUnitConstraintMetaDataLogicalOperator(Object newHasLearningUnitConstraintMetaDataLogicalOperator);

    /**
     * Removes a hasLearningUnitConstraintMetaDataLogicalOperator property value.<p>
     * 
     * @param oldHasLearningUnitConstraintMetaDataLogicalOperator the hasLearningUnitConstraintMetaDataLogicalOperator property value to be removed.
     */
    void removeHasLearningUnitConstraintMetaDataLogicalOperator(Object oldHasLearningUnitConstraintMetaDataLogicalOperator);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasLearningUnitConstraintRequirementLogicalOperator
     */
     
    /**
     * Gets all property values for the hasLearningUnitConstraintRequirementLogicalOperator property.<p>
     * 
     * @returns a collection of values for the hasLearningUnitConstraintRequirementLogicalOperator property.
     */
    Collection<? extends Object> getHasLearningUnitConstraintRequirementLogicalOperator();

    /**
     * Checks if the class has a hasLearningUnitConstraintRequirementLogicalOperator property value.<p>
     * 
     * @return true if there is a hasLearningUnitConstraintRequirementLogicalOperator property value.
     */
    boolean hasHasLearningUnitConstraintRequirementLogicalOperator();

    /**
     * Adds a hasLearningUnitConstraintRequirementLogicalOperator property value.<p>
     * 
     * @param newHasLearningUnitConstraintRequirementLogicalOperator the hasLearningUnitConstraintRequirementLogicalOperator property value to be added
     */
    void addHasLearningUnitConstraintRequirementLogicalOperator(Object newHasLearningUnitConstraintRequirementLogicalOperator);

    /**
     * Removes a hasLearningUnitConstraintRequirementLogicalOperator property value.<p>
     * 
     * @param oldHasLearningUnitConstraintRequirementLogicalOperator the hasLearningUnitConstraintRequirementLogicalOperator property value to be removed.
     */
    void removeHasLearningUnitConstraintRequirementLogicalOperator(Object oldHasLearningUnitConstraintRequirementLogicalOperator);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
