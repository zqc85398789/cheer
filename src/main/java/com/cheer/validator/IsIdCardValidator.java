package com.cheer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cheer.validator.annotation.IsIdCard;

public class IsIdCardValidator implements ConstraintValidator<IsIdCard, Object> {
	private boolean required;
	
	@Override
	public void initialize(IsIdCard isIdCard) {
		this.required = isIdCard.required();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if(required) {
			if(obj instanceof String) {
				String idCard = (String)obj;
				String pattern = "[0-9]{17}[0-9x]{1}";
				return idCard.matches(pattern);
			}
		}
		return false;
	}

}
