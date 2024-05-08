package com.danmecha.dependencyInjection;

import com.danmecha.dependencyInjection.data.Order;
import com.danmecha.dependencyInjection.data.OrderRecord;
import com.danmecha.dependencyInjection.postgresql.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

@RestController
public class FirstController {

    public final StudentRepository repo;

    private Student toStudent(StudentDto dto) {
        Student student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        School school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponse(Student student) {
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

    public FirstController(StudentRepository  repo) {
        this.repo = repo;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }


    @GetMapping("/hello/{lover-boy}")
    public String hello(@PathVariable("lover-boy") String userName) {
        return "Hello there " + userName;
    }

    @GetMapping("/echo/{message}")
    public String echoMessage(@PathVariable String message) {
        return "You sent: " + message;
    }

    @PostMapping("/uppercase")
    public String toUpperCase(@RequestBody String message) {
        return message.toUpperCase();
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ) {
        return "Request says: " + order.getCustomerName() + " " + order.getProductName();
    }

    @PostMapping("/post-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Request says: " + order.toString();
    }

    @PostMapping("/students")
    public String post(
            @RequestBody StudentDto student
    ) {
        Student student1 = toStudent(student);
        //send data to the db
        repo.save(student1);
        return "Request was acccepted and message is : " + student1.getFirstname() + " " + student1.getLastname();
    }


    //getting data from the database by id
    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id
    ){
        return repo.findById(id).orElse(new Student());
    }

    //get all the students
    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repo.findAll();
    }

    //get students from the Db by name
    @GetMapping("/students/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String studentName
    ) {
        //a function I have generated by myself for use
        return repo.findAllByFirstnameContaining(studentName);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        repo.deleteById(id);
    }
}
