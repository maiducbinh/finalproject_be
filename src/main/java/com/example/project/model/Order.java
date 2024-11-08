package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderTime;
    private String paymentMethod;
    private String shippingMethod;
    private boolean isDelivered;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}