package com.varun.dao.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.ActiveLoanDetailsDao;
import com.varun.dto.ActiveLoanDetailsDto;
import com.varun.dto.LoanStatusDTO;

import jakarta.persistence.EntityManager;


@Repository
public class ActiveLoanDetailsDaoImpl implements ActiveLoanDetailsDao{
	
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}
	
	

	@Override
	public List<ActiveLoanDetailsDto> getCustomerLoanInfo(String mobile_number) {
		List<ActiveLoanDetailsDto> lsdto = null;
		try
		{
			Session session = getHibernateSession();			
			String query = "select cd.name as name,ld.loanId as loanId, ld.loanAmount as loanAmount,cv.value as loanType,ld.customerId as customerId "
					+ "from CustomerDetails cd "
					+ "INNER JOIN LoanDetails ld "
					+ "ON cd.customerId = ld.customerId "
					+ "left outer join "
					+ " CodeAndValues cv  on cv.code = ld.loanType "
					+ "where cd.mobilenumber = '" + mobile_number + "'";
			Query<ActiveLoanDetailsDto> q3 = session.createQuery(query,ActiveLoanDetailsDto.class);
			 lsdto  = (List<ActiveLoanDetailsDto>) q3.setTupleTransformer(new AliasToBeanResultTransformer<ActiveLoanDetailsDto>(ActiveLoanDetailsDto.class)).getResultList();
			 
			 if(lsdto==null)
			 {

				 throw new UserDoesnotExistException(
				            "Loan does not exist!!");
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

}
