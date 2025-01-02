package com.priyansh.fdAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansh.fdAPI.payloads.AddOnDto;
import com.priyansh.fdAPI.payloads.CartItemDto;
import com.priyansh.fdAPI.payloads.FoodDto;
import com.priyansh.fdAPI.services.CartService;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;

    // Endpoint to add an item to the cart
    @PostMapping("/{userId}")
    public ResponseEntity<CartItemDto> addCartItem(
            @PathVariable Integer userId,
            @RequestBody FoodDto foodDto) {
        return cartService.addCartItem(userId, foodDto, foodDto.getAddOns());
    }

    // Endpoint to clear all items from the user's cart
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clearCartItem(@PathVariable Integer userId) {
        return cartService.clearCartItem(userId);
    }

    // Endpoint to get all items in the user's cart
    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItemDto>> getAllCartItem(@PathVariable Integer userId) {
        return cartService.getAllCartItem(userId);
    }

    // Endpoint to delete a specific item from the cart
    @DeleteMapping("/item/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Integer cartItemId) {
        return cartService.deleteCartItem(cartItemId);
    }
}