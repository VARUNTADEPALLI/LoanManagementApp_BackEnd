package com.varun.Service;

import java.util.List;

import com.varun.dto.LoanCalculatorDto;
import com.varun.dto.ScheduleDto;
import com.varun.entity.CodeAndValues;

public interface LoanCaluatorService {

	List<CodeAndValues> getIntrestrateType();

	List<CodeAndValues> getPaymentFrequency();

	List<ScheduleDto> getCompleteLoanSchedule(LoanCalculatorDto loanCalculatorDto);

}
