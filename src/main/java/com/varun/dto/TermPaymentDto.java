package com.varun.dto;

import java.sql.Date;

public class TermPaymentDto {

	double installment;
	double principal;
	double intrest;
	double principalOutstanding;
	double principalPaid;
	double intrestPaid;
	Date dueDate;
	
	
	public double getInstallment() {
		return installment;
	}
	public void setInstallment(double installment) {
		this.installment = installment;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getIntrest() {
		return intrest;
	}
	public void setIntrest(double intrest) {
		this.intrest = intrest;
	}
	public double getPrincipaOutstanding() {
		return principalOutstanding;
	}
	public void setPrincipaOutstanding(double principaOutstanding) {
		this.principalOutstanding = principaOutstanding;
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
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
	
}
