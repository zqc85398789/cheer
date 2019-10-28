package com.cheer.validator.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cheer.validator.SamePasswordValidator;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy=SamePasswordValidator.class)
public @interface SamePassword {
	boolean required() default true;
	String message() default "两次输入的密码不一致";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String field1();
	String field2();
}
