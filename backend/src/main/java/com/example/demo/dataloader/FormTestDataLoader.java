package com.example.demo.dataloader;

import com.example.demo.entity.FormData;
import com.example.demo.repository.FormDataRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FormTestDataLoader implements ApplicationRunner {
    @Autowired
    private FormDataRepo formRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FormData newForm = new FormData();
        newForm.setFirstName("Kritsada");
        newForm.setLastName("Patchima");
        newForm.setAge(23);
        newForm.setJob("ว่างงาน");
        formRepo.save(newForm);
    }
}
