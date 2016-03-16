package de.unipotsdam.rulegenerator.persistence.parser.exceptions;

public class UnknownDependencyException extends Exception {
	public UnknownDependencyException() {}
	
	public UnknownDependencyException( String dependencyId )   {
		super( "Unkown reference to " + dependencyId );
	}
}
