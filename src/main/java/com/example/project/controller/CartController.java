package com.example.project.controller;

import com.example.project.model.Cart;
import com.example.project.model.Item;
import com.example.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/add")
    public Cart addItemToCart(@RequestParam Long userId, @RequestBody Item item) {
        return cartService.addItemToCart(userId, item);
    }

    @PostMapping("/remove")
    public Cart removeItemFromCart(@RequestParam Long userId, @RequestBody Item item) {
        return cartService.removeItemFromCart(userId, item);
    }
}
