package com.mysite.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysite.factory.service.UserService;
import com.mysite.factory.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/board/login")
	public String login() {
		return "/board/login";
	}
	
	@GetMapping("/board/signup")
	public String sign() {
		return "/board/signup";
	}
	
	@PostMapping("/board/signup")
	public String signup(UserVO user) {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 userservice.insert(user);
		 log.info("회원가입 성공");
		return "/board/login";
	}
}
