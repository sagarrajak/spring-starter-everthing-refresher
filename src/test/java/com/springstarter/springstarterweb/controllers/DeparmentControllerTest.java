package com.springstarter.springstarterweb.controllers;

import com.springstarter.springstarterweb.entity.DepartmentEntity;
import com.springstarter.springstarterweb.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

// TODO: write controller test
@WebMvcTest(DepartmentController.class)
class DeparmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentRepository departmentRepository;

    DepartmentEntity department;

    @BeforeEach
    void setUp() {
        department = DepartmentEntity.builder().departmentId(1l).departmentName("IT").departmentCode("IT-06").departmentAddress("Something").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    void saveDepartment() {
//        DepartmentEntity department = DepartmentEntity
//                .builder()
//                .departmentId(1l)
//                .departmentName("IT")
//                .departmentCode("IT-07")
//                .departmentAddress("Something")
//                .build();
//
//        Mockito.when()

    }
}