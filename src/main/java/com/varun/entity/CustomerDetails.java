package com.varun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails {
	@Id
	@Column(name="CUSTOMER_ID")
	String customerId;	
	
	@Column(name="MOBILE_NUMBER")
	String mobilenumber;
	
	@Column(name="EMAIL_ID")
	String emailId;
	
	@Column(name="NAME")
	String name;

	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
