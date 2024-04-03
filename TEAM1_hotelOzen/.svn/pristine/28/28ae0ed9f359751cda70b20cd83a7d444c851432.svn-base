package kr.or.ddit.global.validate.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {
	String message () default "{kr.or.ddit.global.validate.constraints.Adult.message}";
	Class<?>[] groups() default {};
	Class<?>[] payload() default {};
}
