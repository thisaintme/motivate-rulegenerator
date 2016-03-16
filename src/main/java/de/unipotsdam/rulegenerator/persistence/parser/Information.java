package de.unipotsdam.rulegenerator.persistence.parser;

import java.util.List;
import de.unipotsdam.rulegenerator.persistence.parser.exceptions.UnknownTermException;

public class Information {
	private String id;
	private boolean multiplicity;
	private List<Term> terms;
	private List<Information> dependencies;
	private List<Rule> rules;
	private List<ValueMapping> valueMappings;

	public Information(String id, boolean multiplicity, List<Term> terms, List<Information> dependencies, List<Rule> rules, List<ValueMapping> valueMappings)   {
		this.setId(id);
		this.setMultiplicity(multiplicity);
		this.setTerms(terms);
		this.setDependencies(dependencies);
		this.setRules(rules);
		this.valueMappings = valueMappings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity( boolean multiplicity ) {
		this.multiplicity = multiplicity;
	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	public List<Information> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Information> dependencies) {
		this.dependencies = dependencies;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	/**
	 * This method maps the input value of a Reason instance onto a numeric value
	 * @param rawValue		The raw input value
	 * @return				Returns a numeric value
	 */
	public double preprocessValue( String rawValue ) {
		double value = 0;
		if( this.valueMappings.size() == 0 )
		{
			// no value mappings defined; try to directly parse the raw value to float
			try
			{
				value = Float.parseFloat( rawValue );
			}
			catch( NumberFormatException exception )
			{
				value = 0;
			}
		}
		else
		{
			// try to map value
			for( ValueMapping valueMapping : this.valueMappings )
			{
				if( valueMapping.isMatch(rawValue) )
				{
					value = valueMapping.getTarget();
					break;
				}
			}
		}

		return value;
	}

	/**
	 * This method checks if this context information features a given term ID
	 * @param termId	The ID/Name of a linguistic term
	 * @return			Returns if or if not the term exists
	 * @throws UnknownTermException
	 */
	public boolean hasLinguisticTerm( String termId ) throws UnknownTermException {
		boolean termExists = false;

		for( Term term : this.terms)
		{
			if( term.getName().equals( termId ) )
			{
				termExists = true;
				break;
			}
		}

		if( !termExists )
		{
			throw new UnknownTermException( termId, this.id );
		}

		return termExists;
	}
}
