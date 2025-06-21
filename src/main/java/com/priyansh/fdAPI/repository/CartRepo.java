package com.priyansh.fdAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.priyansh.fdAPI.entities.AddOns;
import com.priyansh.fdAPI.entities.CartItem;
import com.priyansh.fdAPI.entities.Food;
import com.priyansh.fdAPI.entities.User;

import jakarta.transaction.Transactional;

public interface CartRepo extends JpaRepository<CartItem,Integer> {
	
//	// Custom query to select all CartItems for a specific user ,food and addons
//	@Query("SELECT c FROM CartItem c " +
//		       "WHERE c.user = :user " +
//		       "AND c.food = :food " +
//		       "AND SIZE(c.selectedAddOns) = :addOnsSize " +
//		       "AND EXISTS (SELECT a FROM c.selectedAddOns a WHERE a.id IN :addOnsIds)"
//		       )
//		Optional<CartItem> findCartItemByUserAndFoodAndAddOns(
//		    @Param("user") User user,
//		    @Param("food") Food food,
//		    @Param("addOnsIds") List<Integer> addOnsIds,
//		    @Param("addOnsSize") int addOnsSize
//		);

		
	
	//Query to get cartItem belonging to certain food and user
	CartItem findByFoodAndUser(Food food,User user);

	//Custom query to delete cartItem by its id
	@Modifying
	@Query("DELETE FROM CartItem c WHERE c.id = :id")
	void deleteById(@Param("id") Integer id);

	
	// Custom query to delete all CartItems for a specific User 
    @Modifying				//Used to indicate that the query modifies the database
    @Transactional			//Required because modifying queries need to be executed within a transaction.
    @Query("DELETE FROM CartItem c WHERE c.user = :user")
    void deleteByUser(User user);
    
    
    List<CartItem> findByUser(User user);
    
    }
