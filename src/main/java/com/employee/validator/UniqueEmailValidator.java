package com.employee.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.annotation.UniqueEmail;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private EmployeeService service;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		Optional<Employee> emp = service.findByEmail(email);
		return emp.isEmpty();
	}

}
