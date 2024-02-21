package com.gthm.springboot.repository;

import com.gthm.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByDepartmentName(String department);
    Department findByDepartmentNameIgnoreCase(String department);
}
