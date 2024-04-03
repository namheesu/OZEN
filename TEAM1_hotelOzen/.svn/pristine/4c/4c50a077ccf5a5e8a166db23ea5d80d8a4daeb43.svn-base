package kr.or.ddit.global.security.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request
			, HttpServletResponse response
			, Authentication authentication) throws ServletException, IOException {

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
		
		log.info("권한 정보 : {}", authorities);
		
		if(authorities.stream().anyMatch(a->a.getAuthority().equals("ROLE_EMP"))) {
	
			response.sendRedirect(request.getContextPath() + "/emp");
		
		} else if(authorities.stream().anyMatch(a->a.getAuthority().equals("ROLE_USER"))) {
			
			super.onAuthenticationSuccess(request, response, authentication);			
			
		} else {
			
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		
		}
	}
}
