package com.enterprise.user_services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enterprise.user_services.DTO.ApplicationUserDTO;
import com.enterprise.user_services.model.ApplicationUser;

@Repository
public interface UserServiceRepository extends JpaRepository<ApplicationUser,Long>{
@Query("""
        select new com.enterprise.user_services.DTO.ApplicationUserDTO(
            u.user_id,
            u.first_name,
            u.middle_name,
            u.last_name,
            u.email,
            u.country_code,
            u.mobile_no,
            u.seller,
            u.address
        )
        from ApplicationUser u
    """)
    List<ApplicationUserDTO> findAllUsersAsDTO();

@Query("""
        select new com.enterprise.user_services.DTO.ApplicationUserDTO(
            u.user_id,
            u.first_name,
            u.middle_name,
            u.last_name,
            u.email,
            u.country_code,
            u.mobile_no,
            u.seller,
            u.address
        )
        from ApplicationUser u where u.seller = false
    """)
    List<ApplicationUserDTO> findAllUsersAsDTOCustomers();

    void deleteById(Long id);
}
