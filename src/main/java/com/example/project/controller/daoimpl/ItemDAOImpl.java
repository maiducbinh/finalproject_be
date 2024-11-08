package com.example.project.controller.daoimpl;

import com.example.project.controller.dao.ItemDAO;
import com.example.project.model.Item;
import com.example.project.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsByType(String type) {
        switch (type.toLowerCase()) {
            case "shoes":
                return itemRepository.findAllShoes();
            case "clothes":
                return itemRepository.findAllClothes();
            case "laptop":
                return itemRepository.findAllLaptops();
            default:
                return List.of();
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}

