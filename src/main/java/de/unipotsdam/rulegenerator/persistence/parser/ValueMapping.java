package de.unipotsdam.rulegenerator.persistence.parser;

public class ValueMapping {
	
	private String source;
	private double target;
	
	public ValueMapping( String source, String target ) {
		super();
		this.source = source;
		this.target = Double.parseDouble( target );
	}
	
	public boolean isMatch( String source ) {
		return this.source.equals( source );
	}
	
	public double getTarget() {
		return this.target;
	}
}
