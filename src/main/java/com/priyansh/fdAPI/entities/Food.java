package com.priyansh.fdAPI.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String imagePath;
	
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private FoodCategory category;
	
	@OneToMany(mappedBy = "food",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<AddOns> availableAddOns = new ArrayList<>();
}
