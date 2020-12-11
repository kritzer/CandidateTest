package com.example.demo.entity;

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
public class FormData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Form_SEQ")
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private int age;

    @NotNull
    private String job;
}
