package com.example.project.serviceimpl;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.model.Order;
import com.example.project.repository.OrderRepository;
import com.example.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        order.setOrderTime(LocalDateTime.now());
        // Thêm logic kinh doanh nếu cần
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optOrder = orderRepository.findById(orderId);
        if(optOrder.isPresent()) {
            return optOrder.get();
        } else {
            throw new ResourceNotFoundException("Order not found with id " + orderId);
        }
    }
}
