package com.varun.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.CodeAndValuesService;
import com.varun.dao.CodeAndValuesDao;
import com.varun.entity.CodeAndValues;

import jakarta.transaction.Transactional;

@Service
@Transactional


public class CodeAndValuesServiceImpl implements CodeAndValuesService{

	@Autowired
	CodeAndValuesDao codeAndValuesDao;
	
	@Override
	public List<CodeAndValues> getOptionsOfCompareType() {
		List<CodeAndValues> compareTypeOptions = codeAndValuesDao.getOptionsOfCompareType();
		return compareTypeOptions;
	}

	@Override
	public List<CodeAndValues> getOptionsOfFactorType() {
		List<CodeAndValues> factorTypeOptions = codeAndValuesDao.getOptionsOfFactorType();
		return factorTypeOptions;
	}

	@Override
	public List<CodeAndValues> getOptionsOfContinuationOperator() {
		List<CodeAndValues> continuationOperatorOptions = codeAndValuesDao.getOptionsOfContinuationOperator();
		return continuationOperatorOptions;
	}

	@Override
	public List<CodeAndValues> getOptionsOfOperator() {
		List<CodeAndValues> operatorOptions = codeAndValuesDao.getOptionsOfOperator();
		return operatorOptions;
	}

	@Override
	public List<CodeAndValues> getOptionsOfSubCondition() {
		List<CodeAndValues> subConditionOptions = codeAndValuesDao.getOptionsOfSubCondition();
		return subConditionOptions;
	}

	@Override
	public List<CodeAndValues> getOptionsOfSubConditionForFinish() {
		List<CodeAndValues> subConditionOptions = codeAndValuesDao.getOptionsOfSubConditionForFinish();
		return subConditionOptions;
	}

	@Override
	public List<CodeAndValues> getOptionsForCompanyCode() {
		List<CodeAndValues> copmpanyCode = codeAndValuesDao.getOptionsForCompanyCode();
		return copmpanyCode;
	}

	@Override
	public List<CodeAndValues> getPolicyStatus() {
		List<CodeAndValues> policyStatus = codeAndValuesDao.getPolicyStatus();
		return policyStatus;
	}

	@Override
	public List<CodeAndValues> getPolicyType() {
		List<CodeAndValues> policyType = codeAndValuesDao.getPolicyType();
		return policyType;
	}

	@Override
	public String getApprovalStatusAsInProgress() {
		String inProgressStatus = codeAndValuesDao.getApprovalStatusAsInProgress();
		return inProgressStatus;
	}

	@Override
	public String getPolicyStatusCode(String policyStatus) {
		String policyStatusCode = codeAndValuesDao.getPolicyStatusCode(policyStatus);
		return policyStatusCode;
	}

}
