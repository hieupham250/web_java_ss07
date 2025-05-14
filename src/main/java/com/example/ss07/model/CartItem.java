package com.example.ss07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItem {
    private Product product;
    private int quantity;
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
