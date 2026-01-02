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

    public ApplicationUserDTO getDetails(Long id) {
        return userRepo.getDetails(id);
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
