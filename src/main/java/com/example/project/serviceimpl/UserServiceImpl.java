package com.example.project.serviceimpl;

import com.example.project.controller.dao.ItemDAO;
import com.example.project.controller.dao.UserDAO;
import com.example.project.model.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public User registerUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
