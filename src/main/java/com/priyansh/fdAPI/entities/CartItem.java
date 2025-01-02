package com.priyansh.fdAPI.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Food food;

    @ManyToMany
    @JoinTable(
        name = "cart_item_addons",
        joinColumns = @JoinColumn(name = "cart_item_id"),
        inverseJoinColumns = @JoinColumn(name = "addon_id")
    )
    private List<AddOns> selectedAddOns = new ArrayList<>();

    private Integer quantity;
}
