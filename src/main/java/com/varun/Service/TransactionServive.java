package com.varun.Service;

import java.sql.Date;
import java.util.List;

import com.varun.dto.StatementDatesDto;
import com.varun.dto.StatementTransactionDto;
import com.varun.dto.TransactionDetailsDto;
import com.varun.entity.StatementSummary;
import com.varun.entity.StatementTransactions;
import com.varun.entity.UnbilledTransactions;

public interface TransactionServive {

	StatementSummary getSummary(String statementDate);

	List<StatementDatesDto> getDates(String loanId);

	StatementTransactions getTransactions(String statementDate, String loanId);

	StatementTransactions getDebitTransactions(String statementDate, String loanId);

	List<TransactionDetailsDto> getStatementTransactions(String statementDate, String loanId);

	UnbilledTransactions getUnbilledTransactions(String statementDate);

	UnbilledTransactions getunbilledDebitTransactions(String statementDate);

	

	

}
