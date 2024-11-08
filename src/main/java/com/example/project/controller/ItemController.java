package com.example.project.controller;

import com.example.project.model.Clothes;
import com.example.project.model.Item;
import com.example.project.model.Laptop;
import com.example.project.model.Shoes;
import com.example.project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{type}")
    public List<Item> getItemsByType(@PathVariable String type) {
        return itemService.getItemsByType(type);
    }

    @GetMapping("/detail/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/")
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            item.setName(itemDetails.getName());
            item.setPrice(itemDetails.getPrice());
            item.setDescription(itemDetails.getDescription());
            // Cập nhật các trường phụ thuộc vào loại Item
            if (item instanceof Shoes && itemDetails instanceof Shoes) {
                ((Shoes) item).setSize(((Shoes) itemDetails).getSize());
                ((Shoes) item).setColor(((Shoes) itemDetails).getColor());
            } else if (item instanceof Clothes && itemDetails instanceof Clothes) {
                ((Clothes) item).setSize(((Clothes) itemDetails).getSize());
                ((Clothes) item).setMaterial(((Clothes) itemDetails).getMaterial());
            } else if (item instanceof Laptop && itemDetails instanceof Laptop) {
                ((Laptop) item).setProcessor(((Laptop) itemDetails).getProcessor());
                ((Laptop) item).setRam(((Laptop) itemDetails).getRam());
                ((Laptop) item).setStorage(((Laptop) itemDetails).getStorage());
            }
            return itemService.saveItem(item);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

}
