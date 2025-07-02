package com.enterprise.order_services.service;

import org.springframework.stereotype.Service;

@Service
public class CartServices {
    public String addToCart(Long productId){
        return "Added product to cart";
    }
    public String addQuantity(Long productId){
        return "quantity increased in service";
    }

    public String subtractQuantity( Long productId) {
        return "reduced quantity in service";
    }

    public String showAllProducts( Long userId) {
        return "all products";
    }
}
