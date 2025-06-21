package com.priyansh.fdAPI.services;

import org.springframework.http.ResponseEntity;

import com.priyansh.fdAPI.payloads.UserDto;

public interface UserService {

	public Integer getUserId(String email,String password);
	
	public Integer getUserIdByUsername(String username);
	
	public ResponseEntity<UserDto> createUser(UserDto userdto);
}
