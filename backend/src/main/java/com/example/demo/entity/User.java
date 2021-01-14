package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "Email Cannot Be null")
    private String email;

    @Column(unique = true)
    @NotNull(message = "Username Cannot Be null")
    private String username;
    
    @NotNull(message = "Password Cannot Be null")
    private String password;

}
