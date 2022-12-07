package com.example.mangalibraryapp.controller;

import com.example.mangalibraryapp.entity.User;
import com.example.mangalibraryapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        service.saveUser(user);

        return "register_success";
    }

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("user", new User());
        return "home";
    }

   @GetMapping("/profile")
    public String ProfilePage(Model model){
       List<User> listUsers = service.getAllUsers();
       model.addAttribute("listUsers", listUsers);

       return "profile";
   }









}
