package com.danmecha.dependencyInjection.postgresql.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity //make this class a so called entity that will be persisted
//changing the table name as seen in the database
@Table(name = "student")
public class Student {

    //for every entity there must be a primary key which is specified by the following annotation
    @Id
    @GeneratedValue//generate primary keys automatically
    private Integer id;

    //alter the column name as seen in the Db
    @Column(
            name = "fname",
            length = 20 //setting the string length limit
    )
    private String firstname;
    private String lastname;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    private School school;

    @Column(
            unique = true//constrain this column to be of unique values
    )
    private String email;
    private int age;
    //creating a column that shouldn't be updateable such as the dates
//    @Column(
//            updatable = false
//    )
//    private Date startDate;

    public Student() {
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
