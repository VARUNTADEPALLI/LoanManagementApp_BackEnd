package com.varun.dao;

import java.util.List;

import com.varun.dto.ActiveLoanDetailsDto;

public interface ActiveLoanDetailsDao {

	List<ActiveLoanDetailsDto> getCustomerLoanInfo(String mobile_number);

}
