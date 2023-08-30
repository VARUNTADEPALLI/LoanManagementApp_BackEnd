package com.varun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="POLICY_DETAIL")
public class PolicyDetail {
	
	@Id
	@Column(name="COMPANY_NAME")
	String companyName;
	
	@Column(name="STATUS")
	String status;
	
	@Column(name="SCORE")
	int score;
	
	@Column(name="POLICY_TYPE")
	String policyType;
	
	@Column(name="POLICY_ID")
	String policyId;
	
	@Column(name="POLICY_NAME")
	String policyName;

	

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

	
}
