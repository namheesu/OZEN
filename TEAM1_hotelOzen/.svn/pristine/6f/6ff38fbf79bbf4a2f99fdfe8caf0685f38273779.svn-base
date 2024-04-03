package kr.or.ddit.global.validate.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String>{

	private Password annotaion;
	
	@Override
	public void initialize(Password constraintAnnotation) {
		this.annotaion = constraintAnnotation;
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean valid = true;
		if(value != null && value.trim().length()>0)
			valid = value.matches(annotaion.regex());
		return valid;
	}
}
