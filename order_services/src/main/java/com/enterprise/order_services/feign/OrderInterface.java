package com.enterprise.order_services.feign;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.order_services.model.Product;

@FeignClient("PRODUCT-SERVICES")
public interface OrderInterface {
    @GetMapping("product/showAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() ;

    @GetMapping("product/availableProducts")
    public ResponseEntity<List<Product>> availableProducts();

    @PostMapping("product/addProduct")
    public String addProduct(@RequestBody Product product);

    @GetMapping("product/getProductById")
    public Optional<Product> getProductById(@RequestParam Long id) ;

    @PostMapping("product/deleteSome")
    public String deleteSome(@RequestParam Long id, @RequestParam Integer num);

    @PostMapping("product/increaseSome")
    public String addOne(@RequestParam Long id, @RequestParam Integer num) ;

    @PostMapping("product/deleteProduct")
    public String deleteProduct(@RequestParam Long id) ;
}
