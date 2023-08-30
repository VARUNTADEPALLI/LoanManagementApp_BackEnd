package com.varun.dao;

import java.sql.Date;
import java.util.List;

import com.varun.dto.StatementDatesDto;
import com.varun.dto.StatementTransactionDto;
import com.varun.dto.TransactionDetailsDto;
import com.varun.entity.StatementSummary;
import com.varun.entity.StatementTransactions;
import com.varun.entity.UnbilledTransactions;

public interface TransactionDao {

	StatementSummary getTransactionSummary(String statementDate);

	List<StatementDatesDto> getStatementDates(String loanId);

	StatementTransactions getTransaction(String statementDate, String loanId);

	StatementTransactions getDebitTransaction(String statementDate, String loanId);

	List<TransactionDetailsDto> getStatementTransaction(String statementDate, String loanId);

	UnbilledTransactions getUnbilledTransactions(String statementDate);

	UnbilledTransactions getUnbilledTDebitTransaction(String statementDate);



}
