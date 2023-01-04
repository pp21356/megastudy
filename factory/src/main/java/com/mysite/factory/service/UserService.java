package com.mysite.factory.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mysite.factory.vo.UserVO;

@Service
public interface UserService {
	public UserDetails getUserDetails(String email);
	public void insert(UserVO user);
}
