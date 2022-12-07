package com.example.mangalibraryapp.controller;

import com.example.mangalibraryapp.entity.User;
import com.example.mangalibraryapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }
}
