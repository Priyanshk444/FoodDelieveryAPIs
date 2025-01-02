package com.priyansh.fdAPI.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyansh.fdAPI.entities.AddOns;
import com.priyansh.fdAPI.entities.CartItem;
import com.priyansh.fdAPI.entities.Food;
import com.priyansh.fdAPI.entities.User;
import com.priyansh.fdAPI.exceptions.ResourceNotFoundException;
import com.priyansh.fdAPI.payloads.AddOnDto;
import com.priyansh.fdAPI.payloads.CartItemDto;
import com.priyansh.fdAPI.payloads.FoodDto;
import com.priyansh.fdAPI.repository.AddOnRepo;
import com.priyansh.fdAPI.repository.CartRepo;
import com.priyansh.fdAPI.repository.FoodRepo;
import com.priyansh.fdAPI.repository.UserRepo;
import com.priyansh.fdAPI.services.CartService;

import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private AddOnRepo addOnRepo;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public ResponseEntity<CartItemDto> addCartItem(Integer userId, FoodDto foodDto, List<AddOnDto> selectedAddOnDtos) {
        // Fetch user
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        // Fetch food
        Food food = foodRepo.findById(foodDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Food", "foodId", foodDto.getId()));

        // Fetch add-ons
        List<AddOns> selectedAddOns = (selectedAddOnDtos == null || selectedAddOnDtos.isEmpty()) 
            ? List.of() 
            : selectedAddOnDtos.stream()
                .map(addOnDto -> addOnRepo.findById(addOnDto.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("AddOn", "addonId", addOnDto.getId())))
                .collect(Collectors.toList());

        // Extract addOnIds and addOnsSize for query
        List<Integer> addOnsIds = selectedAddOns.stream()
                .map(AddOns::getId)
                .collect(Collectors.toList());
        int addOnsSize = selectedAddOns.size();

        // Check if the cart item already exists
        Optional<CartItem> existingCartItem = cartRepo.findCartItemByUserAndFoodAndAddOns(user, food, addOnsIds, addOnsSize);

        CartItem cartItem;
        if (existingCartItem.isPresent()) {
            cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setFood(food);
            cartItem.setSelectedAddOns(selectedAddOns);
            cartItem.setQuantity(1);
        }
        CartItem savedCartItem = cartRepo.save(cartItem);

        return ResponseEntity.ok(mapper.map(savedCartItem, CartItemDto.class));
    }

    @Override
    @Transactional
    public ResponseEntity<Void> clearCartItem(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        cartRepo.deleteByUser(user);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<CartItemDto>> getAllCartItem(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        List<CartItemDto> allItems = cartRepo.findByUser(user).stream()
                .map(cartItem -> mapper.map(cartItem, CartItemDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(allItems);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteCartItem(Integer cartItemId) {
        CartItem cartItem = cartRepo.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem", "cartItemId", cartItemId));
        if (cartItem.getQuantity() == 1) {
            System.out.println("only item in cart");
            cartRepo.deleteById(cartItemId);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
        }
        return ResponseEntity.ok(null);
    }

}
