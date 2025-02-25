package com.bridgelabz.spring_employee_payroll__app.section1_uc01.repository;


import com.bridgelabz.spring_employee_payroll__app.section1_uc01.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can define custom queries here if needed.
}

