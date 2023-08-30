package com.varun.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.EmailSenderService;
import com.varun.dto.EmailOtpDto;

@RestController
public class EmailOtpController {
	
	@Autowired
	EmailSenderService emailSenderService;

	@PostMapping("/send-email")
	public ResponseEntity sendEmail(@RequestBody EmailOtpDto emailOtpDto)
	{
		this.emailSenderService.sendEmail(emailOtpDto);
		return ResponseEntity.ok("Success");
	}

}
