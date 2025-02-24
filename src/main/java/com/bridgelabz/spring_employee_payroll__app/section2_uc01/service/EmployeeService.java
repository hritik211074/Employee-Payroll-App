package com.bridgelabz.spring_employee_payroll__app.section2_uc01.service;

import com.bridgelabz.spring_employee_payroll_app.section1_uc01.dto.EmployeeDTO;
import com.bridgelabz.spring_employee_payroll_app.section1_uc01.model.Employee;
import com.bridgelabz.spring_employee_payroll_app.section1_uc01.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Convert Employee model to EmployeeDTO
    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    // Get all Employees and convert to DTO
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Employee by ID and convert to DTO
    public EmployeeDTO getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(this::convertToDTO).orElse(null);
    }

    // Delete Employee by ID
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}

