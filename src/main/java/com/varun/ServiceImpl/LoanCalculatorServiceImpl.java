package com.varun.ServiceImpl;

import java.awt.dnd.DropTargetDragEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.LoanCaluatorService;
import com.varun.dao.LoanCalculatorDao;
import com.varun.dto.LoanCalculatorDto;
import com.varun.dto.ScheduleDto;
import com.varun.entity.CodeAndValues;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class LoanCalculatorServiceImpl implements LoanCaluatorService{
	
	@Autowired
	LoanCalculatorDao loanCalculatorDao;

	@Override
	public List<CodeAndValues> getIntrestrateType() {
		List<CodeAndValues> result = loanCalculatorDao.getIntrestRateType();
		return result;
	}

	@Override
	public List<CodeAndValues> getPaymentFrequency() {
		List<CodeAndValues> result = loanCalculatorDao.getPaymentFrequencyFromCodeAndValues();
		return result;
	}

	@Override
	public List<ScheduleDto> getCompleteLoanSchedule(LoanCalculatorDto loanCalculatorDto) {
		
		LocalDate currentDate1 = LocalDate.now();
		List<ScheduleDto> result = new ArrayList<>();
		 long daysDifference = 0;
		 long timeDifference =0;
		BigDecimal principalAdjusted = BigDecimal.ZERO;
		BigDecimal totalInstallment = BigDecimal.ZERO;
		BigDecimal totalinterest = BigDecimal.ZERO;
		
		BigDecimal principalAdjustedSum = BigDecimal.ZERO;
		BigDecimal interestAmount = BigDecimal.ZERO;
		BigDecimal interestAmount1 = BigDecimal.ZERO;
		BigDecimal netInterestAmount = BigDecimal.ZERO;
		BigDecimal principalBalance = loanCalculatorDto.getLoanAmount();
		LocalDate date = LocalDate.now();
		int numberOfPayments = loanCalculatorDao.getLoanSchedule(loanCalculatorDto);
		BigDecimal noPayments = new BigDecimal(numberOfPayments);
		BigDecimal hundred = new BigDecimal(100);
		BigDecimal thirty = new BigDecimal(30);
		double interestFactor = 12/(double)numberOfPayments;
		BigDecimal interestFactora = new BigDecimal(interestFactor);
		interestFactora = interestFactora.setScale(3, BigDecimal.ROUND_HALF_EVEN);
		interestFactor = interestFactora.doubleValue();
		BigDecimal rateOfInterest = BigDecimal.ZERO;
		BigDecimal NetEMI = BigDecimal.ZERO;
		BigDecimal EMI1 = BigDecimal.ZERO;
		BigDecimal EMI2 = BigDecimal.ZERO;
		BigDecimal multiplier = new BigDecimal(loanCalculatorDto.getIntrestRate());
		rateOfInterest = interestFactora.multiply(multiplier);
		BigDecimal divisor = new BigDecimal(1200);
		rateOfInterest = rateOfInterest.divide(divisor,5, RoundingMode.HALF_EVEN);
		double equivalentInterestRate = rateOfInterest.doubleValue();
		BigDecimal one = new BigDecimal(1);
		BigDecimal onePlusRateOfInterest = rateOfInterest.add(one);
		EMI1 = loanCalculatorDto.getLoanAmount().multiply(rateOfInterest);
		EMI1 = EMI1.multiply(onePlusRateOfInterest.pow(loanCalculatorDto.getTerm()));
		EMI1 = EMI1.subtract(loanCalculatorDto.getRemainingValue().multiply(rateOfInterest));
		EMI2 = onePlusRateOfInterest.pow(loanCalculatorDto.getTerm()).subtract(one);
		NetEMI = EMI1.divide(EMI2,2, RoundingMode.HALF_EVEN);
		double EMI = NetEMI.doubleValue();
		System.out.println(EMI);
		String freq = loanCalculatorDto.getPaymentFrequency();
		int addDays = 0;
		int addmonths = 0;
		switch (freq) {
		case "Monthly": {
			addmonths = 1;
			break;
			
		}
		case "Quarterly": {
			addmonths = 3;
			break;
			
		}
		case "Yearly": {
			addmonths = 12;
			break;
			
		}
		case "Weekly": {
			addDays = 7;
			break;
			
		}
		case "Bi Weekly": {
			addDays = 15;
			break;
			
		}
		case "Fortnightly": {
			addDays = 14;
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + freq);
		}
		LocalDate firstDueDate1 =  LocalDate.now();
		if(freq.equals("Monthly") || freq.equals("Quarterly") || freq.equals("Yearly"))
		{
			firstDueDate1 =  LocalDate.now().plusMonths(addmonths);
		}
		else
		{
			firstDueDate1 =  LocalDate.now().plusDays(addDays);
		}
		 
		 Date currentDate = Date.valueOf(currentDate1);
		BigDecimal intrstRate = new BigDecimal(loanCalculatorDto.getIntrestRate());
		if(firstDueDate1.compareTo(currentDate1)>0)
		{
			Date firstDueDate = Date.valueOf(firstDueDate1);
			
			 timeDifference = firstDueDate.getTime() - currentDate.getTime();
			  daysDifference = (timeDifference / (1000*60*60*24)) % 365; 
			  for(int i=0;i<loanCalculatorDto.getTerm();i++)
				{
				  	LocalDate period1 =  currentDate1;
				  	ScheduleDto calculatorDto = new ScheduleDto();
					calculatorDto.setFirstDueDate(firstDueDate);
						int difference = 0;
						if(i==0)
						{
							difference = (int) (daysDifference+1);
							BigDecimal numberOfDays = new BigDecimal(difference);
							interestAmount = principalBalance.multiply(intrstRate).multiply(numberOfDays);
							interestAmount1 = noPayments.multiply(hundred).multiply(thirty);
							netInterestAmount = interestAmount.divide(interestAmount1,2,RoundingMode.HALF_EVEN);
							
							System.out.println(netInterestAmount);
						} 
						
						else if(i==loanCalculatorDto.getTerm()-1)
						{
							interestAmount = principalBalance.multiply(intrstRate);
							interestAmount1 = noPayments.multiply(hundred);
							netInterestAmount = interestAmount.divide(interestAmount1,2,RoundingMode.HALF_EVEN);
							NetEMI = principalBalance.add(netInterestAmount);
						}
						else
						{
							interestAmount = principalBalance.multiply(intrstRate);
							interestAmount1 = noPayments.multiply(hundred);
							netInterestAmount = interestAmount.divide(interestAmount1,2,RoundingMode.HALF_EVEN);
						}
						
						if(loanCalculatorDto.getPaymentFrequency().equals("Monthly") || loanCalculatorDto.getPaymentFrequency().equals("Quarterly") || loanCalculatorDto.getPaymentFrequency().equals("Yearly"))
						{
						 period1 =  currentDate1.plusMonths(addmonths);
						}
						else
						{
							period1 =  currentDate1.plusDays(addDays);
						}
						
						Date period = Date.valueOf(period1);
						currentDate1 = period1;
				
						principalAdjusted = NetEMI.subtract(netInterestAmount);
						principalBalance = principalBalance.subtract(principalAdjusted);
						principalAdjustedSum = principalAdjustedSum.add(principalAdjusted);
						totalInstallment = totalInstallment.add(NetEMI);
						totalinterest = totalinterest.add(netInterestAmount);
						calculatorDto.setTotalInstallmentAmount(totalInstallment);
						calculatorDto.setTotalInterestAmount(totalinterest);
						calculatorDto.setTotalPrincipal(principalAdjustedSum);
						calculatorDto.setPaymentFrequency(loanCalculatorDto.getPaymentFrequency());
						calculatorDto.setPeriod(period);
						calculatorDto.setRemainingValue(loanCalculatorDto.getRemainingValue());
						calculatorDto.setLoanAmount(loanCalculatorDto.getLoanAmount());
						//calculatorDto.setFirstDueDate(loanCalculatorDto.getFirstDueDate());
						calculatorDto.setDisbursalDate(currentDate);
						calculatorDto.setPrincipal(principalAdjusted);
						calculatorDto.setInstallmentAmount(NetEMI);
						calculatorDto.setInterestAmount(netInterestAmount);
						calculatorDto.setPrincipalOutstanding(principalBalance);
						calculatorDto.setTerm(i+1);
						calculatorDto.setIntrestRate(loanCalculatorDto.getIntrestRate());
						
						result.add(calculatorDto);
						
						}
			  
		}
		double netInterest = netInterestAmount.doubleValue();
		double principalBal = principalBalance.doubleValue();
		return result;
	}

}
