package com.varun.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.ActiveLoanDetailsService;
import com.varun.Service.LoanCaluatorService;
import com.varun.dto.ActiveLoanDetailsDto;
import com.varun.dto.LoanCalculatorDto;
import com.varun.dto.ScheduleDto;
import com.varun.entity.CodeAndValues;

@RestController
public class LoanCalculatorController {
	
	@Autowired
	LoanCaluatorService loanCaluatorService;
	
	@PostMapping("api/getIntrestrateType")
	public List<CodeAndValues> getIntrestRateType()
	{
		List<CodeAndValues> result = loanCaluatorService.getIntrestrateType();
		
        return result;
	}
	
	@PostMapping("api/getPaymentFrequency")
	public List<CodeAndValues> getPaymentFrequencyFromCodeAndValues()
	{
		List<CodeAndValues> result = loanCaluatorService.getPaymentFrequency();
		
        return result;
	}
	
	
	@PostMapping("api/getLoanSchedule")
	public List<ScheduleDto> getLoanSchedule(@RequestBody LoanCalculatorDto loanCalculatorDto)
	{
		List<ScheduleDto> result = loanCaluatorService.getCompleteLoanSchedule(loanCalculatorDto);
		
        return result;
	}

}
