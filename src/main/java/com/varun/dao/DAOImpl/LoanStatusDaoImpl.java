package com.varun.dao.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.LoanStatusDao;
import com.varun.dto.LoanStatusDTO;
import com.varun.dto.RemainingPaymentDto;
import com.varun.dto.tempCustDtls;
import com.varun.entity.AddressDetails;
import com.varun.entity.CustomerDetails;
import com.varun.entity.LoanDetails;
import com.varun.entity.loanStatusDto1;

import jakarta.persistence.EntityManager;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ToListResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

import org.hibernate.Session;



@Repository
public class LoanStatusDaoImpl implements LoanStatusDao{
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}
	

	@Override
	public LoanStatusDTO getLoanStatusDetailsById(String customerId,String loanType,String mobilenumber) {
		LoanStatusDTO lsdto = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select l.currentDueAmount as currentDueAmount,l.overDueAmount as overDueAmount,l.thirtyDays as thirtyDays,l.sixtyDays as sixtyDays,l.ninetyDays as ninetyDays,l.oneTwentyDays as oneTwentyDays,l.oneFiftyDays as oneFiftyDays,l.oneEightyDays as oneEightyDays,l.oneEightyDaysPlus as oneEightyDaysPlus,l.totalLoans as totalLoans,c.name as name,c.mobilenumber as mobilenumber,l.customerId as customerId,l.loanId as loanId,l.term as term,l.activeLoans as activeLoans,l.closedLoans as closedLoans,l.closureDate as closureDate,l.currency as currency,l.disbursalDate as disbursalDate,l.finalDueDate as finalDueDate,l.firstDueDate as firstDueDate,l.installmentAmount as installmentAmount,l.intrestAmount as intrestAmount,l.intrestRate as intrestRate,l.intrestStartDate as intrestStartDate,l.loanAmount as loanAmount,l.nextTerm as nextTerm,l.remainingTerm as remainingTerm,st.value as status,pf.value as paymentFrequency,lt.value as loanType,it.value as intrestType,c.emailId as emailId from LoanDetails l Inner join  CustomerDetails c on c.customerId = '" + customerId + "' and l.loanType = '"+ loanType +"'";
							query = query + " left outer join  CodeAndValues lt  on lt.code = '" + loanType + "' ";				
							query = query + " left outer join  CodeAndValues pf  on pf.code = l.paymentFrequency ";
							query = query + " left outer join  CodeAndValues it  on it.code = l.intrestType and it.description = 'Intrest Type' ";
							query = query + " left outer join  CodeAndValues st  on st.code = l.status and st.description = 'Status' ";
							query = query + "where c.mobilenumber = '" + mobilenumber + "'";
			Query<LoanStatusDTO> q3 = session.createQuery(query,LoanStatusDTO.class);
			 lsdto  = (LoanStatusDTO) q3.setTupleTransformer(new AliasToBeanResultTransformer<LoanStatusDTO>(LoanStatusDTO.class)).getSingleResult();
			//List<LoanStatusDTO> dtos1 = session.createQuery(query,LoanStatusDTO.class).setTupleTransformer(new AliasToBeanResultTransformer<LoanStatusDTO>(LoanStatusDTO.class)).getResultList();
			//List<LoanStatusDTO> dtos2 = session.createQuery(query, LoanStatusDTO.class).getResultList();
			//dtos2 = session.createNativeQuery("select  l.Customer_id as customerid ,l.LOAN_ID as loanid from Loan_details l").setResultTransformer(Transformers.aliasToBean(LoanStatusDTO.class)).list();
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


	@Override
	public RemainingPaymentDto getPaymentDetails(String loanId) {
		RemainingPaymentDto lsdto = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select SUM(pd.principalPaid) as principalPaid,SUM(pd.principalAmount)-SUM(pd.principalPaid) as remainingPrincipal,SUM(pd.intrestAmount)-SUM(pd.intrestPaid) as remainingIntrest,SUM(pd.intrestPaid) as intrestPaid,SUM(pd.installmentPaid) as installmentPaid,SUM(pd.installmentAmount)-SUM(pd.installmentPaid) as remainingInstallment from PaymentDetails pd where pd.loanId = '" + loanId +"' ";
			Query<RemainingPaymentDto> q3 = session.createQuery(query,RemainingPaymentDto.class);
			 lsdto  = (RemainingPaymentDto) q3.setTupleTransformer(new AliasToBeanResultTransformer<RemainingPaymentDto>(RemainingPaymentDto.class)).getSingleResult();
			//List<LoanStatusDTO> dtos1 = session.createQuery(query,LoanStatusDTO.class).setTupleTransformer(new AliasToBeanResultTransformer<LoanStatusDTO>(LoanStatusDTO.class)).getResultList();
			//List<LoanStatusDTO> dtos2 = session.createQuery(query, LoanStatusDTO.class).getResultList();
			//dtos2 = session.createNativeQuery("select  l.Customer_id as customerid ,l.LOAN_ID as loanid from Loan_details l").setResultTransformer(Transformers.aliasToBean(LoanStatusDTO.class)).list();
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


	@Override
	public AddressDetails getAddressDetails(String customerId) {
		AddressDetails lsdto = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select ad.customerId as customerId,ad.addressType as addressType,ad.description as description,ad.houseNumber as houseNumber,ad.streetName as streetName,ad.city as city,ad.state as state,ad.pincode as pincode,ad.country as country	from AddressDetails ad where ad.customerId = '"+ customerId +"'";
			Query<AddressDetails> q3 = session.createQuery(query,AddressDetails.class);
			 lsdto  = (AddressDetails) q3.setTupleTransformer(new AliasToBeanResultTransformer<AddressDetails>(AddressDetails.class)).getSingleResult();
			 if(lsdto==null)
			 {

				 throw new UserDoesnotExistException(
				            "Address for customer does not exist!!");
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return lsdto;
	}

}
