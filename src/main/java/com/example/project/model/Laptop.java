package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "laptops")
@NoArgsConstructor // Tạo constructor không tham số
@AllArgsConstructor // Tạo constructor có tất cả các tham số
public class Laptop extends Item {
    private String processor;
    private String ram;
    private String storage;

    // Constructor đầy đủ
    public Laptop(Long id, String name, Double price, String description, String type, String processor, String ram, String storage) {
        super(id, name, price, description, type);
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }
}

