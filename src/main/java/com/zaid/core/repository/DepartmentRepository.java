package com.zaid.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zaid.core.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
