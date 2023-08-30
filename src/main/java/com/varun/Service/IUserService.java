package com.varun.Service;

import java.util.Optional;

import com.varun.entity.New_User;

public interface IUserService {
	
	public String addUserDetails(New_User info);

	public String updateCustomerInfo(New_User info);

	public String getCustomerDetailsById(New_User info);
	

}
