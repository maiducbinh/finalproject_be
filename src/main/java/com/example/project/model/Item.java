package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "items")
@NoArgsConstructor // Tạo constructor không tham số
@AllArgsConstructor // Tạo constructor có tất cả các tham số
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;
    private String type; // Thêm cột 'type' để xác định loại Item
}

