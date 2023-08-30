package com.varun.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Service.PaymentService;
import com.varun.dao.PaymentDao;
import com.varun.dto.PaymentDto;
import com.varun.dto.RemainingPaymentDto;
import com.varun.dto.StatementDatesDto;
import com.varun.dto.TermPaymentDto;
import com.varun.dto.TotalDueDto;
import com.varun.entity.PaymentDetails;
import com.varun.entity.UnbilledTransactions;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentDao paymentDao;

	@Override
	public StatementDatesDto getDates(String loanId,int term) {
		StatementDatesDto result = paymentDao.getduedate(loanId,term);
		return result;
	}

	@Override
	public TotalDueDto getInstallmentOutstanding(String loanId) {
		TotalDueDto result = paymentDao.getduedate(loanId);
		return result;
	}

	@Override
	public PaymentDto getTotalAmounts(String loanId) {
		PaymentDto result = paymentDao.getTotalAmount(loanId);
		return result;
	}

	@Override
	public TermPaymentDto getDetailsByterm(int term) {
		TermPaymentDto result = paymentDao.getTermDetails(term);
		return result;
		
	}

	@Override
	public void updateSchedule(double amount) {
		double intrestBalance = 0.00;
		double principalBalance = 0.00;
		double installmentBalance = 0.00;
		double intrestAmount = 0.00;
		double principalAmount = 0.00;
		double installmentAount = 0.00;
		int term = 0;
		List<PaymentDetails> result = paymentDao.updateRepaymentSchedule(amount);
		for(int i=0;i<result.size();i++)
		{
			term = result.get(i).getTerm();
			if(result.get(i).getIntrestPaid() <result.get(i).getIntrestAmount())
			{
				intrestBalance = result.get(i).getIntrestAmount() - result.get(i).getIntrestPaid();
				
				if(amount< intrestBalance)
				{
					
					intrestAmount = result.get(i).getIntrestPaid() + amount;
					paymentDao.updateIntrestPaid(intrestAmount,term);
					result.get(i).setIntrestPaid(intrestAmount);
					amount=0;
				}
				else if(amount>=intrestBalance)
				{
					intrestAmount = result.get(i).getIntrestPaid() + intrestBalance;
					paymentDao.updateIntrestPaid(intrestAmount,term);
					result.get(i).setIntrestPaid(intrestAmount);
					amount=amount-intrestBalance;
					
				}
				
			}
			
			if(amount==0)
			{
				break;
			}
			else if(amount>0 && result.get(i).getPrincipalPaid() < result.get(i).getPrincipalAmount())
			{	
					principalBalance = result.get(i).getPrincipalAmount() - result.get(i).getPrincipalPaid();
					
					if(amount < principalBalance)
					{
						principalAmount = result.get(i).getPrincipalPaid()+amount;
						installmentAount = result.get(i).getIntrestPaid() + principalAmount;
						paymentDao.updatePrincipalPaid(principalAmount,term,installmentAount);
						amount=0;
					}
					else if(amount >= principalBalance)
					{
						principalAmount = result.get(i).getPrincipalPaid()+principalBalance;
						installmentAount = result.get(i).getIntrestPaid() + principalAmount;
						paymentDao.updatePrincipalPaid(principalAmount,term,installmentAount);
						amount = amount - principalBalance;
					}
				
				
			}
			if(amount==0)
			{
				break;
			}
			
		}
		
	}

	@Override
	public void saveUnbilledTransactionDetails(UnbilledTransactions unbilledTransactions) {
		
		paymentDao.saveTransactionDetails(unbilledTransactions);
	}

}
