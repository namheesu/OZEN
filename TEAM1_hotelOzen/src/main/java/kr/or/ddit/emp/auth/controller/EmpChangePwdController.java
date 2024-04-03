package kr.or.ddit.emp.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.auth.service.EmpAuthService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.validate.UpdateGroup;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpChangePwdController {
	
	@Inject
	EmpAuthService service;
	
	@Inject
	@Named("empManager")
	private AuthenticationManager empManager;
	
	@PostMapping(value = "/auth/changePwd.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> changePwd(
		@Validated(UpdateGroup.class) @RequestBody EmpVO emp
		, BindingResult errors
	){
		log.info("업데이트 대상자 : {}", emp);
		Map<String, Object> jsonObj = new HashMap<>();
		
		ServiceResult result = null;
		
		if(!errors.hasErrors()) {
			emp.setEmpPw(emp.getNewPwd());
			result = service.changePwd(emp);
			switch (result) {
			case FAIL:
				jsonObj.put("message","error");
				break;

			default:
				jsonObj.put("message", "ok");
				break;
			}
		}else {
			jsonObj.put("message","error");
			Map<String, String> errorsMap= new HashMap<>();
			errors.getFieldErrors().forEach(fe->{
				errorsMap.put(fe.getField(),fe.getDefaultMessage());
			});
			jsonObj.put("errors", errorsMap);
		}
		
		return jsonObj;
	}

	@PostMapping(value = "/mypage/changePwd.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> changePwdInMyPage(
			@EmpUser EmpVO authEmp
			, @Validated(UpdateGroup.class) @RequestBody EmpVO emp
			, BindingResult errors
			, HttpServletRequest req
			){
		
		String currentPw =  authEmp.getEmpPw();
		String empPw = emp.getEmpPw();
		String newPwd = emp.getNewPwd();
		
		log.info("currentPw : {}, empPw : {}, newPwd : {}", currentPw, empPw, newPwd);
		
		Map<String, Object> jsonResult = new HashMap<>();

		if(!currentPw.equals(empPw)) {
			
			jsonResult.put("message","error");
			jsonResult.put("errorMessage","기존 비밀번호와 일치하지 않습니다.");
		
		} else {
			emp.setEmpNo(authEmp.getEmpNo());
			emp.setEmpPw(newPwd);
			ServiceResult result = null;
			
			if(!errors.hasErrors()) {
				result = service.changePwd(emp);
				switch (result) {
				case FAIL:
					jsonResult.put("message","error");
					jsonResult.put("errorMessage","비밀번호 형식이 일치하지 않습니다. ");
					break;
					
				default:
					String newAuthPwd = emp.getEmpPw();
					String username = emp.getEmpNo();
					
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, newAuthPwd);
					Authentication auth = empManager.authenticate(token);
//					auth.setAuthenticated(true);
					WebAuthenticationDetails details = new WebAuthenticationDetails(req);
					((UsernamePasswordAuthenticationToken)auth).setDetails(details);
					SecurityContextHolder.getContext().setAuthentication(auth);
					
					jsonResult.put("message", "ok");
	//				service.changePwd(emp);
					break;
				}
			} else {
				jsonResult.put("message","error");
				jsonResult.put("errorMessage","비밀번호 형식이 일치하지 않습니다.");
				Map<String, String> errorsMap= new HashMap<>();
				errors.getFieldErrors().forEach(fe->{
					errorsMap.put(fe.getField(),fe.getDefaultMessage());
				});
				jsonResult.put("errors", errorsMap);
			}
		}
		
		return jsonResult;
	}
	

}
