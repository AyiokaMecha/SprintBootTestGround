package com.danmecha.dependencyInjection.postgresql.services;

import com.danmecha.dependencyInjection.postgresql.repository.Student;
import com.danmecha.dependencyInjection.postgresql.repository.StudentDto;
import com.danmecha.dependencyInjection.postgresql.repository.StudentRepository;
import com.danmecha.dependencyInjection.postgresql.repository.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public final StudentRepository repo;
    public final StudentMapper studentMapper;

    public StudentService(StudentRepository repo, StudentMapper studentMapper) {
        this.repo = repo;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto dto
    ) {
        Student student1 = studentMapper.toStudent(dto);
        //send data to the db
        repo.save(student1);
//        return "Request was acccepted and message is : " + student1.getFirstname() + " " + student1.getLastname();
        return studentMapper.toStudentResponse(student1);
    }

    public StudentResponseDto findStudentById(Integer id) {
        Student student;
        if(repo.findById(id).isPresent()) student = repo.findById(id).get();
        else student = new Student();

        StudentResponseDto dto = studentMapper.toStudentResponse(student);

        return dto;
    }

    public List<StudentResponseDto> findAllStudents() {
        List<Student> students = repo.findAll();
        return students.stream().map(this.studentMapper::toStudentResponse).toList();

    }
}
