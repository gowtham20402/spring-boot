package com.gthm.springboot.controller;

import com.gthm.springboot.entity.Department;
import com.gthm.springboot.error.DepartmentNotFoundException;
import com.gthm.springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")                        // converts json to Department obj
    public Department saveDepartment(@Valid   @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment(){
        LOGGER.info("Inside fetchDepartment  of DepartmentController");
        return departmentService.fetchDepartment();
    }

    @GetMapping("/departments/{id}")                //denotes int department is a path variable
    public Department fetchDepartmentById(@PathVariable("id") int departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") int departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") int departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")                //denotes int department is a path variable
    public Department fetchDepartmentNameById(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentNameById(departmentName);
    }
}
