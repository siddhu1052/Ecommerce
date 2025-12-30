package com.enterprise.user_services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.user_services.DTO.ApplicationUserDTO;
import com.enterprise.user_services.model.ApplicationUser;
import com.enterprise.user_services.repository.UserServiceRepository;


@Service
public class UserServices {

    @Autowired
    UserServiceRepository userRepo;

    public String getDetails(String id, Integer type) {
        switch (type) {
            case 1:
                System.out.println("Customer");

                break;
            case 2:
                System.out.println("Seller");
                break;
            default:
                break;
        }
        return "In User Detail service"+type;
    }

    public String addUser(ApplicationUser user){
        System.out.println(user);
        System.out.println(userRepo.save(user));
        return "User added";
    }

    public List<ApplicationUserDTO> getAllUsers(){
        
        List<ApplicationUserDTO> users= userRepo.findAllUsersAsDTO();
        return users;
    }

    public List<ApplicationUserDTO> getAllCustomers() {
        List<ApplicationUserDTO> users= userRepo.findAllUsersAsDTOCustomers();
        return users;
    }

    public String deleteUserByAdmin(Long id){
        userRepo.deleteById(id);
        return "Seller deleted by Admin";
    }
}
