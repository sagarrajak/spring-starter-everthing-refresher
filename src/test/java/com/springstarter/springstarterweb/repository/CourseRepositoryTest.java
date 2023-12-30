package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.CourseEntity;
import com.springstarter.springstarterweb.entity.Guardian;
import com.springstarter.springstarterweb.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    public CourseRepository courseRepository;
    @Test
    public void saveCourseWithStudent() {
        CourseEntity dsa = CourseEntity.builder().tile("DSA").credit(12).build();
        Guardian gurdian = Guardian.builder().mobile("1223232").name("some name").email("Someemail@gmail.com").build();
        StudentEntity student = StudentEntity.builder().guardian(gurdian).firstName("Sagar").lastName("rajak").emailId("shitfuck@gmail.com").build();
        dsa.setStudents(List.of(student));
        courseRepository.save(dsa);
    }

    @Test
    public void findAllCourseWithStudents() {
        List<CourseEntity> byStudentsNotNull = courseRepository.findByStudentsNotNull();
        System.out.println(byStudentsNotNull);
    }
}

