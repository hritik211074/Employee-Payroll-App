package com.bridgelabz.spring_employee_payroll__app.section2_uc03.service;

import com.bridgelabz.spring_employee_payroll_app.section1_uc01.dto.EmployeeDTO;
import com.bridgelabz.spring_employee_payroll_app.section1_uc01.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    // In-memory storage (List) for employee data
    private List<Employee> employeeList = new ArrayList<>();

    // Create or Update an Employee
    public EmployeeDTO createOrUpdateEmployee(EmployeeDTO employeeDTO) {
        // Convert DTO to Model (Entity)
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        // Simulate saving by adding/updating the employee in the list
        Optional<Employee> existingEmployee = employeeList.stream()
                .filter(emp -> emp.getName().equals(employee.getName()))
                .findFirst();

        if (existingEmployee.isPresent()) {
            existingEmployee.get().setSalary(employee.getSalary()); // Update salary
        } else {
            employeeList.add(employee); // Add new employee
        }

        // Return EmployeeDTO
        return convertToDTO(employee);
    }

    // Convert Employee model to EmployeeDTO
    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    // Get all Employees and convert to DTO
    public List<EmployeeDTO> getAllEmployees() {
        return employeeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Employee by Name and convert to DTO
    public EmployeeDTO getEmployeeByName(String name) {
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getName().equals(name))
                .findFirst();
        return employee.map(this::convertToDTO).orElse(null);
    }

    // Delete Employee by Name (simulating removal from the in-memory list)
    public void deleteEmployee(String name) {
        employeeList.removeIf(employee -> employee.getName().equals(name));
    }
}

