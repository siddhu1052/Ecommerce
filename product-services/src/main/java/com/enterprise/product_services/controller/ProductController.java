package com.enterprise.product_services.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.product_services.Service.ProductService;
import com.enterprise.product_services.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("showAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("All products");
        return productService.getAllProducts();
    }
    @GetMapping("availableProducts")
    public ResponseEntity<List<Product>> availableProducts() {
        System.out.println("All products");
        return productService.availableProducts();
    }
    

    @PostMapping("addProduct")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("getProductById")
    public Optional<Product> getProductById(@RequestParam Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("deleteSome")
    public String deleteSome(@RequestParam Long id, @RequestParam Integer num) {
        System.out.println("quantity of product decreased by one");
        return productService.deleteSome(id,num);
    }

    @PostMapping("increaseSome")
    public String addOne(@RequestParam Long id, @RequestParam Integer num) {
        return productService.addSome(id,num);
    }

    @PostMapping("deleteProduct")
    public String deleteProduct(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }

}
