package kr.or.ddit.global.validate.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
	String regex() default "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}";
	String message() default "{kr.or.ddit.global.validate.constraints.Password.message}";
	Class<?>[] groups() default {};
	Class<?>[] payload() default {};
}
