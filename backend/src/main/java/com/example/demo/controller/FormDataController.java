package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.entity.FormData;
import com.example.demo.repository.FormDataRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormDataController {

    @Autowired
    private FormDataRepo formRepo;

    @GetMapping("/getAllForm")
    public List<FormData> getAllFormData() {
        return formRepo.findAll();
    }

    @GetMapping("/search")
    public List<FormData> searchByText(@RequestParam(name = "text") String text) {
        return formRepo.findByText(text);
    }

    @GetMapping("/searchByAge")
    public List<FormData> searchByAge(@RequestParam(name = "age") String age) {
        return  formRepo.findByAgeOrderByAge(age).stream()
                .sorted(Comparator.comparingInt(FormData::getAge))
                .collect(Collectors.toList());
    }

    @GetMapping("/getByFirstName")
    public List<FormData> getByFirstNameLike(@RequestParam(name = "firstName") String firstName) {
        return formRepo.findByFirstNameContaining(firstName);
    }

    @PostMapping("/addFormData")
    public FormData addFormData(@RequestBody Map<String, String> body) {
        FormData newForm = new FormData();
        newForm.setFirstName(body.get("firstName"));
        newForm.setLastName(body.get("lastName"));
        newForm.setAge(body.get("age"));
        newForm.setJob(body.get("job"));
        return formRepo.save(newForm);
    }
}
