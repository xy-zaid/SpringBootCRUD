package com.zaid.core.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.zaid.core.controller.DepartmentController;
import com.zaid.core.entity.Department;
import com.zaid.core.error.DepartmentNotFound;
import com.zaid.core.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Override
	public Department saveDepartment(Department department) {
		logger.info("posting in service " + department.getDepartmentName());// Logger
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentByID(Long departmentId) {
		try {
			logger.info("in service");
			Optional<Department> department = departmentRepository.findById(departmentId);
			return department.get();
		} catch (NoSuchElementException e) {
			throw new DepartmentNotFound(
					"ID - " + departmentId + " is not present in database, kindly provide correct ID");
		}

	}

	@Override
	public void deleteDepartmentByID(Long departmentId) {
		try {
			logger.info("in delete service");
			departmentRepository.deleteById(departmentId);
		} catch (EmptyResultDataAccessException e) {
			throw new DepartmentNotFound(
					"ID - " + departmentId + " is not present in database, kindly provide correct ID");
		}

	}

	@Override
	public Department updateDepartmentByID(Long departmentId, Department department) {
		try {
			Department depDB = departmentRepository.findById(departmentId).get();
			if (Objects.nonNull(department.getDepartmentName())) {
				depDB.setDepartmentName(department.getDepartmentName());
			}
			if (Objects.nonNull(department.getDepartmentCode())) {
				depDB.setDepartmentCode(department.getDepartmentCode());
			}
			if (Objects.nonNull(department.getDepartmentAddress())) {
				depDB.setDepartmentAddress(department.getDepartmentAddress());
			}
			return departmentRepository.save(depDB);
		} catch (NoSuchElementException e) {
		}
		throw new DepartmentNotFound("ID - " + departmentId + " is not present in database, kindly provide correct ID");
	}

}
