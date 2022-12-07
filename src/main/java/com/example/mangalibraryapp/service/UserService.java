package com.example.mangalibraryapp.service;

import com.example.mangalibraryapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    User updateUser(User user);

    void deleteUserById(Long id);
}
