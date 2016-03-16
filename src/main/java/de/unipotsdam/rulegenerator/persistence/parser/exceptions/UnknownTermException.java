package de.unipotsdam.rulegenerator.persistence.parser.exceptions;

public class UnknownTermException extends Exception {
	public UnknownTermException() {}
	
	public UnknownTermException(String termId, String informationId)   {
		super( "Unkown term " + termId + " in " + informationId );
	}
}
