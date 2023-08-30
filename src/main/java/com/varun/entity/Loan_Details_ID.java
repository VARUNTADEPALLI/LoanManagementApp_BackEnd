package com.varun.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class Loan_Details_ID implements Serializable{
	
	private String customerid;
	private String loanid;
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getLoanid() {
		return loanid;
	}
	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerid, loanid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan_Details_ID other = (Loan_Details_ID) obj;
		return Objects.equals(customerid, other.customerid) && Objects.equals(loanid, other.loanid);
	}
	

   

}
