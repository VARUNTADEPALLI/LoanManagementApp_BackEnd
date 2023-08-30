package com.varun.dto;

public class PaymentDto {
	
	double totalInstallmentAmount;
	double totalPrincipalAmount;
	double totalIntrestAmount;
	
	
	public double getTotalInstallmentAmount() {
		return totalInstallmentAmount;
	}
	public void setTotalInstallmentAmount(double totalInstallmentAmount) {
		this.totalInstallmentAmount = totalInstallmentAmount;
	}
	public double getTotalPrincipalAmount() {
		return totalPrincipalAmount;
	}
	public void setTotalPrincipalAmount(double totalPrincipalAmount) {
		this.totalPrincipalAmount = totalPrincipalAmount;
	}
	public double getTotalIntrestAmount() {
		return totalIntrestAmount;
	}
	public void setTotalIntrestAmount(double totalIntrestAmount) {
		this.totalIntrestAmount = totalIntrestAmount;
	}
	
	

}
