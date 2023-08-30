package com.varun.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.PaymentService;
import com.varun.dto.PaymentDto;
import com.varun.dto.RemainingPaymentDto;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.TermPaymentDto;
import com.varun.dto.TotalDueDto;
import com.varun.entity.PaymentDetails;
import com.varun.entity.UnbilledTransactions;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/api/nextduedate/{loanId}/{term}")
	public StatementDatesDto getStatementDates(@PathVariable("loanId") String loanId,@PathVariable("term") int term)
	{
		StatementDatesDto summary = paymentservice.getDates(loanId,term);
		return summary;
	} 
	
	
	@PostMapping("/api/nextduedate/{loanId}")
	public TotalDueDto getStatementDates(@PathVariable("loanId") String loanId)
	{
		TotalDueDto	 summary = paymentservice.getInstallmentOutstanding(loanId);
		return summary;
	}  
	
	
	@PostMapping("/api/totalAmounts/{loanId}")
	public PaymentDto getTotalPayment(@PathVariable("loanId") String loanId)
	{
		PaymentDto	 totalAmount = paymentservice.getTotalAmounts(loanId);
		return totalAmount;
	}  

	@PostMapping("/api/termWiseDetails/{term}")
	public TermPaymentDto getTermWiseDetails(@PathVariable("term") int term)
	{
		TermPaymentDto	 totalAmount = paymentservice.getDetailsByterm(term);
		return totalAmount;
	}  
	
	@PostMapping("/api/updatePaymentSchedule/{amount}")
	public void updateRepaymentSchedule(@PathVariable("amount") double amount)
	{
		 paymentservice.updateSchedule(amount);
		
	}
	
	
	@PostMapping("/api/saveTransactionDetails")
	public void saveTransactionDetails(@RequestBody UnbilledTransactions unbilledTransactions)
	{
		 paymentservice.saveUnbilledTransactionDetails(unbilledTransactions);
		
	} 

}
