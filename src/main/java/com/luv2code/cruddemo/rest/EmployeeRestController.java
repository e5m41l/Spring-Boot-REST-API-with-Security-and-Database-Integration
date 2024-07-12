package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // define the dao

    private EmployeeService employeeService;

    // inject employee dao <==

    @Autowired
    public EmployeeRestController (EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee (@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee (@RequestBody Employee theEmployee) {

        // set the employee id to 0 - in case the user set it
        // this is to force a save of a new item
        theEmployee.setId(0);

        // add the employee using the employee service
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }


    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee (@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return null;
    }

    // add mapping for DELETE /employees/{employeeId} - deleting an existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee (@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        // check if the employee exists in the database
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
