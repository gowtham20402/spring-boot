package com.gthm.springboot.service;

import com.gthm.springboot.entity.Department;
import com.gthm.springboot.error.DepartmentNotFoundException;
import com.gthm.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(int departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(departmentId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();    // .get() is to get value from list.
    }

    @Override
    public void deleteDepartmentById(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(int departmentId, Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();  // get the value and assigned to depDb
                                                                               //    for further.

//        to check the fields which are really necessary to be updated.
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentBlock()) && !"".equalsIgnoreCase(department.getDepartmentBlock())){
            depDb.setDepartmentBlock(department.getDepartmentBlock());
        }

        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentNameById(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
//        return departmentRepository.findByDepartmentName(departmentName);
    }

}
