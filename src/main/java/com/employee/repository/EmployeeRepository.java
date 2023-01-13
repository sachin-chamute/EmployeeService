package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	public Optional<Employee> findByEmail(String email);
}
