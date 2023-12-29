package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.CourseEntity;
import com.springstarter.springstarterweb.entity.CourseMaterialEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        CourseEntity someCourse = CourseEntity.builder()
                .tile("Some course")
                .credit(12)
                .build();
//        courseRepository.save(someCourse);
        CourseMaterialEntity courseMaterial = CourseMaterialEntity.builder()
                .url("math-101")
                .course(someCourse)
                .build();
        CourseMaterialEntity save1 = courseMaterialRepository.save(courseMaterial);
        System.out.println("Saved course material is"+save1);
    }

    @Test
    public void findAllCourse() {
        List<CourseEntity> allCourse = courseRepository.findAll();
        System.out.println("Found all courses"+allCourse);
        allCourse.forEach(course -> System.out.println(course.getCourseMaterial()));
    }
}