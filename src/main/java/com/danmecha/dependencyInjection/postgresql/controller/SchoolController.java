package com.danmecha.dependencyInjection.postgresql.controller;

import com.danmecha.dependencyInjection.postgresql.repository.School;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    private final SchoolRepository schoolRepository;



    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ) {
        return schoolRepository.save(school);
    }

    @GetMapping
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }




}
