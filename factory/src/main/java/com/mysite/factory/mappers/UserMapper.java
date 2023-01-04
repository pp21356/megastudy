package com.mysite.factory.mappers;



import org.apache.ibatis.annotations.Mapper;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mysite.factory.vo.UserVO;



@Service
@Mapper
public interface UserMapper {
	
	public UserDetails getUserDetails(String email);
	public void insert(UserVO user);
}
