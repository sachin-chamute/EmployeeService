package com.employee.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.employee.validator.AgeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AgeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeBetween {
	int min() default 21;
	int max() default 60;
	String message() default "Age should be in between 21 and 60";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
