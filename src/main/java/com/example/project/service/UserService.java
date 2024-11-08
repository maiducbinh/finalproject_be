package com.example.project.service;

import com.example.project.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
    List<User> getAllUsers();
}
