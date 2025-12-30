package com.enterprise.user_services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.user_services.service.UserServices;

import com.enterprise.user_services.model.ApplicationUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("user")
public class orderController {
    @Autowired
    UserServices userServices;
    @GetMapping("userdetails")
    public String userDetails(@RequestParam String id, Integer type) {
        return userServices.getDetails(id,type);
    }
    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody ApplicationUser user) {
        System.out.println(user);
        return ResponseEntity.ok(userServices.addUser(user));
    }
    
    
}
