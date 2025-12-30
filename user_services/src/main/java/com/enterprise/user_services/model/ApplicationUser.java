package com.enterprise.user_services.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application_user")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(name = "first_name")
    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private Integer country_code;
    private String mobile_no;
    private boolean seller;
    private String address;

    String getuser_id() {
        return String.valueOf(user_id);
    }

    String getfirst_name() {
        return first_name;
    }

    String getmiddle_name() {
        return middle_name;
    }
    String getlast_name() {
        return last_name;
    }
    String getemail() {
        return email;
    }
    Integer getcountry_code() {
        return country_code;
    }
    String getmobile_no() {
        return mobile_no;
    }
    boolean getseller() {
        return seller;
    }
    String getaddress() {
        return address;
    }

    void setuser_id(Long user_id) {
        this.user_id = user_id;
    }
    void setfirst_name(String first_name) {
        this.first_name = first_name;
    }
    void setmiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }
    void setlast_name(String last_name) {
        this.last_name = last_name;
    }
    void setemail(String email) {
        this.email = email;
    }
    void setcountry_code(Integer country_code) {
        this.country_code = country_code;
    }
    void setmobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    void setseller(boolean seller) {
        this.seller = seller;
    }
    void setaddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "ApplicationUser [user_id=" + user_id + ", first_name=" + first_name + ", middle_name=" + middle_name
                + ", last_name=" + last_name + ", email=" + email + ", country_code=" + country_code + ", mobile_no="
                + mobile_no + ", seller=" + seller + ", address=" + address + "]";
    }
}
