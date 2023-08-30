package com.varun.ServiceImpl;

import java.util.List;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.ActiveLoanDetailsService;
import com.varun.dao.ActiveLoanDetailsDao;
import com.varun.dto.ActiveLoanDetailsDto;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ActiveLoanDetailsServiceImpl implements ActiveLoanDetailsService{
	
	@Autowired
	ActiveLoanDetailsDao activeLoanDetailsDao;

	@Override
	public List<ActiveLoanDetailsDto> getCustomerLoanInfo(String mobile_number) {
		List<ActiveLoanDetailsDto> details  = activeLoanDetailsDao.getCustomerLoanInfo(mobile_number);
		return details;
	}

}
