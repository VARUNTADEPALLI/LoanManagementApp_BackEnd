package com.varun.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.OtpService;
import com.varun.dto.OTPDto;



@RestController
public class OTPController {
	
	@Autowired
	OtpService service;
	
	
	
	 SimpMessagingTemplate webSocket;

	

	private final String  TOPIC_DESTINATION = "/lesson/sms";

	

 @RequestMapping(value = "/api/getOtp", method = RequestMethod.POST,
         consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> smsSubmit(@RequestBody OTPDto sms)
 {
	
         service.send(sms);
    
       
         webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getPhoneNumber());
      return new ResponseEntity<Boolean>(true,HttpStatus.OK);
  }


  private String getTimeStamp() {
     return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
  }

}



