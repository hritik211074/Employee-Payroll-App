package com.bridgelabz.spring_employee_payroll__app.section2_uc03.controller;

import com.bridgelabz.spring_employee_payroll__app.section2_uc03.dto.EmployeeDTO;
import com.bridgelabz.spring_employee_payroll__app.section2_uc03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Autowired EmployeeService to handle business logic
    @Autowired
    private EmployeeService employeeService;

    // Create or Update Employee (POST or PUT)
    @PostMapping
    public EmployeeDTO createOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createOrUpdateEmployee(employeeDTO);
    }

    // Get All Employees (GET)
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee by Name (GET)
    @GetMapping("/{name}")
    public EmployeeDTO getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{name}")
    public HttpStatus deleteEmployee(@PathVariable String name) {
        employeeService.deleteEmployee(Long.valueOf(name));
        return HttpStatus.NO_CONTENT;
    }
}
