package com.varun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CODE_AND_VALUE")
public class CodeAndValues {
	
	@Id
	@Column(name="CODE")
	String code;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="NUMBER_OF_PAYMENTS")
	int numberOfPayments;
	
	@Column(name="VALUE")
	String value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNumberOfPayments() {
		return numberOfPayments;
	}

	public void setNumberOfPayments(int numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}
	
	
	
	
	

}
