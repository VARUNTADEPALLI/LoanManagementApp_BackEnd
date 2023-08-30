package com.varun.dao;

import com.varun.dto.LoanStatusDTO;
import com.varun.dto.RemainingPaymentDto;
import com.varun.entity.AddressDetails;

public interface LoanStatusDao {

	LoanStatusDTO getLoanStatusDetailsById(String customerId, String loanType,String mobilenumber);

	RemainingPaymentDto getPaymentDetails(String loanId);

	AddressDetails getAddressDetails(String customerId);

}
