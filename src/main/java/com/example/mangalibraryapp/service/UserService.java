package com.example.mangalibraryapp.service;

import com.example.mangalibraryapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);
}
