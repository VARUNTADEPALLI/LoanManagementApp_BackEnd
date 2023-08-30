package com.varun.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="STATEMENT_TRANSACTIONS")
public class StatementTransactions {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	long id;
	
	@Id
	@Column(name="STATEMENT_DATE")
	Date statementDate;
	
	@Id
	@Column(name="LOAN_ID")
	String loanId;
	

	@Column(name="TRANSACTION_DATE")
	Date transactionDate;
	

	@Column(name="TRANSACTION_AMOUNT")
	BigDecimal transactionAmount;
	
	@Column(name="TRANSACTION_TYPE")
	String transactionType;
	
	@Column(name="DESCRIPTION")
	String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
