package com.example.project.service;

import com.example.project.model.Item;

import java.util.List;

public interface ItemService {
    Item saveItem(Item item);
    Item getItemById(Long id);
    List<Item> getAllItems();
    List<Item> getItemsByType(String type);
    void deleteItem(Long id);
}

