package de.unipotsdam.rulegenerator.persistence.parser;

public class Rule {
	private String name;
	private String validity;
	private float weight;
	private LogicalBlock logicalBlock;

	public Rule(String name, String validity, float weight, LogicalBlock logicalBlock) {
		this.name = name;
		this.validity = validity;
		this.weight = weight;
		this.logicalBlock = logicalBlock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public LogicalBlock getLogicalBlock() {
		return logicalBlock;
	}

	public void setLogicalBlock(LogicalBlock logicalBlock) {
		this.logicalBlock = logicalBlock;
	}
}
