package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "clothes")
@NoArgsConstructor // Tạo constructor không tham số
@AllArgsConstructor // Tạo constructor có tất cả các tham số
public class Clothes extends Item {
    private String size;
    private String material;

    // Constructor đầy đủ
    public Clothes(Long id, String name, Double price, String description, String type, String size, String material) {
        super(id, name, price, description, type);
        this.size = size;
        this.material = material;
    }
}

