package com.enterprise.user_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.user_services.model.ApplicationSellers;

public interface Sellerrepo extends JpaRepository<ApplicationSellers, Long> {
    void deleteById(Long id);
}
