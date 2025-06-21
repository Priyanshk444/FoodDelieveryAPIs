package com.priyansh.fdAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyansh.fdAPI.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
