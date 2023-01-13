package com.employee.dto;

import java.time.LocalDate;

import com.employee.annotation.AgeBetween;
import com.employee.annotation.UniqueEmail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDto {
	@Pattern(regexp = "^[a-zA-Z]*$",message="Only alphabets are allowed")
	@NotEmpty
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]*$",message="Only alphabets are allowed")
	@NotEmpty
	private String lastName;
	@UniqueEmail
	private String email;
	@AgeBetween
	private LocalDate dateOfBirth;
	private String designation;
	private String department;
}
