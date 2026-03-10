package com.boutique.boutiquehub.service;

import com.boutique.boutiquehub.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);
    List<Order> getUserOrders(long userId);
    List<Order> getAllOrder();
    Order updateOrderStatus(long orderId,String status);

}
