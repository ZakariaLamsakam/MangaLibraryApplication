package com.example.mangalibraryapp.service.impl;

import com.example.mangalibraryapp.entity.User;
import com.example.mangalibraryapp.exception.UserNotFoundException;
import com.example.mangalibraryapp.repository.UserRepository;
import com.example.mangalibraryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return repo.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }

    public User get(Long id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID" + id);
    }
}
