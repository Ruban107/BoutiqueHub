package com.boutique.boutiquehub.controller;

import com.boutique.boutiquehub.entity.Order;
import com.boutique.boutiquehub.entity.Status;
import com.boutique.boutiquehub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @GetMapping("/{id}")
    public List<Order> getUserOrders(@PathVariable long userId){
        return orderService.getUserOrders(userId);
    }
    @PutMapping("/{id}")
    public Order updateOrderStatus(@PathVariable long orderId, @RequestBody Status status){
        return orderService.updateOrderStatus(orderId, String.valueOf(status));
    }

}
