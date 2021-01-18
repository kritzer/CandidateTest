package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    @GetMapping("/login")
    public User getCheck(@RequestParam(name = "username" ) String username,@RequestParam(name = "password") String password){
        return userRepo.findCheck(username, password);
    }
}
