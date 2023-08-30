package com.varun.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.CodeAndValuesService;
import com.varun.entity.CodeAndValues;
import com.varun.entity.New_User;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CodeAndValuesController {
	
	@Autowired
	CodeAndValuesService   codeAndValuesService;

	@PostMapping(value="api/getCompareTypeOptions")
	public List<CodeAndValues> getCompareTypeOptions()
	{
		List<CodeAndValues> compareTypeOptions = codeAndValuesService.getOptionsOfCompareType();
		return compareTypeOptions;
		
	}
	
	@PostMapping(value="api/getFactorTypeOptions")
	public List<CodeAndValues> getFactorTypeOptions()
	{
		List<CodeAndValues> factorTypeOptions = codeAndValuesService.getOptionsOfFactorType();
		return factorTypeOptions;
		
	}
	
	
	@PostMapping(value="api/getContinuationOperatorOptions")
	public List<CodeAndValues> getContinuationOperatoreOptions()
	{
		List<CodeAndValues> continuationOperatorOptions = codeAndValuesService.getOptionsOfContinuationOperator();
		return continuationOperatorOptions;	
	}	
	
	
	@PostMapping(value="api/getOperatorOptions")
	public List<CodeAndValues> getOperatoreOptions()
	{
		List<CodeAndValues> operatorOptions = codeAndValuesService.getOptionsOfOperator();
		return operatorOptions;
		
	}	
	
	@PostMapping(value="api/getSubConditionOptions")
	public List<CodeAndValues> getSubConditionOptions()
	{
		List<CodeAndValues> subConditionOptions = codeAndValuesService.getOptionsOfSubCondition();
		return subConditionOptions;
	}	
	
	@PostMapping(value="api/getSubConditionOptionsForFinish")
	public List<CodeAndValues> getSubConditionOptionsForFinish()
	{
		List<CodeAndValues> subConditionOptionsForFinish = codeAndValuesService.getOptionsOfSubConditionForFinish();
		return subConditionOptionsForFinish;
	}	
	
	
	@PostMapping(value="api/getCompanyCode")
	public List<CodeAndValues> getOptionsForCompanyCode()
	{
		List<CodeAndValues> companyCode = codeAndValuesService.getOptionsForCompanyCode();
		return companyCode;
		
	}	
	
	@PostMapping(value="api/getPolicyStatus")
	public List<CodeAndValues> getPolicyStatus()
	{
		List<CodeAndValues> policyStatus = codeAndValuesService.getPolicyStatus();
		return policyStatus;
		
	}
	
	@PostMapping(value="api/getPolicyType")
	public List<CodeAndValues> getPolicyType()
	{
		List<CodeAndValues> policyType = codeAndValuesService.getPolicyType();
		return policyType;
		
	}
	
	@PostMapping(value="api/getApprovalStatusAsInProgress")
	public String getApprovalStatusAsInProgress()
	{
		String inProgressStatus = codeAndValuesService.getApprovalStatusAsInProgress();
		return inProgressStatus;
		
	}
	
	
	@PostMapping(value="api/getPolicyStatusCode/{statusForPolicy}")
	public String getPolicyStatusCode(@PathVariable("statusForPolicy") String policyStatus)
	{
		String policyStatusCode = codeAndValuesService.getPolicyStatusCode(policyStatus);
		return policyStatusCode;
		
	}
}
