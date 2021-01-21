package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.*;

@Table(name = "FORM_DATA")
@Entity
@Data
@NoArgsConstructor
public class FormData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Form_SEQ")
    private Long id;

    @Size(min = 2, max = 24)
    @NotEmpty(message = "FirstName Can Not be Null")
    private String firstName;

    @Size(min = 2, max = 24)
    @NotEmpty(message = "LastName Can Not Be Null")
    private String lastName;

    @NotEmpty(message = "Age Can Not Be Null")
    private String age;

    @Size(min = 2, max = 24)
    @NotEmpty(message = "Job Can Not Be Null")
    private String job;

    public Integer getAge() {
        return Integer.parseInt(age);
    }
}
