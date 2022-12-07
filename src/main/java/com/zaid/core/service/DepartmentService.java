package com.zaid.core.service;

import java.util.List; 
import java.util.Optional;

import com.zaid.core.entity.Department;

public interface DepartmentService {
	

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentByID(Long departmentId);

	public void deleteDepartmentByID(Long departmentId);

	public Department updateDepartmentByID(Long departmentId, Department department);
	
}
