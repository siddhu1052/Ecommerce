package com.enterprise.order_services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.order_services.model.Cart;
import com.enterprise.order_services.service.OrderService;

@RestController
@RequestMapping("order")
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("placeorder")
    public String placeOrder(@RequestParam Long productId, @RequestParam Integer quantity){
        return orderService.placeOrder(productId,quantity);
        // return "reached controller";
    }

    @PostMapping("proceedtobuy")
    public String proceedToBuy(@RequestBody Cart cart){
        return orderService.proceedToBuy(cart);
    }

    @PostMapping("cancellorder")
    public String cancellOrder(@RequestParam Long orderId){
        return orderService.cancellOrder(orderId);
    }

    @GetMapping("orders")
    public String orders(@RequestParam Long userId){
        return "Sent all orders";
    }

    @PostMapping("editLocation")
    public String editLocation(@RequestParam Long orderId){
        return "address changed";
    }

    @PostMapping("editreciever")
    public String editReciever(@RequestParam Long orderId, @RequestParam String phone, @RequestParam String name){
        return "phone changed";
    }
}
