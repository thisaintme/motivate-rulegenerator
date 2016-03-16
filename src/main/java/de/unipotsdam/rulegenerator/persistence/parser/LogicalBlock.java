package de.unipotsdam.rulegenerator.persistence.parser;

import java.util.List;

public class LogicalBlock {
	private String operator;
	private List<LogicalBlock> logicalBlocks;
	private RuleItem ruleItem;

	public LogicalBlock(String operator, List<LogicalBlock> logicalBlocks, RuleItem ruleItem) {
		this.operator = operator;
		this.logicalBlocks = logicalBlocks;
		this.ruleItem = ruleItem;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<LogicalBlock> getLogicalBlocks() {
		return logicalBlocks;
	}

	public void setLogicalBlocks(List<LogicalBlock> logicalBlocks) {
		this.logicalBlocks = logicalBlocks;
	}

	public RuleItem getRuleItem() {
		return ruleItem;
	}

	public void setRuleItem(RuleItem ruleItem) {
		this.ruleItem = ruleItem;
	}
}
