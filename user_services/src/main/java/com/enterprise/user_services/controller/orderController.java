package com.enterprise.user_services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.user_services.service.UserServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("user")
public class orderController {
    @Autowired
    UserServices userServices;
    @GetMapping("userdetails")
    public String userDetails(@RequestParam String id, Integer type) {
        return userServices.getDetails(id,type);
    }
    
}
