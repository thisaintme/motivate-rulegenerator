package de.unipotsdam.rulegenerator.persistence.parser;

public class RuleItem {
	private String informationID;
	private String termID;
	
	public RuleItem(String informationID, String termID) {
		super();
		this.informationID = informationID;
		this.termID = termID;
	}

	public String getInformationID() {
		return informationID;
	}

	public void setInformationID(String informationID) {
		this.informationID = informationID;
	}

	public String getTermID() {
		return termID;
	}

	public void setTermID(String termID) {
		this.termID = termID;
	}
}
