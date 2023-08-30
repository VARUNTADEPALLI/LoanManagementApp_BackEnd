package com.varun.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.varun.Service.EmailExpiryService;
import com.varun.Service.EmailSenderService;
import com.varun.Service.OtpExpiryService;
import com.varun.dto.EmailOtpDto;
import com.varun.dto.TempOtpDto;


@Service
public class EmailOtpSericeImpl implements EmailSenderService{

	@Autowired
	 JavaMailSender mailSender;
	
	@Autowired 
	EmailExpiryService emailExpiryService;
	
	


    @Override
    public void sendEmail(@RequestBody EmailOtpDto emailOtpDto) {
    	int number=emailExpiryService.generateOTP(emailOtpDto.getTo());
    	emailOtpDto.setOtp(number);
    	String otp = Integer.toString(number);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //simpleMailMessage.setFrom("");
        simpleMailMessage.setTo(emailOtpDto.getTo());
        simpleMailMessage.setSubject(emailOtpDto.getSubject());
        simpleMailMessage.setText("Please find the verification code sent\n"+otp);
        this.mailSender.send(simpleMailMessage);
    }

}
