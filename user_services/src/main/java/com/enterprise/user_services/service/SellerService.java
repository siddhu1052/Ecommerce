package com.enterprise.user_services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.user_services.model.ApplicationSellers;
import com.enterprise.user_services.repository.Sellerrepo;

@Service
public class SellerService {
    @Autowired
    Sellerrepo repo;

    String addSeller(ApplicationSellers seller) {
        repo.save(seller);
        return "Seller added";
    }

    public List<ApplicationSellers> getAllSellers() {
        return repo.findAll();
    }

    public String deleteSellerByAdmin(Long id){
        repo.deleteById(id);
        return "Seller deleted by Admin";
    }
}
