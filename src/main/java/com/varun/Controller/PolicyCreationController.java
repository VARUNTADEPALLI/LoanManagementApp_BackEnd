package com.varun.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.PolicyCreationService;
import com.varun.dto.PolicyCreationDto;
import com.varun.dto.PolicyDetailsDto;
import com.varun.dto.PolicyDto;
import com.varun.dto.PolicyRulesTableDto;
import com.varun.entity.New_User;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PolicyCreationController {
	
	@Autowired
	
	PolicyCreationService  policyCreationService;
	
	@PostMapping(value="api/savePolicyDetails")
	public String policyDetails(@RequestBody List<PolicyDetailsDto> detailsDto)
	{
		String msg = policyCreationService.savePolicy(detailsDto);
		return msg;
		
	}
	
	
	
	@PostMapping(value="api/updatePolicyDetails/{policyID}")
	public String updatePolicyDetails(@PathVariable("policyID") String policyId)
	{
		String msg = policyCreationService.updatePolicy(policyId);
		return msg;
		
	}
	
	
	@PostMapping(value="api/getPolicyDetailsWithInprogessApprovalStatus")
	public List<PolicyDetailsDto> getPolicyDetailsWithInprogessApprovalStatus()
	{
		List<PolicyDetailsDto> list = policyCreationService.getPolicyDetailsWithInprogessApprovalStatus();
		return list;
		
	}
	
	@PostMapping(value="api/updateApprovalStatusToApproved/{policyID}")
	public String updateApprovalStatusToApproved(@PathVariable("policyID") String policyId)
	{
		String msg = policyCreationService.updateApprovalStatusToApproved(policyId);
		return msg;
	}
	
	@PostMapping(value="api/getPolicyDetailsWithId/{policyID}")
	public List<PolicyRulesTableDto> getPolicyDetailsWithId(@PathVariable("policyID") String policyId)
	{
		List<PolicyRulesTableDto> list = policyCreationService.getPolicyDetailsWithId(policyId);
		return list;
	}
	

	@PostMapping(value="api/updatepolicyDetailsToRejected/{policyID}")
	public String updatepolicyDetailsToRejected(@PathVariable("policyID") String policyId)
	{
		String list = policyCreationService.updatepolicyDetailsToRejected(policyId);
		return list;
	}
	
	@PostMapping(value="api/getActivePolicyDetails")
	public List<PolicyDetailsDto> getActivePolicyDetails()
	{
		List<PolicyDetailsDto> list = policyCreationService.getActivePolicyDetails();
		return list;
	}
	
	
}
