package com.danmecha.dependencyInjection.postgresql.controller;

import com.danmecha.dependencyInjection.postgresql.repository.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
