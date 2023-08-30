package com.varun.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Service.IUserService;
import com.varun.entity.New_User;


@RestController
public class RegistrationController {	
	@Autowired
	private IUserService userservice;
	
	@PostMapping(value="api/saveCustomerDetails")
	public String saveUserDetails(@RequestBody New_User info)
	
	{
		
		return  userservice.addUserDetails(info);
		
	}
	
	@PutMapping("api/updateCustomerDetails")
	public String updateDetails(@RequestBody New_User info)
	{
		String inf = userservice.updateCustomerInfo(info);
		
        return inf;
		
		
	}
	
	@PostMapping("api/login")
	public String getUser(@RequestBody New_User info){
		String msg=userservice.getCustomerDetailsById(info);
		return msg;
			
		
		
		
	}
	
}
