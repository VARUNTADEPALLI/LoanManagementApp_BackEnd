package com.varun.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class LoanCalculatorDto {

	BigDecimal loanAmount;
	BigDecimal remainingValue;
	double intrestRate;
	String interestType;
	int term;
	String paymentFrequency;
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public BigDecimal getRemainingValue() {
		return remainingValue;
	}
	public void setRemainingValue(BigDecimal remainingValue) {
		this.remainingValue = remainingValue;
	}
	public double getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}
	public String getInterestType() {
		return interestType;
	}
	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	
	
	

	
	
	
	
	
}
