package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeDto dto) {
		Employee response = service.save(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> findById(@PathVariable String empId) {
		Employee response = service.findById(empId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> result = service.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<String> delete(@PathVariable String empId) {
		service.delete(empId);
		return new ResponseEntity<>("Record deleted", HttpStatus.OK);
	}

	@PutMapping("/{empId}")
	public ResponseEntity<Employee> update(@RequestBody Employee emp, @PathVariable String empId) {
		Employee result = service.update(emp, empId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
