package com.example.demo.repository;

import com.example.demo.entity.FormData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FormDataRepo extends JpaRepository<FormData, Long>{
    
}
