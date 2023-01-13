package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.employee.dto.EmployeeDto;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee save(EmployeeDto dto) {
		Employee emp = Employee.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
				.email(dto.getEmail()).department(dto.getDepartment()).designation(dto.getDesignation())
				.dateOfBirth(dto.getDateOfBirth()).build();

		return repository.save(emp);
	}

	@Override
	public Employee findById(String empId) {
		Optional<Employee> result = repository.findById(empId);
		if (result.isEmpty()) {
			throw new EmployeeNotFoundException("Resource not found");
		}

		return result.get();
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String empId) {
		findById(empId);
		repository.deleteById(empId);
	}

	@Override
	public Employee update(Employee emp, String empId) {
		Employee result = findById(empId);
		if (StringUtils.hasText(emp.getDepartment()))
			result.setDepartment(emp.getDepartment());
		if (StringUtils.hasText(emp.getDesignation()))
			result.setDesignation(emp.getDesignation());
		return repository.save(result);
	}

	@Override
	public Optional<Employee> findByEmail(String email) {
		
		return repository.findByEmail(email);
	}

}
