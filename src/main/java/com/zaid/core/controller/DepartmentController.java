package com.zaid.core.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaid.core.entity.Department;
import com.zaid.core.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("posting" + department.getDepartmentName());// Logger
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		logger.info("Getting list of department");// Logger
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) {

		logger.info("Getting list of department");// Logger
		return departmentService.fetchDepartmentByID(departmentId);
	}

	@DeleteMapping("/departments/{id}")
	public void deleteDepartmentByID(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentByID(departmentId);
		System.out.println(departmentId + "  is deleted.");
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartmentByID(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartmentByID(departmentId, department);
	}

}
