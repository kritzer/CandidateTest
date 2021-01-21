package com.example.demo.repository;

import com.example.demo.entity.FormData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FormDataRepo extends JpaRepository<FormData, Long> {

    @Query(value = "SELECT z FROM FormData z Where z.firstName = :text or z.lastName = :text or z.age = :text or z.job = :text")
    List<FormData> findByText(@Param("text") String text);

    @Query(value = "SELECT z FROM FormData z Where z.age <= :age")
    List<FormData> findByAgeOrderByAge(@Param("age") String age);

    List<FormData> findByFirstNameContaining(@Param("firstName") String firstName);
}