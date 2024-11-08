package com.example.project;

import com.example.project.model.*;
import com.example.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoesRepository shoesRepository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        // Tạo Users
        User user1 = new User(null, "john_doe", "password123", "john@example.com");
        User user2 = new User(null, "jane_smith", "password456", "jane@example.com");
        userRepository.saveAll(Arrays.asList(user1, user2));

        // Tạo Items
        Shoes shoes1 = new Shoes(null, "Nike Air Max", 150.00, "Giày thể thao Nike Air Max", "shoes", "42", "Black");
        Shoes shoes2 = new Shoes(null, "Adidas Ultraboost", 180.00, "Giày chạy Adidas Ultraboost", "shoes", "40", "White");
        Clothes clothes1 = new Clothes(null, "Levi's Jeans", 60.00, "Quần jeans Levi's", "clothes", "M", "Denim");
        Laptop laptop1 = new Laptop(null, "Dell XPS 13", 1200.00, "Laptop Dell XPS 13", "laptop", "Intel i7", "16GB", "512GB SSD");
        itemRepository.saveAll(Arrays.asList(shoes1, shoes2, clothes1, laptop1));

        // Tạo Carts
        Cart cart1 = new Cart(null, user1.getId(), Arrays.asList(shoes1, clothes1));
        Cart cart2 = new Cart(null, user2.getId(), Arrays.asList(shoes2, laptop1));
        cartRepository.saveAll(Arrays.asList(cart1, cart2));

        // Tạo Orders
        Order order1 = new Order(null, LocalDateTime.of(2023, 8, 1, 10, 15, 30), "Credit Card", "Standard", false, user1.getId(), cart1);
        Order order2 = new Order(null, LocalDateTime.of(2023, 8, 5, 14, 20, 0), "PayPal", "Express", true, user2.getId(), cart2);
        orderRepository.saveAll(Arrays.asList(order1, order2));
    }
}
