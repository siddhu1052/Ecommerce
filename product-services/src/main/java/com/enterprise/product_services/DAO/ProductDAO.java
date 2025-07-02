package com.enterprise.product_services.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.product_services.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Product e SET e.quantity = e.quantity - :num WHERE e.id = :id and :num<=e.quantity")
    int decreaseSome(@Param("id") Long id, @Param("num") Integer num);

    @Modifying
    @Transactional
    @Query("UPDATE Product e SET e.quantity = e.quantity + :num WHERE e.id = :id")
    int addSome(@Param("id") Long id, @Param("num") Integer num);

    @Query("SELECT e FROM Product e WHERE e.quantity > 0")
    List<Product> productsAvailable();

}
