package com.cheer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cheer.validator.annotation.IsEmpno;

public class IsEmpnoValidator implements ConstraintValidator<IsEmpno, Object> {
	private boolean required;
	
	@Override
	public void initialize(IsEmpno isEmpno) {
		this.required = isEmpno.required();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if(required) {
			if(obj instanceof String) {
				String empno = (String)obj;
				String pattern = "[\\w]{6}";
				return empno.matches(pattern);
			}
		}
		return false;
	}

}
