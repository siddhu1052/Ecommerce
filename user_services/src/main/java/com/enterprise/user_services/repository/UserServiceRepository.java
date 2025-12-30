package com.enterprise.user_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.user_services.model.ApplicationUser;

@Repository
public interface UserServiceRepository extends JpaRepository<ApplicationUser,Long>{
    
}
