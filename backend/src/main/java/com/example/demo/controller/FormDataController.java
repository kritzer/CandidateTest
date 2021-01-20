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
    public List<FormData> getAllFormDatas() {
        return formRepo.findAll();
    }

    @GetMapping("/search")
    public List<FormData> getByLastNameOrFirstName(@RequestParam(name = "text") String text) {
        return formRepo.findByText(text);
    }

    @GetMapping("/getByAge")
    public List<FormData> getByAge(@RequestParam(name = "age") String age) {
        List<FormData> sortedList = formRepo.findByAgeOrderByAge(age).stream()
                .sorted(Comparator.comparingInt(FormData::getAge))
                .collect(Collectors.toList());
        return  sortedList;
    }

    @GetMapping("/getByFirstName")
    public List<FormData> getByFirstNameLike(@RequestParam(name = "firstName") String firstName) {
        return formRepo.findByFirstNameContaining(firstName);
    }

    @PostMapping("/addFormData")
    public FormData addFormData(@RequestBody Map<String, String> body) {
        FormData newForm = new FormData();
        newForm.setFirstName(body.get("fname"));
        newForm.setLastName(body.get("lname"));
        newForm.setAge(body.get("age"));
        newForm.setJob(body.get("job"));
        return formRepo.save(newForm);
    }
}
