package com.varun.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.varun.Service.IUserService;
import com.varun.dao.CustomerLoginDetailsDao;
import com.varun.dao.IUserDao;
import com.varun.entity.New_User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	  private IUserDao iuserdao;
	
	@Autowired
	  private CustomerLoginDetailsDao customerLoginDetailsDAO;
	
	

	
	PasswordEncoder encoder = new BCryptPasswordEncoder();


	public String addUserDetails(New_User info) {
		New_User userinfo =iuserdao.findById(info.getId()).orElse(null);
		if(userinfo==null)
		{
			String pass = this.encoder.encode(info.getPassword());
			info.setPassword(pass);
			iuserdao.save(info);	
			return "User added successfully";
		} 
		else
		{
			return "User Already Exists";
		}
	}
	

	@Override
	public String updateCustomerInfo(New_User info) {
		List<New_User> list = iuserdao.findAll();
		for(New_User inf1: list)
		{
			if(inf1.getId().equals(info.getId()))
			{
				String pass = this.encoder.encode(info.getPassword());
				inf1.setPassword(pass);
				
			}
		}
		return "update succesfull";
		
	}


	@Override
	public String getCustomerDetailsById(New_User info) {
		String msg = customerLoginDetailsDAO.findCustomerDetails(info);
		return msg;
	}
}
	