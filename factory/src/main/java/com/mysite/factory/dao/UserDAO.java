package com.mysite.factory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.mysite.factory.mappers.UserMapper;
import com.mysite.factory.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private UserMapper userMapper;
	
	public UserDetails getUserDetails(String eamil) {
		return userMapper.getUserDetails(eamil);
	}
	public void insert(UserVO user) {
		userMapper.insert(user);
	}
}
