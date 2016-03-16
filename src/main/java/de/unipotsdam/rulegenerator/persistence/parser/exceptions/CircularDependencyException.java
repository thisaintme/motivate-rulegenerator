package de.unipotsdam.rulegenerator.persistence.parser.exceptions;

public class CircularDependencyException extends Exception {
	
	public CircularDependencyException()   {}
	
	public CircularDependencyException(String message)   {
		super(message);
	}
}
