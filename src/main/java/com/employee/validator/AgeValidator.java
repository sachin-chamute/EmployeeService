package com.employee.validator;

import java.time.LocalDate;
import java.time.Period;

import com.employee.annotation.AgeBetween;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeBetween, LocalDate> {

	int min = 0;
	int max = 0;

	@Override
	public void initialize(AgeBetween constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		long age = Period.between(value, LocalDate.now()).getYears();

		if (age > min && age < max)
			return true;

		return false;
	}

}
