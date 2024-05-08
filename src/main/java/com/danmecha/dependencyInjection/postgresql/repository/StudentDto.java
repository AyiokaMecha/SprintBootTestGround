package com.danmecha.dependencyInjection.postgresql.repository;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {

}
