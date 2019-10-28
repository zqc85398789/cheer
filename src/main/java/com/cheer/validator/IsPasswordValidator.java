package com.cheer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cheer.validator.annotation.IsPassword;

public class IsPasswordValidator implements ConstraintValidator<IsPassword, Object> {

	private boolean required;

	@Override
	public void initialize(IsPassword isPassword) {
		required = isPassword.required();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if (required) {
			if (obj instanceof String) {
				String password = (String) obj;
				String pattern = "[A-Z][A-Za-z0-9_]{4,19}";
				return password.matches(pattern);
			}
		}
		return false;
	}

}
