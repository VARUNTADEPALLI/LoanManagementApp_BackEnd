package com.varun.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.ActiveLoanDetailsService;
import com.varun.dto.ActiveLoanDetailsDto;
import com.varun.entity.New_User;

@RestController
public class ActiveLoansController {
	
	@Autowired
	ActiveLoanDetailsService activeLoanDetailsService;
	
	@GetMapping("api/GetCustomerLoanDetails/{mobile_Number}")
	public List<ActiveLoanDetailsDto> updateDetails(@PathVariable("mobile_Number") String mobile_Number)
	{
		List<ActiveLoanDetailsDto> inf = activeLoanDetailsService.getCustomerLoanInfo(mobile_Number);
		
        return inf;
		
		
	}

}
