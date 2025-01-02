package com.priyansh.fdAPI.payloads;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CartItemDto {
	
	    private Integer cartId;
	    private FoodDto food;
	    private List<AddOnDto> selectedAddOns = new ArrayList<>();

	    private Integer quantity;
}
