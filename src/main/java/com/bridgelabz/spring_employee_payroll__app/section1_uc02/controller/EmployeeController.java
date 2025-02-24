package com.bridgelabz.spring_employee_payroll__app.section1_uc02.controller;
import com.bridgelabz.spring_employee_payroll_app.section1_uc02.model.Employee;
import com.bridgelabz.spring_employee_payroll_app.section1_uc02.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create or Update an Employee (POST or PUT)
    @PostMapping
    public Employee createOrUpdateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Get All Employees (GET)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee by ID (GET)
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return HttpStatus.NO_CONTENT;
    }
}
