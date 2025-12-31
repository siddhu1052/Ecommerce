package com.enterprise.user_services.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "application_user")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String password;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private Integer country_code;
    private String mobile_no;
    private boolean seller;
    private String address;
    @Override
    public String toString() {
        return "ApplicationUser [user_id=" + user_id + ", first_name=" + first_name + ", middle_name=" + middle_name
                + ", last_name=" + last_name + ", email=" + email + ", country_code=" + country_code + ", mobile_no="
                + mobile_no + ", seller=" + seller + ", address=" + address + "]";
    }
}
