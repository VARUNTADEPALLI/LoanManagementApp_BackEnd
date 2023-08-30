package com.varun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="POLICY_DETAILS")
public class PolicyDetails {
	
	@Id
	@Column(name="ID")
	int id;
	
	@Column(name="COMPANY_NAME")
	String companyName;
	
	@Column(name="STATUS")
	String status;
	
	@Column(name="SCORE")
	int score;
	
	@Column(name="POLICY_TYPE")
	String policyType;
	
	@Id
	@Column(name="POLICY_ID")
	String policyId;
	
	@Id
	@Column(name="POLICY_NAME")
	String policyName;
	
	@Column(name="TYPE")
	String type;
	
	@Column(name="FACTOR")
	String factor;
	
	@Column(name="OPERATOR")
	String operator;
	
	@Column(name="VALUE1")
	String value1;
	
	@Column(name="VALUE2")
	String value2;
	
	@Column(name="CONTINUATION_OPERATOR")
	String continuationOperator;
			
	
	@Column(name="SUB_CONDITION_OPERATOR")
	String subConditionOperator;
	
	@Column(name="EXPRESSION")
	String expression;
	
	@Column(name="APPROVAL_STATUS")
	String approvalStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
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

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}	
}
