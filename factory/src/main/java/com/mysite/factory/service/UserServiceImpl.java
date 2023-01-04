package com.mysite.factory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mysite.factory.dao.UserDAO;
import com.mysite.factory.vo.UserVO;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserDAO userdao;
	@Override
	public UserDetails getUserDetails(String email) {
		return userdao.getUserDetails(email);
		
	}
	@Override
	public void insert(UserVO user) {
		userdao.insert(user);
		
	}
	
}
