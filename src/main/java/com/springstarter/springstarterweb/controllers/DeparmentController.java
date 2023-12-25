package com.springstarter.springstarterweb.controllers;

import com.springstarter.springstarterweb.error.DepartmentNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.springstarter.springstarterweb.entity.DepartmentEntity;
import com.springstarter.springstarterweb.service.DepartmentService;

import java.util.List;

@RestController
public class DeparmentController {
	private final DepartmentService departmentService;
	private final Logger LOGGER = LoggerFactory.getLogger(DeparmentController.class);
	
	public DeparmentController(DepartmentService departmentService) {
		super();
		this.departmentService =
				departmentService;
	}

	@PostMapping("/department")
	private DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity department) {
		LOGGER.info("Inside department controller save");
		return this.departmentService.saveDepartment(department);
	}

	@GetMapping("/department")
	private List<DepartmentEntity> getDepartments() {
		return  this.departmentService.getDeparts();
	}

	@GetMapping("/department/name/{name}")
	private DepartmentEntity getDepartments(@PathVariable("name") String name) {
		return  this.departmentService.fetchDepartmentByName(name);
	}

	@GetMapping("/department/{id}")
	private DepartmentEntity getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return this.departmentService.getDepartmentById(departmentId);
	}


	@DeleteMapping("/department/{id}")
	private String deleteDepartment(@PathVariable("id") Long id) {
		this.departmentService.deleteDepartmentById(id);
		return "department deleted successfully!";
	}

	@PutMapping("/department/{id}")
	private DepartmentEntity updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentEntity department) {
		return this.departmentService.updateDepartment(id, department);
	}
}
