package com.varun.dao.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.CodeAndValuesDao;
import com.varun.entity.CodeAndValues;

import jakarta.persistence.EntityManager;


@Repository

public class CodeAndValuesDaoImpl implements CodeAndValuesDao{
	
	
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}
	

	@Override
	public List<CodeAndValues> getOptionsOfCompareType() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Compare Type'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options do not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getOptionsOfFactorType() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Factor'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getOptionsOfContinuationOperator() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Continuation Operator'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getOptionsOfOperator() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Operator'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getOptionsOfSubCondition() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Sub Condition'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getOptionsOfSubConditionForFinish() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Sub Condition For Paranthesis'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getOptionsForCompanyCode() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Company Code'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getPolicyStatus() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Policy Status'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public List<CodeAndValues> getPolicyType() {
		List<CodeAndValues> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.value as value from CodeAndValues cv where cv.description = 'Policy Type'";
			Query<CodeAndValues> q3 = session.createQuery(query,CodeAndValues.class);
			list  = (List<CodeAndValues>) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getResultList();
			 if(list==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}


	@Override
	public String getApprovalStatusAsInProgress() {
		String inProgressStatus = "";
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.code as code from CodeAndValues cv where cv.value = 'In progress' and cv.description = 'Status'";
			Query<String> q3 = session.createQuery(query);
			//inProgressStatus  = (String) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getSingleResult();
			inProgressStatus = q3.getSingleResult();
			if(inProgressStatus==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return inProgressStatus;
	}


	@Override
	public String getPolicyStatusCode(String policyStatus) {
		String inProgressStatus = "";
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.code as code from CodeAndValues cv where cv.value = '" + policyStatus + "' and cv.description = 'Policy Status'";
			Query<String> q3 = session.createQuery(query);
			//inProgressStatus  = (String) q3.setTupleTransformer(new AliasToBeanResultTransformer<CodeAndValues>(CodeAndValues.class)).getSingleResult();
			inProgressStatus = q3.getSingleResult();
			if(inProgressStatus==null)
			 {
				 
				 throw new UserDoesnotExistException(
				            "Options does not exist!!");
			 }	 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return inProgressStatus;
	}

}
