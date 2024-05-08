package com.danmecha.dependencyInjection.postgresql.controller;

import com.danmecha.dependencyInjection.postgresql.repository.School;
import com.danmecha.dependencyInjection.postgresql.repository.SchoolDto;
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

    private School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }

    private SchoolDto toSchoolDto(School school) {
        SchoolDto dto = new SchoolDto(
                school.getName()
        );
        return dto;
    }

    @GetMapping
    public SchoolDto getSchool(Integer id) {
        School school;
        if (schoolRepository.findById(id).isPresent()) {
            school = schoolRepository.findById(id).get();
        } else {
            school = new School();
        }
        return toSchoolDto(school);
    }



    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ) {
        School school = toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    @GetMapping
    public List<SchoolDto> getSchools() {
        return schoolRepository.findAll().stream().map(
                school -> toSchoolDto(school)
        ).toList();
    }




}
