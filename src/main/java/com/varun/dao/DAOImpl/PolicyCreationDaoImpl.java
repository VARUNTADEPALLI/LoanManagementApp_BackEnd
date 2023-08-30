package com.varun.dao.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varun.Exceptions.UserDoesnotExistException;
import com.varun.dao.PolicyCreationDao;
import com.varun.dto.PolicyCreationDto;
import com.varun.dto.PolicyDetailsDto;
import com.varun.dto.PolicyDto;
import com.varun.dto.PolicyRulesTableDto;
import com.varun.entity.CodeAndValues;
import com.varun.entity.PolicyDetails;
import com.varun.entity.StatementSummary;

import jakarta.persistence.EntityManager;


@Repository
public class PolicyCreationDaoImpl implements PolicyCreationDao{
	

	@Autowired
	private EntityManager entityManager;
	
	private Session getHibernateSession()
	{
		return entityManager.unwrap(Session.class);
	}

	@Override
	public String savePolicyDetails(List<PolicyDetailsDto> detailsDto) {
		String msg = "";
		try
		{
			Session session = getHibernateSession();
			int k = 0;
			for(int i=0;i< detailsDto.size();i++)
			{
				
				String query1 = "select pd.id as id from PolicyDetails pd";
				Query<Integer> q3 = session.createQuery(query1);
				List<Integer> idList = q3.getResultList();
				if(idList.size()>0)
				{
					int lastId = idList.get(idList.size()-1);
					k = lastId + 1;
				}
				else
				{	
					k = i+1;
				}
				String query = "Insert into PolicyDetails (id,companyName,status,score,policyType,policyId,policyName,type,factor,operator,value1,value2,continuationOperator,subConditionOperator,expression,approvalStatus) values (" + k + ",'" +  detailsDto.get(i).getCompanyName() + "' , '" + detailsDto.get(i).getStatus() + "' , " +
								detailsDto.get(i).getScore() + ", '" + detailsDto.get(i).getPolicyType() + "', '" + detailsDto.get(i).getPolicyId() + "', '" + 
								detailsDto.get(i).getPolicyName() + "', '" + detailsDto.get(i).getType() + "', '" + 
								detailsDto.get(i).getFactor() + "', '" + detailsDto.get(i).getOperator() + "', '"
								+detailsDto.get(i).getValue1() + "', '" + detailsDto.get(i).getValue2() +
								"', '" + detailsDto.get(i).getContinuationOperator() + "', '" + 
								detailsDto.get(i).getSubConditionOperator() + "','" + detailsDto.get(i).getExpression() +"', '" + 
										detailsDto.get(i).getApprovalStatus() + "')";
				MutationQuery result1 = session.createMutationQuery(query);
				result1.executeUpdate();
			}
				
			msg = "saved";
				
		}
			catch(UserDoesnotExistException e)
			{
				msg = "error";
				e.printStackTrace();
				
			}
			return msg;
	}

