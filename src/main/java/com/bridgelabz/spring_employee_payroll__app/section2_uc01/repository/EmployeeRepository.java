package com.bridgelabz.spring_employee_payroll__app.section2_uc01.repository;

import com.bridgelabz.spring_employee_payroll__app.section1_uc02.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
