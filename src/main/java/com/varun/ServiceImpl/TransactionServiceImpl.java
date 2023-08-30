package com.varun.ServiceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.TransactionServive;
import com.varun.dao.TransactionDao;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.StatementTransactionDto;
import com.varun.dto.TransactionDetailsDto;
import com.varun.entity.StatementSummary;
import com.varun.entity.StatementTransactions;
import com.varun.entity.UnbilledTransactions;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class TransactionServiceImpl implements TransactionServive{
	
	@Autowired
	TransactionDao transactionDao;

	@Override
	public StatementSummary getSummary(String statementDate) {
		StatementSummary summary = transactionDao.getTransactionSummary(statementDate);
		return summary;
	}

	@Override
	public List<StatementDatesDto> getDates(String loanId) {
		List<StatementDatesDto> dates  = transactionDao.getStatementDates(loanId);
		return dates;
	}

	@Override
	public StatementTransactions getTransactions(String statementDate, String loanId) {
		StatementTransactions transaction = transactionDao.getTransaction(statementDate,loanId);
		return transaction;
	}

	@Override
	public StatementTransactions getDebitTransactions(String statementDate, String loanId) {
		StatementTransactions transaction = transactionDao.getDebitTransaction(statementDate,loanId);
		return transaction;
	}

	@Override
	public List<TransactionDetailsDto> getStatementTransactions(String statementDate,String loanId) {
		List<TransactionDetailsDto> transaction = transactionDao.getStatementTransaction(statementDate,loanId);
		return transaction;
	}

	@Override
	public UnbilledTransactions getUnbilledTransactions(String loanId) {
		UnbilledTransactions transaction = transactionDao.getUnbilledTransactions(loanId);
		return transaction;
	}

	@Override
	public UnbilledTransactions getunbilledDebitTransactions(String loanId) {
		UnbilledTransactions transaction = transactionDao.getUnbilledTDebitTransaction(loanId);
		return transaction;
	}


	

}
