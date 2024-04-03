package kr.or.ddit.global.validate.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelNumberValidator implements ConstraintValidator<TelNumber, String>{

	private TelNumber annotaion;
	
	@Override
	public void initialize(TelNumber constraintAnnotation) {
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
