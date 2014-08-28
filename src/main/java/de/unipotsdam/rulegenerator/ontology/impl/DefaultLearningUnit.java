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
 * Source Class: DefaultLearningUnit <br>
 * @version generated on Wed Aug 27 16:33:38 CEST 2014 by tobias
 */
public class DefaultLearningUnit extends WrappedIndividualImpl implements LearningUnit {

    public DefaultLearningUnit(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.motivate-project.de/ontologies/knowledge#hasAlternative
     */
     
    public Collection<? extends WrappedIndividual> getHasAlternative() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASALTERNATIVE,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasAlternative() {
	   return !getHasAlternative().isEmpty();
    }

    public void addHasAlternative(WrappedIndividual newHasAlternative) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASALTERNATIVE,
                                       newHasAlternative);
    }

    public void removeHasAlternative(WrappedIndividual oldHasAlternative) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASALTERNATIVE,
                                          oldHasAlternative);
    }


    /* ***************************************************
     * Object Property http://www.motivate-project.de/ontologies/knowledge#hasContextInformation
     */
     
    public Collection<? extends WrappedIndividual> getHasContextInformation() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATION,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasContextInformation() {
	   return !getHasContextInformation().isEmpty();
    }

    public void addHasContextInformation(WrappedIndividual newHasContextInformation) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATION,
                                       newHasContextInformation);
    }

    public void removeHasContextInformation(WrappedIndividual oldHasContextInformation) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATION,
                                          oldHasContextInformation);
    }


    /* ***************************************************
     * Object Property http://www.motivate-project.de/ontologies/knowledge#hasPrerequisite
     */
     
    public Collection<? extends WrappedIndividual> getHasPrerequisite() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASPREREQUISITE,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasPrerequisite() {
	   return !getHasPrerequisite().isEmpty();
    }

    public void addHasPrerequisite(WrappedIndividual newHasPrerequisite) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASPREREQUISITE,
                                       newHasPrerequisite);
    }

    public void removeHasPrerequisite(WrappedIndividual oldHasPrerequisite) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASPREREQUISITE,
                                          oldHasPrerequisite);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasAuthor
     */
     
    public Collection<? extends String> getHasAuthor() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAUTHOR, String.class);
    }

    public boolean hasHasAuthor() {
		return !getHasAuthor().isEmpty();
    }

    public void addHasAuthor(String newHasAuthor) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAUTHOR, newHasAuthor);
    }

    public void removeHasAuthor(String oldHasAuthor) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAUTHOR, oldHasAuthor);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasContentType
     */
     
    public Collection<? extends String> getHasContentType() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONTENTTYPE, String.class);
    }

    public boolean hasHasContentType() {
		return !getHasContentType().isEmpty();
    }

    public void addHasContentType(String newHasContentType) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONTENTTYPE, newHasContentType);
    }

    public void removeHasContentType(String oldHasContentType) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONTENTTYPE, oldHasContentType);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasDifficulty
     */
     
    public Collection<? extends Object> getHasDifficulty() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDIFFICULTY, Object.class);
    }

    public boolean hasHasDifficulty() {
		return !getHasDifficulty().isEmpty();
    }

    public void addHasDifficulty(Object newHasDifficulty) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDIFFICULTY, newHasDifficulty);
    }

    public void removeHasDifficulty(Object oldHasDifficulty) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDIFFICULTY, oldHasDifficulty);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasInteractivity
     */
     
    public Collection<? extends Boolean> getHasInteractivity() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINTERACTIVITY, Boolean.class);
    }

    public boolean hasHasInteractivity() {
		return !getHasInteractivity().isEmpty();
    }

    public void addHasInteractivity(Boolean newHasInteractivity) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINTERACTIVITY, newHasInteractivity);
    }

    public void removeHasInteractivity(Boolean oldHasInteractivity) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINTERACTIVITY, oldHasInteractivity);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasKeyword
     */
     
    public Collection<? extends String> getHasKeyword() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASKEYWORD, String.class);
    }

    public boolean hasHasKeyword() {
		return !getHasKeyword().isEmpty();
    }

    public void addHasKeyword(String newHasKeyword) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASKEYWORD, newHasKeyword);
    }

    public void removeHasKeyword(String oldHasKeyword) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASKEYWORD, oldHasKeyword);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasLID
     */
     
    public Collection<? extends String> getHasLID() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLID, String.class);
    }

    public boolean hasHasLID() {
		return !getHasLID().isEmpty();
    }

    public void addHasLID(String newHasLID) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLID, newHasLID);
    }

    public void removeHasLID(String oldHasLID) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLID, oldHasLID);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasLanguage
     */
     
    public Collection<? extends Object> getHasLanguage() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLANGUAGE, Object.class);
    }

    public boolean hasHasLanguage() {
		return !getHasLanguage().isEmpty();
    }

    public void addHasLanguage(Object newHasLanguage) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLANGUAGE, newHasLanguage);
    }

    public void removeHasLanguage(Object oldHasLanguage) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLANGUAGE, oldHasLanguage);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasSubject
     */
     
    public Collection<? extends String> getHasSubject() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASSUBJECT, String.class);
    }

    public boolean hasHasSubject() {
		return !getHasSubject().isEmpty();
    }

    public void addHasSubject(String newHasSubject) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASSUBJECT, newHasSubject);
    }

    public void removeHasSubject(String oldHasSubject) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASSUBJECT, oldHasSubject);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasTrigger
     */
     
    public Collection<? extends Integer> getHasTrigger() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASTRIGGER, Integer.class);
    }

    public boolean hasHasTrigger() {
		return !getHasTrigger().isEmpty();
    }

    public void addHasTrigger(Integer newHasTrigger) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASTRIGGER, newHasTrigger);
    }

    public void removeHasTrigger(Integer oldHasTrigger) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASTRIGGER, oldHasTrigger);
    }


    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasVersionDate
     */
     
    public Collection<? extends Object> getHasVersionDate() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVERSIONDATE, Object.class);
    }

    public boolean hasHasVersionDate() {
		return !getHasVersionDate().isEmpty();
    }

    public void addHasVersionDate(Object newHasVersionDate) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVERSIONDATE, newHasVersionDate);
    }

    public void removeHasVersionDate(Object oldHasVersionDate) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVERSIONDATE, oldHasVersionDate);
    }


}
