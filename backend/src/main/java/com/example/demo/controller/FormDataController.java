package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.FormData;
import com.example.demo.repository.FormDataRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormDataController {
    
    @Autowired
    private FormDataRepo formRepo;

    @GetMapping("/getAllForm")
    public List<FormData> getAllFormDatas(){
        return formRepo.findAll();
    }

    @PostMapping("/addFormData")
    public FormData addFormData(@RequestBody Map<String, String> body){
        FormData newForm = new FormData();
        newForm.setFirstName(body.get("fname").toString());
        newForm.setLastName(body.get("lname").toString());
        newForm.setAge(Integer.valueOf(body.get("age").toString()));
        newForm.setJob(body.get("job").toString());
        return formRepo.save(newForm);
    }
}
