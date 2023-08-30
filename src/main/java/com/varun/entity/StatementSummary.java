package com.varun.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="STATEMENT_SUMMARY")

public class StatementSummary {
	
	@Id
	@Column(name="STATEMENT_DATE")
	Date statementDate;
	
	@Column(name="LOAN_ID")
	String loanId;
	
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

	public Date getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Date statementDate) {
		this.statementDate = statementDate;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
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
