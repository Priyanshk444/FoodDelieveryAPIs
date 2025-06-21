package com.priyansh.fdAPI.servicesImpl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyansh.fdAPI.entities.Address;
import com.priyansh.fdAPI.entities.User;
import com.priyansh.fdAPI.payloads.AddressDto;
import com.priyansh.fdAPI.repository.AddressRepo;
import com.priyansh.fdAPI.repository.UserRepo;
import com.priyansh.fdAPI.services.AddressService;
import com.priyansh.fdAPI.exceptions.ResourceNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	
	private AddressRepo addressRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<AddressDto> getAllAddress(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException("user","repository",userId));
		List<AddressDto> allAddress = addressRepo.findByUser(user).stream().map((addrs)->modelMapper.map(addrs, AddressDto.class)).collect(Collectors.toList());
		return allAddress;
	}

	@Override
	public ResponseEntity<AddressDto> addAdress(AddressDto address, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException("user","repository",userId));
		Address addrs = modelMapper.map(address, Address.class);
		addrs.setUser(user);
		Integer lowerEstTime = (new Random().nextInt(11-2+1)+2)*5 ;
		addrs.setEstLowerTime(lowerEstTime);
		addrs.setEstUpperTime(lowerEstTime + 5);
		addressRepo.save(addrs);
		return new ResponseEntity<AddressDto>(modelMapper.map(addrs, AddressDto.class),HttpStatus.OK);
	}

}
