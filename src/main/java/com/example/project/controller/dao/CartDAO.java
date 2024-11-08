package com.example.project.controller.dao;

import com.example.project.model.Cart;

public interface CartDAO {
    Cart saveCart(Cart cart);
    Cart getCartByUserId(Long userId);
}
