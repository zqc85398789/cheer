package com.cheer.validator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.core.annotation.AnnotationConfigurationException;

import com.cheer.validator.annotation.SamePassword;

public class SamePasswordValidator implements ConstraintValidator<SamePassword, Object> {

	private boolean required;
	private String field1;
	private String field2;

	@Override
	public void initialize(SamePassword samePassword) {
		required = samePassword.required();
		field1 = samePassword.field1();
		field2 = samePassword.field2();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if (required) {
			return validate(obj);
		}
		return true;
	}

	private boolean validate(Object obj) {
		Class<?> clazz = obj.getClass();
		try {
			Field f1 = clazz.getDeclaredField(field1);
			Field f2 = clazz.getDeclaredField(field2);
			if (!"class java.lang.String".equals(f1.getGenericType().toString())) {
				throw new AnnotationConfigurationException(field1 + "不是String类型数据");
			}
			if (!"class java.lang.String".equals(f2.getGenericType().toString())) {
				throw new AnnotationConfigurationException(field2 + "不是String类型数据");
			}
			Method m1 = obj.getClass().getMethod("get" + getMethodName(field1));
			Method m2 = obj.getClass().getMethod("get" + getMethodName(field2));
			String s1 = (String) m1.invoke(obj);
			String s2 = (String) m2.invoke(obj);
			return s1.equals(s2);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private String getMethodName(String fieldName) {
		byte[] bytes = fieldName.getBytes();
		bytes[0] = (byte) ((char) bytes[0] + ('A' - 'a'));
		return new String(bytes);
	}
}
