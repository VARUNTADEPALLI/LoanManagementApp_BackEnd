package com.varun.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Loan_Details")
public class LoanDetails {
	
	/*
	 * @EmbeddedId private Loan_Details_ID details_ID;
	 */
	
	
	
	@Id
	@Column(name="LOAN_ID")
	String loanId;
	
	@Id
	@Column(name="CUSTOMER_ID")
	String customerId;
	
	@Column(name="STATUS")
	String status;
	
	@Column(name="TERM")
	Integer term;
	
	
	@Column(name="LOAN_AMOUNT")
	BigDecimal loanAmount;
	
	@Column(name="REMAINING_TERM")
	Integer remainingTerm;
	
	@Column(name="NEXT_TERM")
	Integer nextTerm;
	
	@Column(name="LOAN_TYPE")
	String loanType;
	
	@Column(name="INTREST_RATE")
	BigDecimal intrestRate;
	
	@Column(name="INTREST_TYPE")
	String intrestType;
	
	@Column(name="CURRENCY")
	String currency;
	
	@Column(name="INSTALLMENT_AMOUNT")
	BigDecimal installmentAmount;
	
	@Column(name="FIRST_DUE_DATE")
	Date firstDueDate;
	

	@Column(name="FINAL_DUE_DATE")
	Date finalDueDate;
	
	@Column(name="CLOSURE_DATE")
	Date closureDate;
	
	@Column(name="DISBURSAL_DATE")
	Date disbursalDate;
	
	@Column(name="PAYMENT_FREQUENCY")
	String paymentFrequency;
	
	@Column(name="INTREST_AMOUNT")
	BigDecimal intrestAmount;
	
	@Column(name="TOTAL_LOANS")
	Integer totalLoans;
	
	@Column(name="ACTIVE_LOANS")
	Integer activeLoans;
	
	@Column(name="CLOSED_LOANS")
	Integer closedLoans;
	
	@Column(name="INTREST_START_DATE")
	Date intrestStartDate;
	
	@Column(name="BALANCE")
	BigDecimal balance;
	
	@Column(name="OVER_DUE_DAYS")
	int overDueDays;
	
	@Column(name="CURRENT_DUE_AMOUNT")
	BigDecimal currentDueAmount;
	
	@Column(name="OVER_DUE_AMOUNT")
	BigDecimal overDueAmount;
	
	@Column(name="THIRTY_DAYS")
	BigDecimal thirtyDays;
	
	@Column(name="SIXTY_DAYS")
	BigDecimal sixtyDays;
	
	@Column(name="NINETY_DAYS")
	BigDecimal ninetyDays;
	
	@Column(name="HUNDERD_AND_TWENTY_DAYS")
	BigDecimal oneTwentyDays;
	
	@Column(name="HUNDRED_AND_FIFTY_DAYS")
	BigDecimal oneFiftyDays;
	
	@Column(name="HUNDRED_AND_EIGHTY_DAYS")
	BigDecimal oneEightyDays;
	
	@Column(name="ONE_EIGHT_DAYS_PLUS")
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
