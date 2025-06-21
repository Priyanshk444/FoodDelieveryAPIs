package com.priyansh.fdAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyansh.fdAPI.entities.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}
