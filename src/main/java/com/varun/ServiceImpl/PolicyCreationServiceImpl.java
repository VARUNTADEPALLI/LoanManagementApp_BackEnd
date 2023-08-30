package com.varun.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.PolicyCreationService;
import com.varun.dao.PolicyCreationDao;
import com.varun.dto.PolicyCreationDto;
import com.varun.dto.PolicyDetailsDto;
import com.varun.dto.PolicyDto;
import com.varun.dto.PolicyRulesTableDto;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class PolicyCreationServiceImpl implements PolicyCreationService{
	
	@Autowired
	
	PolicyCreationDao policyCreationDao;

	@Override
	public String savePolicy(List<PolicyDetailsDto>	detailsDto) {
		String msg = policyCreationDao.savePolicyDetails(detailsDto);
		return msg;
	}

	@Override
	public String updatePolicy(String policyId) {
		String msg = policyCreationDao.updatePolicy(policyId);
		return msg;
	}

	@Override
	public List<PolicyDetailsDto> getPolicyDetailsWithInprogessApprovalStatus() {
		List<PolicyDetailsDto> list  =  policyCreationDao.getPolicyDetailsWithInprogessApprovalStatus();
		return list;
	}

	@Override
	public String updateApprovalStatusToApproved(String policyId) {
		String msg = policyCreationDao.updateApprovalStatusToApproved(policyId);
		return msg;
	}

	@Override
	public List<PolicyRulesTableDto> getPolicyDetailsWithId(String policyId) {
		List<PolicyRulesTableDto> list = policyCreationDao.getPolicyDetailsWithId(policyId);
		return list;
	}

	@Override
	public String updatepolicyDetailsToRejected(String policyId) {
		String msg = policyCreationDao.updatepolicyDetailsToRejected(policyId);
		return msg;
	}

	@Override
	public List<PolicyDetailsDto> getActivePolicyDetails() {
		List<PolicyDetailsDto> msg = policyCreationDao.getActivePolicyDetails();
		return msg;
	}
	

}
