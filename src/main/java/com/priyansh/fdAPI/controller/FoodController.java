package com.priyansh.fdAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansh.fdAPI.payloads.FoodDto;
import com.priyansh.fdAPI.services.FoodServices;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodServices foodServices;
	
	@PostMapping()
//	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<List<FoodDto>> addAllFoodItems(@RequestBody List<FoodDto> foodItems) {
		return foodServices.addAllFoodItem(foodItems);
	}
	
	@GetMapping()
	public ResponseEntity<List<FoodDto>> getAllFoodItems(){
		return foodServices.getAllFoodItem();
	}
	
	@DeleteMapping("/delete")
//	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<FoodDto> deleteFoodItem(@PathVariable Integer foodId){
		return foodServices.removeFoodItem(foodId);
		
	}
	
	@PostMapping("/addOn")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<FoodDto> addNewAddOn(){
		return null;
	}
	
	@DeleteMapping("/addOn")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<FoodDto> deleteFoodAddOn(){
		return null;
	}
	
	
}
