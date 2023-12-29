package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.CourseEntity;
import com.springstarter.springstarterweb.entity.TeacherEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveTeacher() {
        CourseEntity someCourse =  CourseEntity
                .builder()
                .tile("Some course with teacher 1")
                .credit(12)
                .build();
        CourseEntity someCourse2 = CourseEntity
                .builder()
                .tile("Some course with teacher 2")
                .credit(20)
                .build();
        TeacherEntity teacher = TeacherEntity
                .builder()
                .firstName("teacher1")
                .lastName("blabla")
                .courses(List.of(someCourse2, someCourse))
                .build();
        teacherRepository.save(teacher);
    }

    @Test
    public void saveCouseWithTeacher() {
        TeacherEntity teacher = TeacherEntity
                .builder()
                .firstName("teacher1")
                .lastName("blabla")
                .build();

        CourseEntity someCourse =  CourseEntity
                .builder()
                .tile("Some course with teacher 1")
                .credit(12)
                .teacher(teacher)
                .build();
        courseRepository.save(someCourse);
    }

}