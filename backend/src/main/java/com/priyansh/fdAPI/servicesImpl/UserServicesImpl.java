package com.priyansh.fdAPI.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.priyansh.fdAPI.services.UserService;
import com.priyansh.fdAPI.entities.Role;
import com.priyansh.fdAPI.entities.User;
import com.priyansh.fdAPI.exceptions.ResourceNotFoundException;
import com.priyansh.fdAPI.payloads.UserDto;
import com.priyansh.fdAPI.repository.RoleRepo;
import com.priyansh.fdAPI.repository.UserRepo;

@Service
public class UserServicesImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Integer getUserIdByUsername(String username) {
	    User user = userRepo.findByEmail(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
	    return user.getId();
	}

	
	public Integer getUserId(String email,String password) {
		User fetchedUser = userRepo.findByEmailAndPassword(email, password);
		if(fetchedUser == null) {
			return null;
		}
		return fetchedUser.getId();
	}
	

	@Override
	public ResponseEntity<UserDto> createUser(UserDto userdto) {
		User user = modelMapper.map(userdto,User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepo.findById(2).orElseThrow(()-> new ResourceNotFoundException("role", "role repo", 2));
		user.getRoles().add(role);

		User users = userRepo.save(user);
		
		return new ResponseEntity<UserDto>(modelMapper.map(users,UserDto.class),HttpStatus.CREATED);
	}

}
