package com.varun.Service;

import com.varun.dto.LoanStatusDTO;
import com.varun.dto.RemainingPaymentDto;
import com.varun.entity.AddressDetails;

public interface LoanStatusService {

	LoanStatusDTO getloanDetailsbyid(String customerId, String loanType,String mobilenumber);

	RemainingPaymentDto getPaymentDetailsbyid(String loanId);

	AddressDetails getAddressDetailsbyid(String customerId);

}
