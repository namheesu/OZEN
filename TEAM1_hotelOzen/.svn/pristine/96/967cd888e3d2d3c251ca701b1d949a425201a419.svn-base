package kr.or.ddit.global.validate.constraints;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate>{
	
	private Adult annotaion;
	
	@Override
	public void initialize(Adult constraintAnnotation) {
		this.annotaion = constraintAnnotation;
	}
	
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		boolean valid = false;
		LocalDate currentDate = LocalDate.now();
		if(value!=null) {
			valid = currentDate.minusYears(19).isAfter(value);
		}
		return valid;
	}
}
