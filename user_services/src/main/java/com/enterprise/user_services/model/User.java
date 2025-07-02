package com.enterprise.user_services.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    @Id
    private String userId;

    private String email;
    private Integer countryCode;
    private String mobileNo;
}
