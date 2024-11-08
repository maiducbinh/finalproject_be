package com.example.project.serviceimpl;

import com.example.project.controller.dao.ItemDAO;
import com.example.project.model.Item;
import com.example.project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public Item saveItem(Item item) {
        return itemDAO.saveItem(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemDAO.getItemById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    @Override
    public List<Item> getItemsByType(String type) {
        return itemDAO.getItemsByType(type);
    }

    @Override
    public void deleteItem(Long id) {
        itemDAO.deleteItem(id);
    }

}
