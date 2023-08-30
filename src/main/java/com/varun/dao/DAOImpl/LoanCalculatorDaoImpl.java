package com.varun.dao.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.LoanCalculatorDao;
import com.varun.dto.LoanCalculatorDto;
import com.varun.dto.StatementDatesDto;
import com.varun.entity.CodeAndValues;

import jakarta.persistence.EntityManager;


@Repository

public class LoanCalculatorDaoImpl implements LoanCalculatorDao{

	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}
	
	
	@Override
	public List<CodeAndValues> getIntrestRateType() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Intrest Rate Type'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Interest rate type does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getPaymentFrequencyFromCodeAndValues() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Payment frequency'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Interest rate type does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public int getLoanSchedule(LoanCalculatorDto loanCalculatorDto) {
		CodeAndValues list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.numberOfPayments as numberOfPayments from CodeAndValues cv where cv.value = '"+loanCalculatorDto.getPaymentFrequency()+"'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (CodeAndValues) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getSingleResult();
		
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Interest rate type does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		int numberOfPayments = list.getNumberOfPayments();
		return numberOfPayments;
	}

}
