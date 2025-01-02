package com.priyansh.fdAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyansh.fdAPI.entities.Address;
import com.priyansh.fdAPI.entities.User;

import java.util.*;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	
	List<Address> findByUser(User user);

}
