package com.enterprise.user_services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductWrapper {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