	@Override
	public String updatePolicy(String policyId) {
		String msg = "";
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.code as code from CodeAndValues cv where cv.value = 'Inprogress' and cv.description = 'Approval Status'";
			Query<String> q3 = session.createQuery(query);
			String inProgressStatus = q3.getSingleResult();
			String query1 = "update PolicyDetails  set approvalStatus = '"+ inProgressStatus + "' where policyId = '"+ policyId +"'";
			MutationQuery result1 = session.createMutationQuery(query1);
			result1.executeUpdate();
				
			msg = "updated Successfully";
				
		}
			catch(UserDoesnotExistException e)
			{
				msg = "error";
				e.printStackTrace();
				
			}
			return msg;
	}

	@Override
	public List<PolicyDetailsDto> getPolicyDetailsWithInprogessApprovalStatus() {
		List<PolicyDetailsDto> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select pd.id as id,pd.companyName as companyName,pd.status as status,pd.score as score,pd.policyType as policyType,"
					+ "pd.policyId as policyId,pd.policyName as policyName,pd.type as type,pd.factor as factor,pd.operator as operator,pd.value1 as value1,pd.value2 as value2,pd.continuationOperator as continuationOperator,"
					+ "pd.subConditionOperator as subConditionOperator,pd.expression as expression,pd.approvalStatus as approvalStatus from PolicyDetails pd where pd.approvalStatus ='I' and pd.expression != ''";
			Query<PolicyDetailsDto> q3 = session.createQuery(query,PolicyDetailsDto.class);
			list  = (List<PolicyDetailsDto>) q3.setTupleTransformer(new AliasToBeanResultTransformer<PolicyDetailsDto>(PolicyDetailsDto.class)).getResultList();
			 if(list==null)
			 {

				 throw new UserDoesnotExistException(
				            "summary for statement date does not exist!!");
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
		
	}

	@Override
	public String updateApprovalStatusToApproved(String policyId) {
		String msg = "";
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.code as code from CodeAndValues cv where cv.value = 'Approved' and cv.description = 'Approval Status'";
			Query<String> q3 = session.createQuery(query);
			String approvedStatus = q3.getSingleResult();
			String query1 = "update PolicyDetails  set approvalStatus = '"+ approvedStatus + "' where policyId = '"+ policyId +"'";
			MutationQuery result1 = session.createMutationQuery(query1);
			result1.executeUpdate();
				
			msg = "updated Successfully";
				
		}
			catch(UserDoesnotExistException e)
			{
				msg = "error";
				e.printStackTrace();
				
			}
			return msg;
	}

	@Override
	public List<PolicyRulesTableDto> getPolicyDetailsWithId(String policyId) {
		List<PolicyRulesTableDto> list = null;
		try
		{
			Session session = getHibernateSession();
			String query = "select pd.id as id,pd.type as type,pd.factor as factor,pd.operator as operator,pd.value1 as value1,pd.value2 as value2,pd.continuationOperator as continuationOperator,"
					+ "pd.subConditionOperator as subConditionOperator,pd.expression as expression,pd.approvalStatus as approvalStatus from PolicyDetails pd where pd.policyId = '" + policyId + "'" ;
			Query<PolicyRulesTableDto> q3 = session.createQuery(query,PolicyRulesTableDto.class);
			list  = (List<PolicyRulesTableDto>) q3.setTupleTransformer(new AliasToBeanResultTransformer<PolicyRulesTableDto>(PolicyRulesTableDto.class)).getResultList();
			 if(list==null)
			 {

				 throw new UserDoesnotExistException(
				            "summary for statement date does not exist!!");
			 }
			 
			
		}
		catch(UserDoesnotExistException e)
		{
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public String updatepolicyDetailsToRejected(String policyId) {
		String msg = "";
		try
		{
			Session session = getHibernateSession();
			String query = "select cv.code as code from CodeAndValues cv where cv.value = 'Rejected' and cv.description = 'Approval Status'";
			Query<String> q3 = session.createQuery(query);
			String rejectedStatus = q3.getSingleResult();
			String query1 = "update PolicyDetails  set approvalStatus = '"+ rejectedStatus + "' where policyId = '"+ policyId +"'";
			MutationQuery result1 = session.createMutationQuery(query1);
			result1.executeUpdate();
				
			msg = "updated Successfully";
				
		}
			catch(UserDoesnotExistException e)
			{
				msg = "error";
				e.printStackTrace();
				
			}
			return msg;
	}

	@Override
	public List<PolicyDetailsDto> getActivePolicyDetails() {
		List<PolicyDetailsDto> list = null;
		try {
			Session session = getHibernateSession();
			String qurey = "select pd.id as id,pd.companyName as companyName,pd.status as status,pd.score as score,pd.policyType as policyType,pd.policyId as policyId,pd.policyName as policyName from PolicyDetails pd where pd.status='A  ' and pd.expression!=''";
			Query<PolicyDetailsDto> result = session.createQuery(qurey, PolicyDetailsDto.class);
			list = (List<PolicyDetailsDto>) result.setTupleTransformer(new AliasToBeanResultTransformer<PolicyDetailsDto>(PolicyDetailsDto.class)).getResultList();
			if(list == null)
			{
				throw new UserDoesnotExistException(
			            "policy detailss does not exist!!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
