package com.example.project.controller.dao;

import com.example.project.model.User;

import java.util.List;

public interface UserDAO {
    User saveUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}

