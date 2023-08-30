package com.varun.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.EmailExpiryService;
import com.varun.Service.OtpExpiryService;
import com.varun.dto.EmailOtpDto;
import com.varun.dto.OtpStorageDto;
import com.varun.dto.TempEmailDto;
import com.varun.dto.TempOtpDto;

@RestController
public class VerifyOtpController {
	
	@Autowired
	OtpExpiryService expiryService;
	
	@Autowired 
	EmailExpiryService emailExpiryService;
	
	
	@PostMapping("/verifyMobileOtp")
	public String verifyOtp(@RequestBody TempOtpDto tempOtpDto)
	{
		System.out.println(tempOtpDto.getOtp());
		System.out.println( expiryService.getOtp(tempOtpDto.getPhone()));
		if(tempOtpDto.getOtp()== expiryService.getOtp(tempOtpDto.getPhone()))
		{
			expiryService.clearOTP(tempOtpDto.getPhone());
			return "correct Otp";
		}
		else
			return "wrang";
	}
	
	
	@PostMapping("/verifyEmailOtp")
	public String verifyEmailOtp(@RequestBody TempEmailDto emailOtpDto)
	{
		System.out.println("email"+emailOtpDto.getOtp());
		System.out.println( emailExpiryService.getOtp(emailOtpDto.getEmail()));
		if(emailOtpDto.getOtp()== emailExpiryService.getOtp(emailOtpDto.getEmail()))
		{
			emailExpiryService.clearOTP(emailOtpDto.getEmail());
			return "correct Otp";
		}
		else
			return "wrang";
	}
	


}
