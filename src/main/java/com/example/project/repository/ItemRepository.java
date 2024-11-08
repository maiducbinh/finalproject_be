package com.example.project.repository;

import com.example.project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT s FROM Shoes s")
    List<Item> findAllShoes();

    @Query("SELECT c FROM Clothes c")
    List<Item> findAllClothes();

    @Query("SELECT l FROM Laptop l")
    List<Item> findAllLaptops();
}
