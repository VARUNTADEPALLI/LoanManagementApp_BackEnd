package com.varun.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.LoanStatusService;
import com.varun.dto.LoanStatusDTO;
import com.varun.dto.RemainingPaymentDto;
import com.varun.entity.AddressDetails;
import com.varun.entity.New_User;

@RestController
public class LoanStatusController {
	
	@Autowired
	LoanStatusService loanStatusService;

	@GetMapping("api/getLoanDetails/{customerId}/{loanType}/{mobilenumber}")
	public LoanStatusDTO getUser(@PathVariable("customerId") String customerId,@PathVariable("loanType") String loanType,@PathVariable("mobilenumber") String mobilenumber){
		LoanStatusDTO statusdto = null;
		 statusdto = loanStatusService.getloanDetailsbyid(customerId,loanType,mobilenumber);
		return statusdto;
		
	}
	
	
	@GetMapping("api/getPaymentDetails/{loanId}")
	public RemainingPaymentDto getPaymentDetails(@PathVariable("loanId") String loanId){
		RemainingPaymentDto statusdto = null;
		 statusdto = loanStatusService.getPaymentDetailsbyid(loanId);
		return statusdto;
		
	}
	
	
	@GetMapping("api/getAddressDetails/{customerId}")
	public AddressDetails getAddressDetails(@PathVariable("customerId") String customerId){
		AddressDetails statusdto = null;
		 statusdto = loanStatusService.getAddressDetailsbyid(customerId);
		return statusdto;
		
	}
	
	
}
