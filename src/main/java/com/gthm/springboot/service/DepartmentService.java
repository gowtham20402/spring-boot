package com.gthm.springboot.service;

import com.gthm.springboot.entity.Department;
import com.gthm.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartment();
    Department fetchDepartmentById(int departmentId) throws DepartmentNotFoundException;
    void deleteDepartmentById(int departmentId);
    Department updateDepartment(int departmentId, Department department);

    Department fetchDepartmentNameById(String departmentName);
}
