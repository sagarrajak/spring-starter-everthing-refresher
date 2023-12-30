package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.CourseEntity;
import com.springstarter.springstarterweb.entity.CourseMaterialEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.print.attribute.standard.PageRanges;
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

    @Test()
    public void findAllPagination() {
        PageRequest firstPageWith3Request = PageRequest.of(0, 3);
        List<CourseEntity> content = courseRepository.findAll(firstPageWith3Request).getContent();
        long totalElements = courseRepository.findAll(firstPageWith3Request).getTotalElements();
        int totalPages = courseRepository.findAll(firstPageWith3Request).getTotalPages();
        System.out.println("Total elements "+totalElements);
        System.out.println("Total records "+content);
        System.out.println("Total pages: "+totalPages);
    }

    @Test
    public void findAllWithSorting() {
        PageRequest pageRequest = PageRequest.of(
                0,
                3,
                Sort.by("tile").ascending()
                        .and(
                                Sort.by("credit")
                                .descending()
                        )
        );

        Page<CourseEntity> pageRequestObject = courseRepository.findAll(pageRequest);
        int totalPages = pageRequestObject.getTotalPages();
        List<CourseEntity> content = pageRequestObject.getContent();
        long totalElements = pageRequestObject.getTotalElements();
        System.out.println("total elements :"+totalElements);
        System.out.println("content :"+content);
        System.out.println("total pages :"+totalPages);
    }

    @Test
    public void findByTitlePageable() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<CourseEntity> teacher = courseRepository.findByTileContaining("teacher", pageRequest);
        System.out.println("Total pages:" + teacher.getTotalPages());
        System.out.println("Content: "+teacher.getContent());
    }
}