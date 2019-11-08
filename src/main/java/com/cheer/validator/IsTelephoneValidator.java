package com.cheer.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cheer.validator.annotation.IsTelephone;

public class IsTelephoneValidator implements ConstraintValidator<IsTelephone, Object> {
	private boolean required;
	
	@Override
	public void initialize(IsTelephone isTelephone) {
		required = isTelephone.required();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if(required) {
			if(obj instanceof String) {
				String telephoneNo = (String)obj;
				String pattern = "[1]{1}[0-9]{10}";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(telephoneNo);
				if(m.find()) {
					return true;
				}
			}
		}
		return false;
	}

}
