package com.varun.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;


public class LoanStatusDTO implements Serializable{
	
	String loanId;
	String customerId;
	String status;
	Integer term;
	BigDecimal loanAmount;	
	Integer remainingTerm;
	Integer nextTerm;
	String loanType;
	BigDecimal intrestRate;
	String intrestType;
	String currency;
	BigDecimal installmentAmount;
	Date firstDueDate;
	Date finalDueDate;
	Date closureDate;
	Date disbursalDate;
	String paymentFrequency;
	BigDecimal intrestAmount;
	Integer totalLoans;
	Integer activeLoans;
	Integer closedLoans;
	Date intrestStartDate;
	String mobilenumber;
	String name;
	String emailId;
	BigDecimal balance;
	int overDueDays;
	BigDecimal currentDueAmount;
	BigDecimal overDueAmount;
	BigDecimal thirtyDays;
	BigDecimal sixtyDays;
	BigDecimal ninetyDays;
	BigDecimal oneTwentyDays;
	BigDecimal oneFiftyDays;
	BigDecimal oneEightyDays;
	BigDecimal oneEightyDaysPlus;
	
	
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getRemainingTerm() {
		return remainingTerm;
	}
	public void setRemainingTerm(Integer remainingTerm) {
		this.remainingTerm = remainingTerm;
	}
	public Integer getNextTerm() {
		return nextTerm;
	}
	public void setNextTerm(Integer nextTerm) {
		this.nextTerm = nextTerm;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public BigDecimal getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(BigDecimal intrestRate) {
		this.intrestRate = intrestRate;
	}
	public String getIntrestType() {
		return intrestType;
	}
	public void setIntrestType(String intrestType) {
		this.intrestType = intrestType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	public Date getFinalDueDate() {
		return finalDueDate;
	}
	public void setFinalDueDate(Date finalDueDate) {
		this.finalDueDate = finalDueDate;
	}
	public Date getClosureDate() {
		return closureDate;
	}
	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}
	public Date getDisbursalDate() {
		return disbursalDate;
	}
	public void setDisbursalDate(Date disbursalDate) {
		this.disbursalDate = disbursalDate;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	public BigDecimal getIntrestAmount() {
		return intrestAmount;
	}
	public void setIntrestAmount(BigDecimal intrestAmount) {
		this.intrestAmount = intrestAmount;
	}
	public Integer getTotalLoans() {
		return totalLoans;
	}
	public void setTotalLoans(Integer totalLoans) {
		this.totalLoans = totalLoans;
	}
	public Integer getActiveLoans() {
		return activeLoans;
	}
	public void setActiveLoans(Integer activeLoans) {
		this.activeLoans = activeLoans;
	}
	public Integer getClosedLoans() {
		return closedLoans;
	}
	public void setClosedLoans(Integer closedLoans) {
		this.closedLoans = closedLoans;
	}
	public Date getIntrestStartDate() {
		return intrestStartDate;
	}
	public void setIntrestStartDate(Date intrestStartDate) {
		this.intrestStartDate = intrestStartDate;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public int getOverDueDays() {
		return overDueDays;
	}
	public void setOverDueDays(int overDueDays) {
		this.overDueDays = overDueDays;
	}
	public BigDecimal getCurrentDueAmount() {
		return currentDueAmount;
	}
	public void setCurrentDueAmount(BigDecimal currentDueAmount) {
		this.currentDueAmount = currentDueAmount;
	}
	public BigDecimal getOverDueAmount() {
		return overDueAmount;
	}
	public void setOverDueAmount(BigDecimal overDueAmount) {
		this.overDueAmount = overDueAmount;
	}
	public BigDecimal getThirtyDays() {
		return thirtyDays;
	}
	public void setThirtyDays(BigDecimal thirtyDays) {
		this.thirtyDays = thirtyDays;
	}
	public BigDecimal getSixtyDays() {
		return sixtyDays;
	}
	public void setSixtyDays(BigDecimal sixtyDays) {
		this.sixtyDays = sixtyDays;
	}
	public BigDecimal getNinetyDays() {
		return ninetyDays;
	}
	public void setNinetyDays(BigDecimal ninetyDays) {
		this.ninetyDays = ninetyDays;
	}
	public BigDecimal getOneTwentyDays() {
		return oneTwentyDays;
	}
	public void setOneTwentyDays(BigDecimal oneTwentyDays) {
		this.oneTwentyDays = oneTwentyDays;
	}
	public BigDecimal getOneFiftyDays() {
		return oneFiftyDays;
	}
	public void setOneFiftyDays(BigDecimal oneFiftyDays) {
		this.oneFiftyDays = oneFiftyDays;
	}
	public BigDecimal getOneEightyDays() {
		return oneEightyDays;
	}
	public void setOneEightyDays(BigDecimal oneEightyDays) {
		this.oneEightyDays = oneEightyDays;
	}
	public BigDecimal getOneEightyDaysPlus() {
		return oneEightyDaysPlus;
	}
	public void setOneEightyDaysPlus(BigDecimal oneEightyDaysPlus) {
		this.oneEightyDaysPlus = oneEightyDaysPlus;
	}
	
	
	
	
	
	
	
}
