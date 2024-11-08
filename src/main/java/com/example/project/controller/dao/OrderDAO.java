package com.example.project.controller.dao;

import com.example.project.model.Order;

import java.util.List;

public interface OrderDAO {
    Order saveOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
}

