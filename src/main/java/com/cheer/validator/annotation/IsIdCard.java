package com.cheer.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cheer.validator.IsIdCardValidator;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=IsIdCardValidator.class)
public @interface IsIdCard {
	boolean required() default true;
	String message() default "格式不正确";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
