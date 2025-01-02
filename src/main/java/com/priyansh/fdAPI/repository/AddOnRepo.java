package com.priyansh.fdAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyansh.fdAPI.entities.AddOns;

public interface AddOnRepo extends JpaRepository<AddOns, Integer> {

}
