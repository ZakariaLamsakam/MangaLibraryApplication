package com.example.mangalibraryapp.service.impl;

import com.example.mangalibraryapp.entity.User;
import com.example.mangalibraryapp.repository.UserRepository;
import com.example.mangalibraryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }
}
