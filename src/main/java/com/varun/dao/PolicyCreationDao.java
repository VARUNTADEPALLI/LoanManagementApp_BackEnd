package com.varun.dao;

import java.util.List;

import com.varun.dto.PolicyCreationDto;
import com.varun.dto.PolicyDetailsDto;
import com.varun.dto.PolicyDto;
import com.varun.dto.PolicyRulesTableDto;

public interface PolicyCreationDao {

	String savePolicyDetails(List<PolicyDetailsDto> detailsDto);

	String updatePolicy(String policyId);

	List<PolicyDetailsDto> getPolicyDetailsWithInprogessApprovalStatus();

	String updateApprovalStatusToApproved(String policyId);

	List<PolicyRulesTableDto> getPolicyDetailsWithId(String policyId);

	String updatepolicyDetailsToRejected(String policyId);

	List<PolicyDetailsDto> getActivePolicyDetails();

}
