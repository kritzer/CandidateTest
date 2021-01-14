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
    void kritzer_FormDataTestMustBeOk(){
        FormData formData = new FormData();

        formData.setAge(23);
        formData.setFirstName("Kritsada");
        formData.setLastName("Patchima");
        formData.setJob("Student");

        formData  = formDataRepo.saveAndFlush(formData);

        Optional<FormData> found = formDataRepo.findById(formData.getId());
        assertEquals(23,found.get().getAge());
        assertEquals("Kritsada",found.get().getFirstName());
        assertEquals("Patchima",found.get().getLastName());
        assertEquals("Student",found.get().getJob());
    }

    @Test
    void kritzer_FirstNameMustNotBeNull(){
        FormData formData = new FormData();
        formData.setAge(23);
        formData.setFirstName(null);
        formData.setLastName("Patchima");
        formData.setJob("Student");

        Set<ConstraintViolation<FormData>> result = validator.validate(formData);
        
        assertEquals(1, result.size());

        ConstraintViolation<FormData> v = result.iterator().next();
        assertEquals("FirstName Must not be null", v.getMessage());
        assertEquals("firstName", v.getPropertyPath().toString());
  
    }

    @Test
    void kritzer_LastNameMustNotBeNull(){
        FormData formData = new FormData();
        formData.setAge(23);
        formData.setFirstName("Kritsada");
        formData.setLastName(null);
        formData.setJob("Student");

        Set<ConstraintViolation<FormData>> result = validator.validate(formData);
        
        assertEquals(1, result.size());

        ConstraintViolation<FormData> v = result.iterator().next();
        assertEquals("LastName Must not be null", v.getMessage());
        assertEquals("lastName", v.getPropertyPath().toString());
  
    }

    @Test
    void kritzer_JobMustNotBeNull(){
        FormData formData = new FormData();
        formData.setAge(23);
        formData.setFirstName("Kritsada");
        formData.setLastName("Patchima");
        formData.setJob(null);

        Set<ConstraintViolation<FormData>> result = validator.validate(formData);
        
        assertEquals(1, result.size());

        ConstraintViolation<FormData> v = result.iterator().next();
        assertEquals("Job Must not be null", v.getMessage());
        assertEquals("job", v.getPropertyPath().toString());
  
    }
    
}
