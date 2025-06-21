package com.priyansh.fdAPI.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.priyansh.fdAPI.payloads.AddOnDto;
import com.priyansh.fdAPI.payloads.FoodDto;

public interface FoodServices {
	ResponseEntity<List<FoodDto>> addAllFoodItem(List<FoodDto> allFood);
	ResponseEntity<List<FoodDto>> getAllFoodItem();
	ResponseEntity<FoodDto> getFoodItemById(Integer id);
	ResponseEntity<FoodDto> removeFoodItem(Integer foodId);
	ResponseEntity<FoodDto> addNewAddOn(AddOnDto addOnDto,Integer foodId);
	ResponseEntity<FoodDto> deleteAddOn(Integer addOnId,Integer foodId);
}
