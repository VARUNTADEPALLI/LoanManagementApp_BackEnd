package com.varun.dao.DAOImpl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.PaymentDao;
import com.varun.dto.LoanStatusDTO;
import com.varun.dto.PaymentDto;
import com.varun.dto.RemainingPaymentDto;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.TermPaymentDto;
import com.varun.dto.TotalDueDto;
import com.varun.entity.PaymentDetails;
import com.varun.entity.RepaymentSchedule;
import com.varun.entity.UnbilledTransactions;

import jakarta.persistence.EntityManager;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}

	@Override
	public StatementDatesDto getduedate(String loanId,int term) {
		StatementDatesDto lsdto1 = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select pd.dueDate as statementDate from PaymentDetails pd where pd.loanId = '" + loanId + "' and pd.term = '"+ term +"'";
			Query<StatementDatesDto> q3 = session.createQuery(query,StatementDatesDto.class);
			 lsdto1  = (StatementDatesDto) q3.setTupleTransformer(new AliasToBeanResultTransformer<StatementDatesDto>(StatementDatesDto.class)).getSingleResult();
			 if(lsdto1==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "next due date does not exist!!");
			 }
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto1;
	}

	@Override
	public TotalDueDto getduedate(String loanId) {
		TotalDueDto lsdto1 = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select SUM(pd.installmentAmount)-SUM(pd.installmentPaid) as totalDue from PaymentDetails pd where pd.loanId = '" + loanId + "'";
			Query<TotalDueDto> q3 = session.createQuery(query,TotalDueDto.class);
			 lsdto1  = (TotalDueDto) q3.setTupleTransformer(new AliasToBeanResultTransformer<TotalDueDto>(TotalDueDto.class)).getSingleResult();
			 if(lsdto1==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "next due date does not exist!!");
			 }
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto1;
	}

	@Override
	public PaymentDto getTotalAmount(String loanId) {
		PaymentDto lsdto1 = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select SUM(pd.installmentAmount) as totalInstallmentAmount,SUM(pd.principalAmount) as totalPrincipalAmount,SUM(pd.intrestAmount) as totalIntrestAmount from PaymentDetails pd where pd.loanId = '" + loanId + "'";
			Query<PaymentDto> q3 = session.createQuery(query,PaymentDto.class);
			 lsdto1  = (PaymentDto) q3.setTupleTransformer(new AliasToBeanResultTransformer<PaymentDto>(PaymentDto.class)).getSingleResult();
			 if(lsdto1==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Record does not exist!!");
			 }
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto1;
	}

	@Override
	public TermPaymentDto getTermDetails(int term) {
		TermPaymentDto lsdto1 = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select pd.dueDate as dueDate,COALESCE(pd.installmentAmount,0.00) as installment,COALESCE(pd.principalAmount,0.00) as principal,COALESCE(pd.intrestAmount,0.00) as intrest,COALESCE(pd.principalPaid,0.00) as principalPaid,COALESCE(pd.principalAmount-pd.principalPaid,0.00) as principaOutstanding,COALESCE(pd.intrestPaid,0.00) as intrestPaid from PaymentDetails pd where pd.term = '" + term + "'";
			Query<TermPaymentDto> q3 = session.createQuery(query,TermPaymentDto.class);
			 lsdto1  = (TermPaymentDto) q3.setTupleTransformer(new AliasToBeanResultTransformer<TermPaymentDto>(TermPaymentDto.class)).getSingleResult();
			 if(lsdto1==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Record does not exist!!");
			 }
			
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto1;
	}

	@Override
	public List<PaymentDetails> updateRepaymentSchedule(double amount) {
		List<PaymentDetails> lsdto1 = null;
		double intrestBalance = 0.00;
		double principalBalance = 0.00;
		double installmentBalance = 0.00;
		double intrestAmount = 0.00;
		double principalAmount = 0.00;
		double installmentAount = 0.00;
		int term = 0;
		try
		{
			Session session = getHibernateSession();
			String query = "select pd.principalPaid as principalPaid,pd.loanId as loanId,pd.term as term,pd.status as status,pd.dueDate as dueDate,pd.principalAmount as principalAmount,pd.installmentAmount as installmentAmount,pd.intrestAmount as intrestAmount,pd.principalBalanceAmount as principalBalanceAmount,pd.intrestPaid as intrestPaid,pd.installmentPaid as installmentPaid from PaymentDetails pd where pd.installmentPaid < pd.installmentAmount";
			Query<PaymentDetails> q3 = session.createQuery(query,PaymentDetails.class);
			 lsdto1  = (List<PaymentDetails>) q3.setTupleTransformer(new AliasToBeanResultTransformer<PaymentDetails>(PaymentDetails.class)).getResultList();
			
			 if(lsdto1==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Record does not exist!!");
			 }
				 
		
			
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto1;
	}

	@Override
	public void updateIntrestPaid(double intrestAmount, int term) {
		try
		{
			Session session = getHibernateSession();
			String query = "update PaymentDetails  set intrestPaid = "+intrestAmount+" where term = "+term+"";
			MutationQuery result = session.createMutationQuery(query);
			result.executeUpdate();
			String query2 = "update PaymentDetails  set installmentPaid = "+intrestAmount+" where term = "+term+"";
			MutationQuery result1 = session.createMutationQuery(query2);
			result1.executeUpdate();
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void updatePrincipalPaid(double principalAmount, int term, double installmentAount) {
		try
		{
			Session session = getHibernateSession();
			String query = "update PaymentDetails  set principalPaid = "+principalAmount+" where term = "+term+"";
			MutationQuery result = session.createMutationQuery(query);
			result.executeUpdate();
			String query2 = "update PaymentDetails  set installmentPaid = "+installmentAount+" where term = "+term+"";
			MutationQuery result1 = session.createMutationQuery(query2);
			result1.executeUpdate();
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void saveTransactionDetails(UnbilledTransactions unbilledTransactions) {
		// TODO Auto-generated method stub
		try
		{
			Session session = getHibernateSession();
			System.out.println(unbilledTransactions.getTransactionDate());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			java.sql.Date sqlfromdate = null;
            try {
            	sqlfromdate = new java.sql.Date(simpleDateFormat.parse(simpleDateFormat.format(unbilledTransactions.getTransactionDate())).getTime());
                } 
            catch (ParseException e) {
                e.printStackTrace();
                }
			String query = "insert into UNBILLED_TRANSACTIONS values('" + sqlfromdate + "'," + unbilledTransactions.getTransactionAmount() + ",'" + unbilledTransactions.getTransactionType() + "','" + unbilledTransactions.getDescription() + "')";
			System.out.println(query);
			MutationQuery result = session.createNativeMutationQuery(query);
			result.executeUpdate();
		}	
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
	}

}
