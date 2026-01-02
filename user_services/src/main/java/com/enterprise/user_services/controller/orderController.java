package com.enterprise.user_services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.user_services.service.SellerService;
import com.enterprise.user_services.service.UserServices;

import jakarta.ws.rs.core.Response;

// import jakarta.ws.rs.core.Response;

import com.enterprise.user_services.DTO.ApplicationUserDTO;
import com.enterprise.user_services.model.ApplicationSellers;
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

    @Autowired
    SellerService sellerService;

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return "User Servies is Up and Responding";
    }
    

    @GetMapping("userdetails")
    public ResponseEntity<ApplicationUserDTO> userDetails(@RequestParam Long id) {
        return ResponseEntity.ok(userServices.getDetails(id));
    }
    @GetMapping("sellerDetails")
    public ResponseEntity<ApplicationSellers> sellerDetails(@RequestParam Long id) {
        return ResponseEntity.ok(sellerService.getDetails(id));
    }
    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody ApplicationUser user) {
        System.out.println(user);
        return ResponseEntity.ok(userServices.addUser(user));
    }
    @PostMapping("addSeller")
    public ResponseEntity<String> addSeller(@RequestBody ApplicationSellers user) {
        return ResponseEntity.ok(userServices.addUser(user));
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<ApplicationUserDTO>> getAllUsers() {
        // return ResponseEntity.ok(userServices.getAllUsers());
        List <ApplicationUserDTO> users = userServices.getAllUsers();
        System.out.println(users);
        return ResponseEntity.ok(users);
    }

    @GetMapping("getAllSellers")
    public ResponseEntity<List<ApplicationSellers>> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }

    @GetMapping("AllCustomers")
    public ResponseEntity<List<ApplicationUserDTO>> GetAllCustomers() {
        return ResponseEntity.ok(userServices.getAllCustomers());
    }
    
    @PostMapping("deleteUserByAdmin")
    public String postMethodName( @RequestParam Long id, @RequestParam boolean seller) {
        if(!seller){
            userServices.deleteUserByAdmin(id);
        }else{
            sellerService.deleteSellerByAdmin(id);
        }
        return "Deleted successfully";
    }
    
    
    
    
}
