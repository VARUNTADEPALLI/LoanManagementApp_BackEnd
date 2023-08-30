package com.varun.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.TransactionServive;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.StatementTransactionDto;
import com.varun.dto.TransactionDetailsDto;
import com.varun.entity.StatementSummary;
import com.varun.entity.StatementTransactions;
import com.varun.entity.UnbilledTransactions;

@RestController
public class TransacrionsController {
	
	@Autowired
	TransactionServive transactionService;
	
	@PostMapping("/api/statement-summary/{statementDate}")
	public StatementSummary getStatementSummary(@PathVariable("statementDate") String statementDate)
	{
		StatementSummary summary = transactionService.getSummary(statementDate);
		return summary;
	}
	
	
	
	@GetMapping("/api/statementdates/{loanId}")
	public List<StatementDatesDto> getStatementDates(@PathVariable("loanId") String loanId)
	{
		List<StatementDatesDto> summary = transactionService.getDates(loanId);
		return summary;
	}  
	
	
	@PostMapping("/api/statementCreditTransactions/{statementDate}/{loanId}")
	public StatementTransactions getStatementCreditTransactions(@PathVariable("statementDate") String statementDate,@PathVariable("loanId") String loanId)
	{
		StatementTransactions transaction = transactionService.getTransactions(statementDate,loanId);
		return transaction;
	}
	
	

	@PostMapping("/api/statementDebitTransactions/{statementDate}/{loanId}")
	public StatementTransactions getDebitStatementTransactions(@PathVariable("statementDate") String statementDate,@PathVariable("loanId") String loanId)
	{
		StatementTransactions transaction = transactionService.getDebitTransactions(statementDate,loanId);
		return transaction;
	}
	
	
	@PostMapping("/api/statementTransactions/{statementDate}/{loanId}")
	public List<TransactionDetailsDto> getStatementTransactions(@PathVariable("statementDate") String statementDate,@PathVariable("loanId") String loanId)
	{
		List<TransactionDetailsDto> transaction = transactionService.getStatementTransactions(statementDate,loanId);
		return transaction;
	}
	
	
	@PostMapping("/api/UnbilledCreditTransactions/{loanId}")
	public  UnbilledTransactions getUnbilledCreditTransactions(@PathVariable("loanId") String loanId)
	{
		UnbilledTransactions transaction = transactionService.getUnbilledTransactions(loanId);
		return transaction;
	}
	
	
	@PostMapping("/api/UnbilledDebitTransactions/{loanId}")
	public UnbilledTransactions getUnbilledStatementTransactions(@PathVariable("loanId") String loanId)
	{
		UnbilledTransactions transaction = transactionService.getunbilledDebitTransactions(loanId);
		return transaction;
	}
	
	
	

	
	

}
