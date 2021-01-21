package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.entity.FormData;
import com.example.demo.repository.FormDataRepo;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class FormDataTest {

    private Validator validator;

    @Autowired
    private FormDataRepo formDataRepo;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void formDataTestMustBeOk(){
        FormData formData = new FormData();

        formData.setAge("23");
        formData.setFirstName("Kritsada");
        formData.setLastName("Patchima");
        formData.setJob("Student");

        formData  = formDataRepo.saveAndFlush(formData);

        Optional<FormData> found = formDataRepo.findById(formData.getId());
        assertEquals("23",found.get().getAge());
        assertEquals("Kritsada",found.get().getFirstName());
        assertEquals("Patchima",found.get().getLastName());
        assertEquals("Student",found.get().getJob());
    }
    
}
