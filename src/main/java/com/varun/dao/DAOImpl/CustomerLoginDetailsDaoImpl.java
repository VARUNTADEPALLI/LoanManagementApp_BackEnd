package com.varun.dao.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.CustomerLoginDetailsDao;
import com.varun.entity.New_User;

import jakarta.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;


@Repository
public class CustomerLoginDetailsDaoImpl implements CustomerLoginDetailsDao{
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}


	@Override
	public String findCustomerDetails(New_User info) {
		New_User details = null;
		String msg = "";
		try
		{
			Session session = getHibernateSession();
			String query = "Select a from New_User a where a.id = '"+info.getId()+"'";
			Query<New_User> query2 = session.createQuery(query);
			 details = (New_User) query2.uniqueResult();
			 if(details==null)
			 {

				 throw new UserDoesnotExistException(
				            "Invalid Login Credentials!!");
			 }
			 
			 PasswordEncoder encoder = new BCryptPasswordEncoder();
			 boolean passmatch = encoder.matches(info.getPassword(), details.getPassword());
			 if( details!=null && passmatch == true)
			 {
				 msg = "login Success";
			 }
			
			 if(details!=null && passmatch==false)
			 {

				 throw new UserDoesnotExistException(
				            "Invalid Login Credentials!!");
			 }
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			msg=e.getMessage();
		}
		return msg;
	}

}
