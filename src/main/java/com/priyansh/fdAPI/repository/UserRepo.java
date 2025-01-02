package com.priyansh.fdAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyansh.fdAPI.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String email,String password);
	Optional<User> findByEmail(String Email);
}
