package com.enterprise.order_services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
// import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long id;

    private Long userId;
    private String name;
    private Integer price;
    private Integer quantity;
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;

    private String art;
    private String artStyle;
    private Boolean isHandmade;
    private Integer size;
    private Integer height;
    private Integer width;

    @Lob
    private byte[] image;
}
