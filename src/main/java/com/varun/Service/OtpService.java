  package com.varun.Service;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.varun.dto.OTPDto;
import com.varun.dto.OtpStorageDto;
import com.varun.dto.TempOtpDto;


@Component	
public class OtpService {
	
	
    @Autowired
    OtpExpiryService expiryService;

	private final String ACCOUNT_SID ="ACd961d660b21392ad0a23c1a199be0550";
									   
    private final String AUTH_TOKEN = "ddd3fdf5e7d18961dff8c929b94bcd34";
    								   

    private final String FROM_NUMBER = "+16203776192";

    public void send(OTPDto sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      

    	
        int number=expiryService.generateOTP(sms.getPhoneNumber());
      
        
        String msg ="Your OTP - "+number;
       
        
        Message message = Message.creator(new PhoneNumber(sms.getPhoneNumber()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
        
        //OtpStorageDto.setOtp(number);
        
      
    }

    public void receive(MultiValueMap<String, String> smscallback) {
   
    }

}

  
