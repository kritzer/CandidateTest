package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserTest {
 
    private Validator validator;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void kritzer_UserMustBeOk(){

        User user = new User();

        user.setEmail("EmailX@gmail.com");
        user.setUsername("username");
        user.setPassword("Xpassword");

        user  = userRepo.saveAndFlush(user);
        
        Optional<User> found = userRepo.findById(user.getId());
        assertEquals("EmailX@gmail.com",found.get().getEmail());
        assertEquals("username",found.get().getUsername());
        assertEquals("Xpassword",found.get().getPassword());

    }

    @Test
    void kritzer_EmailMustNotBeNull(){
        User user = new User();

        user.setEmail(null);
        user.setUsername("usernameX");
        user.setPassword("Xpassword");

        Set<ConstraintViolation<User>> result = validator.validate(user);
        
        assertEquals(1, result.size());

        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("Email Cannot Be null", v.getMessage());
        assertEquals("email", v.getPropertyPath().toString());
  
    }

    @Test
    void kritzer_UserNameMustNotBeNull(){
        User user = new User();

        user.setEmail("EmailX@gmail.com");
        user.setUsername(null);
        user.setPassword("Xpassword");

        Set<ConstraintViolation<User>> result = validator.validate(user);
        
        assertEquals(1, result.size());

        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("Username Cannot Be null", v.getMessage());
        assertEquals("username", v.getPropertyPath().toString());
  
    }
    
    @Test
    void kritzer_PasswordMustNotBeNull(){
        User user = new User();

        user.setEmail("EmailX@gmail.com");
        user.setUsername("username");
        user.setPassword(null);

        Set<ConstraintViolation<User>> result = validator.validate(user);
        
        assertEquals(1, result.size());

        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("Password Cannot Be null", v.getMessage());
        assertEquals("password", v.getPropertyPath().toString());
  
    }

}
