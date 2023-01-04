package com.mysite.factory.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserVO {
	private String email;
	private String username;
	private String password;
	
}
