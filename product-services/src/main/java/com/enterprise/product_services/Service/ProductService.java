package com.enterprise.product_services.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enterprise.product_services.DAO.ProductDAO;
import com.enterprise.product_services.model.Product;

@Service

public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public ResponseEntity<List<Product>> getAllProducts() {
        // return new ResponseEntity<>(new ArrayList<Product>(),HttpStatus.OK);
        System.out.println("InService");
        return ResponseEntity.ok(productDAO.findAll());
    }

    public ResponseEntity<List<Product>> availableProducts() {
        // return new ResponseEntity<>(new ArrayList<Product>(),HttpStatus.OK);
        System.out.println("InService");
        return ResponseEntity.ok(productDAO.productsAvailable());
    }

    public String addProduct(Product product) {
        System.out.println("In add Prodect service");
        productDAO.save(product);
        return "done";
    }

    public Optional<Product> getProductById(Long Id) {
        System.out.println("In GetProductById service");
        return productDAO.findById(Id);
    }

    public String deleteSome(Long Id, Integer num) {
        System.out.println("In deleteOne");
        int result = productDAO.decreaseSome(Id, num);
        if (result != 0) {
            return "decreased";
        }
        return "not decreased";
    }

    public String addSome(Long id, Integer num) {
        productDAO.addSome(id, num);
        return "Added";
    }
    public String deleteProduct(Long id) {
        Optional<Product> product = getProductById(id);

        if (product.isPresent()) {
            productDAO.delete(product.get()); // delete the Product entity
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }

}
