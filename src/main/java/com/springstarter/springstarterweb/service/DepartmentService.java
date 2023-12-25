package com.springstarter.springstarterweb.service;

import com.springstarter.springstarterweb.entity.DepartmentEntity;
import com.springstarter.springstarterweb.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService  {
	
	public DepartmentEntity saveDepartment(DepartmentEntity department);

	public List<DepartmentEntity> getDeparts();

	DepartmentEntity getDepartmentById(Long id) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long id);

	DepartmentEntity updateDepartment(Long id, DepartmentEntity department);

	DepartmentEntity fetchDepartmentByName(String departmentName);
}
