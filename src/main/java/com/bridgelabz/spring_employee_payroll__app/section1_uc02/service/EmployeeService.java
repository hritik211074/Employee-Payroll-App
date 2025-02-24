package com.bridgelabz.spring_employee_payroll__app.section1_uc02.service;

import com.bridgelabz.spring_employee_payroll__app.section1_uc02.model.Employee;
import com.bridgelabz.spring_employee_payroll__app.section1_uc02.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    // Delete employee by ID
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
