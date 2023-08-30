package com.varun.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class ScheduleDto {

	BigDecimal totalInterestAmount;
	BigDecimal totalInstallmentAmount;
	BigDecimal totalPrincipal;
	BigDecimal loanAmount;
	BigDecimal remainingValue;
	BigDecimal installmentAmount;
	BigDecimal principal;
	BigDecimal interestAmount;
	BigDecimal principalOutstanding;
	Date firstDueDate;
	Date period;
	Date disbursalDate;
	double intrestRate;
	String interestType;
	int term;
	String paymentFrequency;
	
	
	
	
	public BigDecimal getTotalInterestAmount() {
		return totalInterestAmount;
	}
	public void setTotalInterestAmount(BigDecimal totalInterestAmount) {
		this.totalInterestAmount = totalInterestAmount;
	}
	public BigDecimal getTotalInstallmentAmount() {
		return totalInstallmentAmount;
	}
	public void setTotalInstallmentAmount(BigDecimal totalInstallmentAmount) {
		this.totalInstallmentAmount = totalInstallmentAmount;
	}
	public BigDecimal getTotalPrincipal() {
		return totalPrincipal;
	}
	public void setTotalPrincipal(BigDecimal totalPrincipal) {
		this.totalPrincipal = totalPrincipal;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public Date getDisbursalDate() {
		return disbursalDate;
	}
	public void setDisbursalDate(Date disbursalDate) {
		this.disbursalDate = disbursalDate;
	}
	public BigDecimal getPrincipal() {
		return principal;
	}
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	public BigDecimal getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}
	public BigDecimal getPrincipalOutstanding() {
		return principalOutstanding;
	}
	public void setPrincipalOutstanding(BigDecimal principalOutstanding) {
		this.principalOutstanding = principalOutstanding;
	}
	public BigDecimal getInstallmentAmount() {
		return installmentAmount;
	}
	public void setInstallmentAmount(BigDecimal installmentAmount) {
		this.installmentAmount = installmentAmount;
	
	}
	public Date getFirstDueDate() {
		return firstDueDate;
	}
	public void setFirstDueDate(Date firstDueDate) {
		this.firstDueDate = firstDueDate;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
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
	public BigDecimal getRemainingValue() {
		return remainingValue;
	}
	public void setRemainingValue(BigDecimal remainingValue) {
		this.remainingValue = remainingValue;
	}
	
	
	
	
	
}
