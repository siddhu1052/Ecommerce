package com.enterprise.order_services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUserDTO {
    private Long user_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private Integer country_code;
    private String mobile_no;
    private boolean seller;
    private String address;
}