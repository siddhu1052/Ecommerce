package com.enterprise.user_services.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ApplicationSellers extends ApplicationUser {
    String shopName;
    String helplineNumber;
    String helpMail;
    String shopAddress;
}
