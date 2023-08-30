package com.varun.dao;

import java.util.List;

import com.varun.dto.LoanCalculatorDto;
import com.varun.entity.CodeAndValues;

public interface LoanCalculatorDao {

	List<CodeAndValues> getIntrestRateType();

	List<CodeAndValues> getPaymentFrequencyFromCodeAndValues();

	int getLoanSchedule(LoanCalculatorDto loanCalculatorDto);

}
