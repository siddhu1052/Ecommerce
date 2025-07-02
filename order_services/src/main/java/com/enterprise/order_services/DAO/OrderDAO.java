package com.enterprise.order_services.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.order_services.model.ChitraOrder;
// import com.enterprise.order_services.model.Order;

@Repository
public interface OrderDAO extends JpaRepository<ChitraOrder,Long>{
    
}
