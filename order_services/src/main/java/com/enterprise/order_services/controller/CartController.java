package com.enterprise.order_services.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.order_services.service.CartServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("cart")
public class CartController {

    CartServices cartSerevices;
    @PostMapping("addtocart")
    public String addToCart(@RequestParam Long productId) {
        
        return cartSerevices.addToCart(productId);
    }

    @PostMapping("addquantity")
    public String addQuantity(@RequestParam Long productId){
        return cartSerevices.addQuantity(productId);
    }

    @PostMapping("subtractquantity")
    public String subtractQuantity(@RequestParam Long productId) {
        return cartSerevices.subtractQuantity(productId);
    }

    @GetMapping("products")
    public String showAllProducts(@RequestParam Long userId) {
        return cartSerevices.showAllProducts(userId);
    }
    
    
}
