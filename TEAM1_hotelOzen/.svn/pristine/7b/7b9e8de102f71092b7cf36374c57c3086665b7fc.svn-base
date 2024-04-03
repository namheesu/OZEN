package kr.or.ddit.global.security.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccesstHandler extends SimpleUrlLogoutSuccessHandler {
	
	@Override
	public void onLogoutSuccess(
			HttpServletRequest request
			, HttpServletResponse response
			, Authentication authentication) throws IOException, ServletException {
		
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();

		if(authorities.stream().anyMatch(a->a.getAuthority().equals("ROLE_EMP"))) {
			super.onLogoutSuccess(request, response, authentication);
			getRedirectStrategy().sendRedirect(request, response, request.getContextPath()+"/emp/auth/Login.do");			
		} else if(authorities.stream().anyMatch(a->a.getAuthority().equals("ROLE_USER"))) {
			super.onLogoutSuccess(request, response, authentication);
		} else {
			String errorMesaage = "권한이 없는 사용자입니다.";
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			request.getSession().setAttribute("errorMesaage", errorMesaage);
			response.sendRedirect(request.getContextPath() + "error/403");
		}
		HttpSession session = request.getSession(false);
		Optional.ofNullable(session).ifPresent(s->s.invalidate());
	}
}
