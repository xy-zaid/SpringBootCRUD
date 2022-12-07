package com.zaid.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zaid.core.repository.DepartmentRepository;
import com.zaid.core.service.DepartmentService;

@SpringBootTest
class CoreApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Test
	public void deptTest() {
		String className= departmentService.getClass().getName();
		System.out.println(className);
		System.out.println("service");
	}
	@Test
	public void repoTest() {
		String className= this.departmentRepository.getClass().getName();
		System.out.println(className);
		System.out.println("repo");
	}
	
	
	

}
