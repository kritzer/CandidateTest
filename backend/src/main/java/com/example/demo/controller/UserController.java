package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    @GetMapping("/login")
    public List<User> getCheck(@RequestBody Map<String, String> body){
        return userRepo.findCheck(body.get("username").toString(),body.get("password").toString());
    }
}
