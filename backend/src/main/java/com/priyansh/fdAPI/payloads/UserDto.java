package com.priyansh.fdAPI.payloads;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private Integer id;
	
	private String email;
	
	private String password;
	
	private List<AddressDto> allAddresses = new ArrayList<>();
}
