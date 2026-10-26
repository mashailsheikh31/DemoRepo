package com.example.ExpenseTracker.controller;


import com.example.ExpenseTracker.model.LoginRequest;
import com.example.ExpenseTracker.model.User;
import com.example.ExpenseTracker.repo.UserRepo;
import com.example.ExpenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user){
    userService.registerUser(user);
    return "Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        String token = userService.verify(loginRequest); // ye token return karega
        if (token.equals("fail")) {
            return "Invalid email or password";
        }
        return token;
    }
    @GetMapping("/register")
    public List<User> getAllUsers(){
       return userRepo.findAll();

    }

    @GetMapping
    public String greet(){
        return "welcome to delusional world";
    }
}
