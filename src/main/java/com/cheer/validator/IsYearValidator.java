package com.cheer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cheer.validator.annotation.IsYear;

public class IsYearValidator implements ConstraintValidator<IsYear, Object> {
	private boolean required;
	
	@Override
	public void initialize(IsYear isYear) {
		this.required = isYear.required();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if(required) {
			if(obj instanceof String) {
				String empno = (String)obj;
				String pattern = "[0-9]{4}";
				return empno.matches(pattern);
			}
		}
		return false;
	}

}
