package com.enterprise.user_services.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("CUSTOMER")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    private String firstName;
    private String middleName;
    private String lastName;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderWrapper> orders;
}
