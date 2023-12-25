package com.springstarter.springstarterweb.service;

import com.springstarter.springstarterweb.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import com.springstarter.springstarterweb.entity.DepartmentEntity;
import com.springstarter.springstarterweb.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private final DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentEntity saveDepartment(DepartmentEntity department) {
		return this.departmentRepository.save(department);
	}

	@Override
	public List<DepartmentEntity> getDeparts() {
		return this.departmentRepository.findAll();
	}

	@Override
	public DepartmentEntity getDepartmentById(Long id) throws DepartmentNotFoundException {
		Optional<DepartmentEntity> byId = this.departmentRepository.findById(id);
		if (!byId.isPresent()) {
			throw new DepartmentNotFoundException("Department Not found!");
		}
		return byId.get();
	}

	@Override
	public void deleteDepartmentById(Long id) {
		this.departmentRepository.deleteById(id);
	}

	@Override
	public DepartmentEntity updateDepartment(Long id, DepartmentEntity department) {
		Optional<DepartmentEntity> byId = this.departmentRepository.findById(id);
		if (byId.isPresent()) {
			DepartmentEntity departmentEntity = byId.get();
			departmentEntity.mergeDepartment(department);
			return this.departmentRepository.save(departmentEntity);
		}
		return null;
	}

	@Override
	public DepartmentEntity fetchDepartmentByName(String departmentName) {
		return  this.departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
