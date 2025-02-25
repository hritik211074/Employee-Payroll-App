package com.bridgelabz.spring_employee_payroll__app.section2_uc01.controller;
import com.bridgelabz.spring_employee_payroll__app.section2_uc01.dto.EmployeeDTO;
import com.bridgelabz.spring_employee_payroll__app.section2_uc01.model.Employee;
import com.bridgelabz.spring_employee_payroll__app.section2_uc01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create or Update an Employee (POST or PUT)
    @PostMapping
    public EmployeeDTO createOrUpdateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return employeeService.convertToDTO(savedEmployee);
    }

    // Get All Employees (GET)
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee by ID (GET)
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return HttpStatus.NO_CONTENT;
    }
}
