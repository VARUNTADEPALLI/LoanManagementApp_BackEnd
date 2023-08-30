package com.varun.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.LoanStatusService;
import com.varun.dao.LoanStatusDao;
import com.varun.dto.LoanStatusDTO;
import com.varun.dto.RemainingPaymentDto;
import com.varun.entity.AddressDetails;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanStatusServiceImpl implements LoanStatusService{
	
	@Autowired
	LoanStatusDao loanStatusDao;

	@Override
	public LoanStatusDTO getloanDetailsbyid(String customerId, String loanType,String mobilenumber) {
		LoanStatusDTO statusdto = loanStatusDao.getLoanStatusDetailsById(customerId,loanType,mobilenumber);
		return statusdto;
	}

	@Override
	public RemainingPaymentDto getPaymentDetailsbyid(String loanId) {
		RemainingPaymentDto statusdto = loanStatusDao.getPaymentDetails(loanId);
		return statusdto;
	}

	@Override
	public AddressDetails getAddressDetailsbyid(String customerId) {
		AddressDetails statusdto = loanStatusDao.getAddressDetails(customerId);
		return statusdto;
	}
	

}
