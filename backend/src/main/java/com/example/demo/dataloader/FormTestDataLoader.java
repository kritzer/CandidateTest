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
        newForm.setAge("23");
        newForm.setJob("ว่างงาน");
        formRepo.save(newForm);

        FormData newForm2 = new FormData();
        newForm2.setFirstName("Asahina");
        newForm2.setLastName("Patchima");
        newForm2.setAge("12");
        newForm2.setJob("Maid");
        formRepo.save(newForm2);

        FormData newForm3 = new FormData();
        newForm3.setFirstName("xMen");
        newForm3.setLastName("YGirl");
        newForm3.setAge("19");
        newForm3.setJob("Student");
        formRepo.save(newForm3);
    }
}
