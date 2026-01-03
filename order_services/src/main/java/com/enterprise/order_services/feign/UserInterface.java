package com.enterprise.order_services.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.order_services.DTO.ApplicationSellers;
import com.enterprise.order_services.DTO.ApplicationUser;
import com.enterprise.order_services.DTO.ApplicationUserDTO;

@FeignClient("USER-SERVICES")
public interface UserInterface {

    @GetMapping("user/userdetails")
    public ResponseEntity<ApplicationUserDTO> userDetails(@RequestParam Long id);
    @GetMapping("user/sellerDetails")
    public ResponseEntity<ApplicationSellers> sellerDetails(@RequestParam Long id);

    @PostMapping("user/addUser")
    public ResponseEntity<String> addUser(@RequestBody ApplicationUser user);
    
    @PostMapping("user/addSeller")
    public ResponseEntity<String> addSeller(@RequestBody ApplicationSellers user);

    @GetMapping("user/getAllUsers")
    public ResponseEntity<List<ApplicationUserDTO>> getAllUsers();

    @GetMapping("user/getAllSellers")
    public ResponseEntity<List<ApplicationSellers>> getAllSellers();

    @GetMapping("user/AllCustomers")
    public ResponseEntity<List<ApplicationUserDTO>> GetAllCustomers();
    
    @PostMapping("user/deleteUserByAdmin")
    public String postMethodName( @RequestParam Long id, @RequestParam boolean seller);
    
    
}
