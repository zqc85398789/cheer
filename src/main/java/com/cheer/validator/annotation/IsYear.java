package com.cheer.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cheer.validator.IsYearValidator;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=IsYearValidator.class)
public @interface IsYear {
	boolean required() default true;
	String message() default "格式不正确";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
