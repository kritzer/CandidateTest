package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Table(name = "FORM_DATA")
@Entity
@Data
@NoArgsConstructor
public class FormData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Form_SEQ")
    private Long id;

    @NotNull(message = "FirstName Must not be null")
    private String firstName;

    @NotNull(message = "LastName Must not be null")
    private String lastName;

    @NotNull(message = "Age Must Not Be Null")
    private String age;

    @NotNull(message = "Job Must not be null")
    private String job;

    public Integer getAge() {
        return Integer.parseInt(age);
    }
}
