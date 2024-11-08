package com.example.project.service;

import com.example.project.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
    Order getOrderById(Long orderId);
}
