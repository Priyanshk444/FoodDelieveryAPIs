package com.priyansh.fdAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansh.fdAPI.exceptions.ApiException;
import com.priyansh.fdAPI.payloads.UserDto;
import com.priyansh.fdAPI.security.JwtAuthRequest;
import com.priyansh.fdAPI.security.JwtAuthResponse;
import com.priyansh.fdAPI.security.JwtHelper;
import com.priyansh.fdAPI.services.UserService;


@RestController
@CrossOrigin()
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@PostMapping("/user/login")
	public ResponseEntity<JwtAuthResponse> postMethodName(@RequestBody JwtAuthRequest request) throws Exception {
		
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetail = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtHelper.generateToken(userDetail);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		response.setUserId(userService.getUserId(userDetail.getUsername(),userDetail.getPassword()));
		
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			/*
			 * AuthenticationManager internally uses DaoAuthenticationProvider, which calls your 
			 * CustomUserDetailSercice to load the user from the database and compare the password 
			 * using BCryptPasswordEncoder
			 */
			this.authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException e) {
			System.out.println("Bad details!!");
			throw new ApiException("Invalid username and password"); 
		}
	}
	
	@PostMapping("/user/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
	
}
