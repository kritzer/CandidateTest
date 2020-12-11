package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long> {
    
    @Query(value = "SELECT * FROM User z Where z.email = :username or z.username = :username and z.password = :password", nativeQuery = true)
    List<User> findCheck(@Param("username") String username, @Param("password") String password);
}
