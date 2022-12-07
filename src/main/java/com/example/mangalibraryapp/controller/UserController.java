package com.example.mangalibraryapp.controller;

import com.example.mangalibraryapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        super();
        this.service = service;
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
}
