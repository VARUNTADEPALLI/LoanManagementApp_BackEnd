package com.varun.Service;

import java.math.BigDecimal;
import java.util.List;

import com.varun.dto.PaymentDto;
import com.varun.dto.RemainingPaymentDto;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.TermPaymentDto;
import com.varun.dto.TotalDueDto;
import com.varun.entity.PaymentDetails;
import com.varun.entity.UnbilledTransactions;

public interface PaymentService {

	StatementDatesDto getDates(String loanId, int term);

	TotalDueDto getInstallmentOutstanding(String loanId);

	PaymentDto getTotalAmounts(String loanId);

	TermPaymentDto getDetailsByterm(int term);

void updateSchedule(double amount);

	void saveUnbilledTransactionDetails(UnbilledTransactions unbilledTransactions);
	
	

}
