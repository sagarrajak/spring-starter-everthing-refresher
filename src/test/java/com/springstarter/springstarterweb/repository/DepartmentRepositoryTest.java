package com.springstarter.springstarterweb.repository;

import com.springstarter.springstarterweb.entity.DepartmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        DepartmentEntity department = DepartmentEntity.builder().departmentName("IT").departmentCode("IT-06").departmentAddress("Something").build();
        entityManager.persist(department);
    }

    @Test
//    @DisplayName("when find by id, return department")
    public void whenFindById_thenReturnDepartment() {
        DepartmentEntity departmentEntity = departmentRepository.findById(1L).get();
        assertEquals(departmentEntity.getDepartmentName(), "IT");
    }
}