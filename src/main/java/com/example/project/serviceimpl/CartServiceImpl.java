package com.example.project.serviceimpl;

import com.example.project.controller.dao.CartDAO;
import com.example.project.controller.dao.ItemDAO;
import com.example.project.model.Cart;
import com.example.project.model.Item;
import com.example.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartDAO.getCartByUserId(userId);
    }

    @Override
    public Cart addItemToCart(Long userId, Item item) {
        Cart cart = cartDAO.getCartByUserId(userId);
        List<Item> items = cart.getItems();
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(itemDAO.getItemById(item.getId()));
        cart.setItems(items);
        return cartDAO.saveCart(cart);
    }

    @Override
    public Cart removeItemFromCart(Long userId, Item item) {
        Cart cart = cartDAO.getCartByUserId(userId);
        List<Item> items = cart.getItems();
        if (items != null) {
            items.removeIf(i -> i.getId().equals(item.getId()));
            cart.setItems(items);
            return cartDAO.saveCart(cart);
        }
        return cart;
    }
}
