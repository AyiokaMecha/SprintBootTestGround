package com.danmecha.dependencyInjection.postgresql.repository;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {
}
