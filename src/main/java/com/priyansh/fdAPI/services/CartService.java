package com.priyansh.fdAPI.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.priyansh.fdAPI.payloads.AddOnDto;
import com.priyansh.fdAPI.payloads.CartItemDto;
import com.priyansh.fdAPI.payloads.FoodDto;

public interface CartService {
	
	public ResponseEntity<CartItemDto> addCartItem(Integer userId,FoodDto foodDto,List<AddOnDto> selectedAddOnDtos); 
	public ResponseEntity<Void> clearCartItem(Integer userId);
	public ResponseEntity<List<CartItemDto>> getAllCartItem(Integer userId);
	public ResponseEntity<Void> decrementCartItem(Integer userId,Integer foodId);
	public ResponseEntity<Void> deletetCartItem(Integer cartItemId);
}
