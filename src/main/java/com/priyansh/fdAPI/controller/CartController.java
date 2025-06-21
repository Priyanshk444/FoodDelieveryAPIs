package com.priyansh.fdAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansh.fdAPI.entities.User;
import com.priyansh.fdAPI.exceptions.ResourceNotFoundException;
import com.priyansh.fdAPI.payloads.AddOnDto;
import com.priyansh.fdAPI.payloads.CartItemDto;
import com.priyansh.fdAPI.payloads.FoodDto;
import com.priyansh.fdAPI.services.CartService;
import com.priyansh.fdAPI.services.UserService;

@RestController
@CrossOrigin()
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private UserService userService;
    
 // Helper method to extract current userId from JWT
    private Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Usually email
        return userService.getUserIdByUsername(username);
    }
    
    // Endpoint to add an item to the cart
    @PostMapping
    public ResponseEntity<CartItemDto> addCartItem(
            @RequestBody FoodDto foodDto) {
    	Integer userId = getCurrentUserId();
        return cartService.addCartItem(userId, foodDto, foodDto.getAddOns());
    }

    // Endpoint to clear all items from the user's cart
    @DeleteMapping
    public ResponseEntity<Void> clearCartItem() {
    	Integer userId = getCurrentUserId();
        return cartService.clearCartItem(userId);
    }	

    // Endpoint to get all items in the user's cart \
    @GetMapping
    
    public ResponseEntity<List<CartItemDto>> getAllCartItem() {
    	Integer userId = getCurrentUserId();
        return cartService.getAllCartItem(userId);
    }

    // Endpoint to delete a specific item from the cart
    @DeleteMapping("/item/decrement/{foodId}")	
    public ResponseEntity<Void> decrementCartItem(@PathVariable Integer foodId) {
    	Integer userId = getCurrentUserId();
        return cartService.decrementCartItem(userId,foodId);
    }
    
    @DeleteMapping("/item/delete/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Integer cartItemId){
    	return cartService.deletetCartItem( cartItemId);
    }
}