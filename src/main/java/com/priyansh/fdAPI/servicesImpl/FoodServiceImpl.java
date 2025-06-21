package com.priyansh.fdAPI.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyansh.fdAPI.entities.AddOns;
import com.priyansh.fdAPI.entities.Food;
import com.priyansh.fdAPI.exceptions.ResourceNotFoundException;
import com.priyansh.fdAPI.payloads.AddOnDto;
import com.priyansh.fdAPI.payloads.FoodDto;
import com.priyansh.fdAPI.repository.AddOnRepo;
import com.priyansh.fdAPI.repository.FoodRepo;
import com.priyansh.fdAPI.services.FoodServices;

@Service
public class FoodServiceImpl implements FoodServices {

	@Autowired
	private FoodRepo foodRepo;
	
	@Autowired
	private AddOnRepo addOnRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public ResponseEntity<List<FoodDto>> addAllFoodItem(List<FoodDto> allFood) {
	    List<Food> savedFoods = new ArrayList<>();

	    // Process each FoodDto
	    allFood.forEach(foodDto -> {
	        // Save Food entity first
	        Food food = mapper.map(foodDto, Food.class);

	        // Map and associate AddOns with Food (Cascading will automatically save AddOns)
	        List<AddOns> addOnsList = foodDto.getAddOns().stream()
	                .map(addOnDto -> {
	                    AddOns addOn = mapper.map(addOnDto, AddOns.class);
	                    addOn.setFood(food);  // Associate each add-on with the saved food
	                    return addOn;
	                })
	                .collect(Collectors.toList()); 

	        food.setAvailableAddOns(addOnsList);
	        Food savedFood = foodRepo.save(food);
	        savedFoods.add(savedFood);  // Add the food to the list for the final response
	    });

	    // Map saved Food entities back to FoodDto for the response
	    List<FoodDto> savedFoodDtos = savedFoods.stream()
	            .map(savedFood -> mapper.map(savedFood, FoodDto.class))
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(savedFoodDtos);
	}



	@Override
	public ResponseEntity<List<FoodDto>> getAllFoodItem() {
		List<FoodDto> AllFoodDtos = foodRepo.findAll().stream().map(food -> mapper.map(food, FoodDto.class)).collect(Collectors.toList());
		return ResponseEntity.ok(AllFoodDtos);
	}

	@Override
	public ResponseEntity<FoodDto> removeFoodItem(Integer foodId) {
		Food food = foodRepo.findById(foodId).orElseThrow(() -> new ResourceNotFoundException("Food", "Food Repository", foodId));
		foodRepo.delete(food);
		FoodDto foodDto = mapper.map(food,FoodDto.class);
		return ResponseEntity.ok(foodDto);
	}

	@Override
	public ResponseEntity<FoodDto> addNewAddOn(AddOnDto addOnDto, Integer foodId) {
		Food food = foodRepo.findById(foodId).orElseThrow(() -> new ResourceNotFoundException("Food", "Food Repository", foodId));
		List<AddOns> newAddOns = food.getAvailableAddOns();
		newAddOns.add(mapper.map(addOnDto, AddOns.class));
		food.setAvailableAddOns(newAddOns);
		
		FoodDto foodDto = mapper.map(food, FoodDto.class);
		return ResponseEntity.ok(foodDto);
	}

	@Override
	public ResponseEntity<FoodDto> deleteAddOn(Integer addOnId, Integer foodId) {
		AddOns addOn = addOnRepo.findById(foodId).orElseThrow(() -> new ResourceNotFoundException("addOn", "Add On Repository", foodId));
		addOnRepo.delete(addOn);
		FoodDto dto = mapper.map(addOn.getFood() ,FoodDto.class);
		return ResponseEntity.ok(dto);
	}



	@Override
	public ResponseEntity<FoodDto> getFoodItemById(Integer id) {
		Food food = foodRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "Food repo", id));
		FoodDto foodDto = mapper.map(food,FoodDto.class);
		return ResponseEntity.ok(foodDto);
	}

}
