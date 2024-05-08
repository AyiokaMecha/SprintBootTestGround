package com.danmecha.dependencyInjection.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //generating interface methods for use by the other classes
    //take note that the columnNames for the method are the JAVA class name not the database names
    List<Student> findAllByFirstnameContaining(String b);
}
