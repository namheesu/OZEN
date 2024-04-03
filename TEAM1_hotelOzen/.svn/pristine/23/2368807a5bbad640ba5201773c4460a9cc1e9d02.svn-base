package kr.or.ddit.global.security;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Retention(RUNTIME)
@Target(PARAMETER)
@AuthenticationPrincipal(expression = "empUser")
public @interface EmpUser {
	
}
