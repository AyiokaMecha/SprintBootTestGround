package com.danmecha.dependencyInjection.postgresql.services;

import com.danmecha.dependencyInjection.postgresql.repository.School;
import com.danmecha.dependencyInjection.postgresql.repository.Student;
import com.danmecha.dependencyInjection.postgresql.repository.StudentDto;
import com.danmecha.dependencyInjection.postgresql.repository.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {
        Student student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        School school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponse(Student student) {
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
