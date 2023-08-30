package com.varun.Service;

import java.util.List;

import com.varun.dto.ActiveLoanDetailsDto;

public interface ActiveLoanDetailsService {

	List<ActiveLoanDetailsDto> getCustomerLoanInfo(String mobile_number);

}
