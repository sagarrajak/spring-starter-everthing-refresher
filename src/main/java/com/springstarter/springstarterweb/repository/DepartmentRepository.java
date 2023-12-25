package com.springstarter.springstarterweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springstarter.springstarterweb.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{
    public DepartmentEntity findByDepartmentNameIgnoreCase(String departmentName);

}
