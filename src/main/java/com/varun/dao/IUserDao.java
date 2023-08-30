package com.varun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.entity.New_User;

public interface IUserDao  extends JpaRepository<New_User,String>{

}
