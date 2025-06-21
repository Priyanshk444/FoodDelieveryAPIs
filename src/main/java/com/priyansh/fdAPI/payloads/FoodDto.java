package com.priyansh.fdAPI.payloads;

import java.util.ArrayList;
import java.util.List;

import com.priyansh.fdAPI.entities.AddOns;
import com.priyansh.fdAPI.entities.FoodCategory;
import lombok.Data;

@Data
public class FoodDto {

private Integer id;
	
	private String name;
	
	private String description;
	
	private String imagePath;
	
	private Double price;
	
	private FoodCategory category;
	
	List<AddOnDto> AddOns = new ArrayList<>();
}
