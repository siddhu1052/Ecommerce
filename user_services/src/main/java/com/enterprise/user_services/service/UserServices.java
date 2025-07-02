package com.enterprise.user_services.service;

import org.springframework.stereotype.Service;

@Service
public class UserServices {

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
}
