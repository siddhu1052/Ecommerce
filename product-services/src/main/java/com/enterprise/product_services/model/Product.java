package com.enterprise.product_services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;

    private String art;
    private String artStyle;
    private Boolean isHandmade;
    private Integer size; //optional
    private Integer height; //optional
    private Integer width; //optional

    @Lob
    private byte[] image;  //optional
}
