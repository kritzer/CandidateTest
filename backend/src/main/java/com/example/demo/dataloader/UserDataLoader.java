package com.example.demo.dataloader;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements ApplicationRunner {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(ApplicationArguments args)throws Exception{
        User newUser = new User();
        newUser.setEmail("ascend@true.com");
        newUser.setUsername("ascend");
        newUser.setPassword("password");
        userRepo.save(newUser);
    }
}
