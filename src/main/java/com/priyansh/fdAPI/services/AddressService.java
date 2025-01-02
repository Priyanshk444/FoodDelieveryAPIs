package com.priyansh.fdAPI.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.priyansh.fdAPI.payloads.AddressDto;

public interface AddressService {
	List<AddressDto> getAllAddress(Integer userId);
	ResponseEntity<AddressDto> addAdress(AddressDto address,Integer userId);
}
