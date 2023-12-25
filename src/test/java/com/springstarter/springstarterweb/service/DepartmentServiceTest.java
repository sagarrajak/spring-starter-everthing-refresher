package com.springstarter.springstarterweb.service;

import com.springstarter.springstarterweb.entity.DepartmentEntity;
import com.springstarter.springstarterweb.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        DepartmentEntity department = DepartmentEntity.builder().departmentId(1l).departmentName("IT").departmentCode("IT-06").departmentAddress("Something").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        DepartmentEntity departmentEntity = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, departmentEntity.getDepartmentName());
    }
}