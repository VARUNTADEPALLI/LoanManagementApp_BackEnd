package com.varun.Service;

import java.util.List;

import com.varun.dto.PolicyCreationDto;
import com.varun.dto.PolicyDetailsDto;
import com.varun.dto.PolicyDto;
import com.varun.dto.PolicyRulesTableDto;

public interface PolicyCreationService {

	String savePolicy(List<PolicyDetailsDto> detailsDto);

	String updatePolicy(String policyId);

	List<PolicyDetailsDto> getPolicyDetailsWithInprogessApprovalStatus();

	String updateApprovalStatusToApproved(String policyId);

	List<PolicyRulesTableDto> getPolicyDetailsWithId(String policyId);

	String updatepolicyDetailsToRejected(String policyId);

	List<PolicyDetailsDto> getActivePolicyDetails();

}
