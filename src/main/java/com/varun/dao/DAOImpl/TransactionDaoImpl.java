package com.varun.dao.DAOImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.TransactionDao;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.StatementTransactionDto;
import com.varun.dto.TransactionDetailsDto;
import com.varun.entity.AddressDetails;
import com.varun.entity.StatementSummary;
import com.varun.entity.StatementTransactions;
import com.varun.entity.UnbilledTransactions;

import jakarta.persistence.EntityManager;

@Repository
public class TransactionDaoImpl implements TransactionDao{
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}

	@Override
	public StatementSummary getTransactionSummary(String statementDate) {
		StatementSummary lsdto = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select ss.statementDate as statementDate,ss.loanId as loanId,ss.balance as balance, ss.overDueDays as overDueDays,ss.currentDueAmount as currentDueAmount,ss.overDueAmount as overDueAmount,ss.thirtyDays as thirtyDays,ss.sixtyDays as sixtyDays,ss.ninetyDays as ninetyDays,ss.oneTwentyDays as oneTwentyDays,ss.oneFiftyDays as oneFiftyDays,ss.oneEightyDays as oneEightyDays,ss.oneEightyDaysPlus as oneEightyDaysPlus from StatementSummary ss where ss.statementDate ='"+ statementDate +"'";
			Query<StatementSummary> q3 = session.createQuery(query,StatementSummary.class);
			 lsdto  = (StatementSummary) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementSummary>(StatementSummary.class)).getSingleResult();
			 if(lsdto==null)
			 {

				 throw new UserDoesnotExistException(
				            "summary for statement date does not exist!!");
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

	@Override
	public List<StatementDatesDto> getStatementDates(String loanId) {
		List<StatementDatesDto> lsdto = new ArrayList<>();
		List<StatementDatesDto> lsdto1 = new ArrayList<>();
		StatementDatesDto stdto = new StatementDatesDto();
		java.util.Date todayDate = new java.util.Date();
		stdto.setStatementDate(todayDate);
		try
		{
			Session session = getHibernateSession();
			String query = "select ss.statementDate as statementDate from StatementSummary ss where ss.loanId = '" + loanId + "'";
			Query<StatementDatesDto> q3 = session.createQuery(query,StatementDatesDto.class);
			 lsdto1  = (List<StatementDatesDto>) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementDatesDto>(StatementDatesDto.class)).getResultList();
			 if(lsdto1==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "summary for statement date does not exist!!");
			 }
			 else
			 {
				 lsdto.add(stdto);
				 lsdto.addAll(lsdto1); 
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

	@Override
	public StatementTransactions getTransaction(String statementDate, String loanId) {
		StatementTransactions lsdto = null;
		List<StatementDatesDto> dates = new ArrayList<>();
		List<String> datelist = new ArrayList<>();
		try
		{
			Session session = getHibernateSession();
			dates = getStatementDates(loanId);
			for(int i=0;i<dates.size();i++)
			{
				datelist.add(i, dates.get(i).getStatementDate().toString());
			}
			 if(statementDate.equals(datelist.get(1))) 
			 {
				 String query = "select count(st.transactionType) as id,sum(st.transactionAmount) as transactionAmount  from StatementTransactions st where st.transactionType = 'C' and st.transactionDate < '" + statementDate + "' ";
					Query<StatementTransactions> q3 = session.createQuery(query,StatementTransactions.class);
					 lsdto  = (StatementTransactions) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementTransactions>(StatementTransactions.class)).getSingleResult();
					 if(lsdto==null)
					 {

						 throw new UserDoesnotExistException(
						            "No data!!");
					 }
			 }
			 else
			 {
				 for(int i=2;i<datelist.size();i++)
				 {
					 if(statementDate.equals(datelist.get(i)))
					 {
						 System.out.println("index"+i);
						 i=i-1;
						 String prevDate = datelist.get(i);
						 String query = "select count(st.transactionType) as id,sum(st.transactionAmount) as transactionAmount  from StatementTransactions st where st.transactionType = 'C' and st.transactionDate <= '" + statementDate + "' and st.transactionDate >= '"+prevDate+"'";
							Query<StatementTransactions> q3 = session.createQuery(query,StatementTransactions.class);
							 lsdto  = (StatementTransactions) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementTransactions>(StatementTransactions.class)).getSingleResult();
							 if(lsdto==null)
							 {

								 throw new UserDoesnotExistException(
								            "No data!!");
							 }
						 
					 }
					 break;
				 }
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

	@Override
	public StatementTransactions getDebitTransaction(String statementDate, String loanId) {
		StatementTransactions lsdto = null;
		List<StatementDatesDto> dates = new ArrayList<>();
		List<String> datelist = new ArrayList<>();
		try
		{
			Session session = getHibernateSession();
			dates = getStatementDates(loanId);
			for(int i=0;i<dates.size();i++)
			{
				datelist.add(i, dates.get(i).getStatementDate().toString());
			}
			if(statementDate.equals(datelist.get(1))) 
			{
				String query = "select COALESCE(Sum(st.transactionAmount),0) as transactionAmount,count(st.transactionType) as id  from StatementTransactions st where st.transactionType = 'D' and st.transactionDate < '" + statementDate + "'";
				Query<StatementTransactions> q3 = session.createQuery(query,StatementTransactions.class);
				 lsdto  = (StatementTransactions) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementTransactions>(StatementTransactions.class)).getSingleResult();
				 if(lsdto==null)
				 {

					 throw new UserDoesnotExistException(
					            "No data!!");
				 }
			}
			else
			{
				 for(int i=2;i<datelist.size();i++)
				 {
					 if(statementDate.equals(datelist.get(i)))
					 {
						 System.out.println("index"+i);
						 i=i-1;
						 String prevDate = datelist.get(i);
						 String query = "select COALESCE(Sum(st.transactionAmount),0) as transactionAmount,count(st.transactionType) as id  from StatementTransactions st where st.transactionType = 'D' and st.transactionDate <= '" + statementDate + "' and st.transactionDate >= '"+prevDate+"'";
							Query<StatementTransactions> q3 = session.createQuery(query,StatementTransactions.class);
							 lsdto  = (StatementTransactions) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementTransactions>(StatementTransactions.class)).getSingleResult();
							 if(lsdto==null)
							 {

								 throw new UserDoesnotExistException(
								            "No data!!");
							 }
						 
					 }
					 break;
				 }
			}
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;	
		}

	@Override
	public List<TransactionDetailsDto> getStatementTransaction(String statementDate,String loanId) {
		List<TransactionDetailsDto> lsdto = new ArrayList<>();
		List<StatementDatesDto> dates = new ArrayList<>();
		List<String> datelist = new ArrayList<>();
		try
		{
			Session session = getHibernateSession();
			
			dates = getStatementDates(loanId);
			for(int i=0;i<dates.size();i++)
			{
				datelist.add(i, dates.get(i).getStatementDate().toString());
			}
			 
		
			 if(statementDate.equals(datelist.get(1))) 
			 {
				 String query1 = "select st.transactionDate as transactionDate,case when st.transactionType='C' then st.transactionAmount else 0.00  end as creditAmount,case when st.transactionType='D' then st.transactionAmount else 0.00  end as debitAmount,st.description as description from StatementTransactions st where  st.transactionDate < '" + statementDate + "'";
					Query<TransactionDetailsDto> q1 = session.createQuery(query1,TransactionDetailsDto.class);
					 lsdto  = (List<TransactionDetailsDto>) q1.setTupleTransformer(new AliasToBeanResultTransformer<TransactionDetailsDto>(TransactionDetailsDto.class)).getResultList();
					 if(lsdto==null)
					 {

						 throw new UserDoesnotExistException(
						            "No data!!");
					 }
		
			 }
			 
			 else
			 {
				 for(int i=2;i<datelist.size();i++)
				 {
					 if(statementDate.equals(datelist.get(i)))
					 {
						 System.out.println("index"+i);
						 i=i-1;
						 String prevDate = datelist.get(i);
						 String query1 = "select st.transactionDate as transactionDate,case when st.transactionType='C' then st.transactionAmount else 0.00  end as creditAmount,case when st.transactionType='D' then st.transactionAmount else 0.00  end as debitAmount,st.description as description from StatementTransactions st where  st.transactionDate <= '" + statementDate + "' and  st.transactionDate >= '" + prevDate +"'";
							Query<TransactionDetailsDto> q1 = session.createQuery(query1,TransactionDetailsDto.class);
							 lsdto  = (List<TransactionDetailsDto>) q1.setTupleTransformer(new AliasToBeanResultTransformer<TransactionDetailsDto>(TransactionDetailsDto.class)).getResultList();
							 if(lsdto==null)
							 {

								 throw new UserDoesnotExistException(
								            "No data!!");
							 }
						 
					 }
					 break;
				 }
			 }
			 
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

	@Override
	public UnbilledTransactions getUnbilledTransactions(String loanId) {
		UnbilledTransactions lsdto = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select COALESCE(Sum(ut.transactionAmount),0) as transactionAmount,count(ut.transactionType) as id  from UnbilledTransactions ut where ut.transactionType = 'C'";
			Query<UnbilledTransactions> q3 = session.createQuery(query,UnbilledTransactions.class);
			lsdto  = (UnbilledTransactions) q3.setTupleTransformer(new AliasToBeanResultTransformer<UnbilledTransactions>(UnbilledTransactions.class)).getSingleResult();
			if(lsdto==null)
			{

				 throw new UserDoesnotExistException("No data!!");
			}
			
		
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

	@Override
	public UnbilledTransactions getUnbilledTDebitTransaction(String loanId) {
		UnbilledTransactions lsdto = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select COALESCE(Sum(ut.transactionAmount),0) as transactionAmount,count(ut.transactionType) as id  from UnbilledTransactions ut where ut.transactionType = 'D'";
			Query<UnbilledTransactions> q3 = session.createQuery(query,UnbilledTransactions.class);
			lsdto  = (UnbilledTransactions) q3.setTupleTransformer(new AliasToBeanResultTransformer<UnbilledTransactions>(UnbilledTransactions.class)).getSingleResult();
			if(lsdto==null)
			{

				 throw new UserDoesnotExistException("No data!!");
			}
			
		
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}



}
