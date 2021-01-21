package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Table
@Entity
@Data
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Email Cannot Be Null")
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "Username Cannot Be Null")
    private String username;
    
    @NotEmpty(message = "Password Cannot Be Null")
    private String password;

}
