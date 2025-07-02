package com.enterprise.order_services.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.order_services.DAO.OrderDAO;
import com.enterprise.order_services.feign.OrderInterface;
import com.enterprise.order_services.model.Cart;
import com.enterprise.order_services.model.ChitraOrder;
// import com.enterprise.order_services.model.Order;
import com.enterprise.order_services.model.Product;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderInterface orderInterface;

    private List<Long> convert(List<Product> products){
        List<Long> ids=new ArrayList<>();
        for(Product product:products){
            ids.add(product.getId());
        }
        return ids;
    }
    private Integer calculatePrice(Integer price ,Integer quantity){
        return price*quantity;
    }
    public String placeOrder(Long productId, Integer quantity) {
        List<Product> products = new ArrayList<>(List.of(orderInterface.getProductById(productId).get())) ;
        Integer total=0;
        for(Product product:products){
            total+=calculatePrice(product.getPrice(), product.getQuantity());
        }
        List<Long> productIds=convert(products);
        System.out.println(productIds);
        ChitraOrder chitraOrder=new ChitraOrder();

        chitraOrder.setOrderDate(LocalDate.now());
        chitraOrder.setProductIds(productIds);
        chitraOrder.setPrice(total);
        orderDAO.save(chitraOrder);
        return "Order placed successfully!";
    }

    
    public String proceedToBuy(Cart cart) {
        return "Ordered from cart";
    }

    public String cancellOrder(Long orderId) {
        return "order cancelled";
    }

    public String orders(Long userId) {
        return "All orders in service";
    }

}
