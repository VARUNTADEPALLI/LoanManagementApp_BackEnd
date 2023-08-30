package com.varun.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PAYMENT_DETAILS")
public class PaymentDetails {
	
	@Id
	@Column(name="LOAN_ID")
	String loanId;
	
	@Column(name="TERM")
	int term;
	
	@Column(name="STATUS")
	String status;
	
	@Column(name="DUE_DATE")
	Date dueDate;
	
	@Column(name="PRINCIPAL_AMOUNT")
	double principalAmount;
	
	@Column(name="INSTALLMENT_AMOUNT")
	double installmentAmount;
	
	@Column(name="INTREST_AMOUNT")
	double intrestAmount;
	
	@Column(name="PRINCIPAL_BALANCE_AMOUNT")
	double principalBalanceAmount;
	
	@Column(name="PRINCIPAL_PAID")
	double principalPaid;
	
	@Column(name="INTREST_PAID")
	double intrestPaid;
	
	@Column(name="INSTALLMENT_PAID")
	double installmentPaid;

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getIntrestAmount() {
		return intrestAmount;
	}

	public void setIntrestAmount(double intrestAmount) {
		this.intrestAmount = intrestAmount;
	}

	public double getPrincipalBalanceAmount() {
		return principalBalanceAmount;
	}

	public void setPrincipalBalanceAmount(double principalBalanceAmount) {
		this.principalBalanceAmount = principalBalanceAmount;
	}

	public double getPrincipalPaid() {
		return principalPaid;
	}

	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}

	public double getIntrestPaid() {
		return intrestPaid;
	}

	public void setIntrestPaid(double intrestPaid) {
		this.intrestPaid = intrestPaid;
	}

	public double getInstallmentPaid() {
		return installmentPaid;
	}

	public void setInstallmentPaid(double installmentPaid) {
		this.installmentPaid = installmentPaid;
	}

	public double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}
	
	
	
	

}
