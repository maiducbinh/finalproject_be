package com.example.project.service;

import com.example.project.model.*;

public interface CartService {
    Cart getCartByUserId(Long userId);
    Cart addItemToCart(Long userId, Item item);
    Cart removeItemFromCart(Long userId, Item item);
}

