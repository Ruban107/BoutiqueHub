package com.boutique.boutiquehub.serviceimpl;

import com.boutique.boutiquehub.entity.Order;
import com.boutique.boutiquehub.entity.Status;
import com.boutique.boutiquehub.repository.OrderRepository;
import com.boutique.boutiquehub.repository.UserRepository;
import com.boutique.boutiquehub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Order placeOrder(Order order){
        return orderRepository.save(order);
    }
    @Override
    public List<Order> getUserOrders(long userId){
        return orderRepository.findByUserId(userId);
    }
    @Override
    public Order updateOrderStatus(long orderId,String status){
        Order existing=orderRepository.findById(orderId).orElse(null);
        if(existing!=null){
            existing.setStatus(Status.valueOf(status));
        }
        return orderRepository.save(existing) ;
    }
    @Override
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
}
