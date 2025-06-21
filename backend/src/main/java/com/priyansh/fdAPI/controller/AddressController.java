package com.priyansh.fdAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansh.fdAPI.payloads.AddressDto;
import com.priyansh.fdAPI.services.AddressService;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<AddressDto>> getAllAddress(@PathVariable("userId") Integer userId) {
		 List<AddressDto> addressDtos = addressService.getAllAddress(userId);
		 return new ResponseEntity<List<AddressDto>>(addressDtos,HttpStatus.OK);
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto,@PathVariable("userId") Integer userId){
		return addressService.addAdress(addressDto, userId);
	}
	

}
