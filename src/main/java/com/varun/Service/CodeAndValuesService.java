package com.varun.Service;

import java.util.List;

import com.varun.entity.CodeAndValues;

public interface CodeAndValuesService {

	List<CodeAndValues> getOptionsOfCompareType();

	List<CodeAndValues> getOptionsOfFactorType();

	List<CodeAndValues> getOptionsOfContinuationOperator();

	List<CodeAndValues> getOptionsOfOperator();

	List<CodeAndValues> getOptionsOfSubCondition();

	List<CodeAndValues> getOptionsOfSubConditionForFinish();

	List<CodeAndValues> getOptionsForCompanyCode();

	List<CodeAndValues> getPolicyStatus();

	List<CodeAndValues> getPolicyType();

	String getApprovalStatusAsInProgress();

	String getPolicyStatusCode(String policyStatus);

}
