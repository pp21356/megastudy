package com.mysite.factory.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysite.factory.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserDetails userDetails = userService.getUserDetails(email);
		
		if(userDetails == null) {
			throw new UsernameNotFoundException("유효하지 않는 로그인 정보입니다.");
		}
		
		return userDetails;
	}

}