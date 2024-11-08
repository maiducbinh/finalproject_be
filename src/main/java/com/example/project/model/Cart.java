package com.example.project.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "carts")
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToMany
    @JoinTable(
            name = "cart_items",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    // Constructor đầy đủ bao gồm id, userId, items
    public Cart(Long id, Long userId, List<Item> items) {
        this.id = id;
        this.userId = userId;
        this.items = items;
    }

    // Optional: Constructor không cần id (id sẽ được tự động sinh)
    public Cart(Long userId, List<Item> items) {
        this.userId = userId;
        this.items = items;
    }
}
