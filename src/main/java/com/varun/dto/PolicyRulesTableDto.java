package com.varun.dto;

public class PolicyRulesTableDto {
	int id;
	String expression;
	String type;
	String factor;
	String operator;
	String value1;
	String value2;
	String continuationOperator;
	String subConditionOperator;
	String approvalStatus;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getContinuationOperator() {
		return continuationOperator;
	}
	public void setContinuationOperator(String continuationOperator) {
		this.continuationOperator = continuationOperator;
	}
	public String getSubConditionOperator() {
		return subConditionOperator;
	}
	public void setSubConditionOperator(String subConditionOperator) {
		this.subConditionOperator = subConditionOperator;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
}
