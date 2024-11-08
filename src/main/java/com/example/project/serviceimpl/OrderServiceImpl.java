package com.example.project.serviceimpl;
import com.example.project.controller.dao.OrderDAO;
import com.example.project.model.Order;
import com.example.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public Order saveOrder(Order order) {
        return orderDAO.saveOrder(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderDAO.getOrdersByUserId(userId);
    }
}
