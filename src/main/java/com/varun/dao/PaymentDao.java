package com.varun.dao;

import java.math.BigDecimal;
import java.util.List;

import com.varun.dto.PaymentDto;
import com.varun.dto.RemainingPaymentDto;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.TermPaymentDto;
import com.varun.dto.TotalDueDto;
import com.varun.entity.PaymentDetails;
import com.varun.entity.UnbilledTransactions;

public interface PaymentDao {

	StatementDatesDto getduedate(String loanId,int term);

	TotalDueDto getduedate(String loanId);

	PaymentDto getTotalAmount(String loanId);

	TermPaymentDto getTermDetails(int term);

	List<PaymentDetails> updateRepaymentSchedule(double amount);

	void updateIntrestPaid(double intrestAmount, int term);

	void updatePrincipalPaid(double principalAmount, int term, double installmentAount);

	void saveTransactionDetails(UnbilledTransactions unbilledTransactions);

}
