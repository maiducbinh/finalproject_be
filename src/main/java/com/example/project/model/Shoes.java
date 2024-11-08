package com.example.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "shoes")
@NoArgsConstructor // Tạo constructor không tham số
@AllArgsConstructor // Tạo constructor có tất cả các tham số
public class Shoes extends Item {
    private String size;
    private String color;

    public Shoes(Long id, String name, Double price, String description, String type, String size, String color) {
        super(id, name, price, description, type);
        this.size = size;
        this.color = color;
    }
}
