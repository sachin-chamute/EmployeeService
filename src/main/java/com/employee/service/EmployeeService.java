package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;

public interface EmployeeService {

	public Employee save(EmployeeDto dto);

	public Employee findById(String empId);

	public List<Employee> findAll();

	public void delete(String empId);
	
	public Employee update(Employee emp,String empId);
	
	public Optional<Employee> findByEmail(String email);
}
