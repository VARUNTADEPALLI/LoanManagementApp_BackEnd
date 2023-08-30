package com.varun.Service;

import org.springframework.web.bind.annotation.RequestBody;

import com.varun.dto.EmailOtpDto;

public interface EmailSenderService {

	void sendEmail(@RequestBody EmailOtpDto emailOtpDto);

}
