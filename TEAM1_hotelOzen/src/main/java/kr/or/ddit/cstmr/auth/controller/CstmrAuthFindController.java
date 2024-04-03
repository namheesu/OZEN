package kr.or.ddit.cstmr.auth.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.cstmr.auth.service.MberAuthService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.otp.OtpUtils;
import kr.or.ddit.global.vo.CstmrVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/auth")
public class CstmrAuthFindController {
	
	@Inject
	MberAuthService service;
	
	@Inject
	OtpUtils otpUtil;
	
	String mberId;
	
	@GetMapping("/findId.do")
	public String findId() {
		return "cstmr/auth/findId";
	}
	
	@PostMapping(value = "/findId.do")
	public String authenticate(
		@ModelAttribute CstmrVO user
		, HttpSession session
		, Model model
	) {
		String logicalViewName = null;
		
		CstmrVO realUser = service.checkUser(user);
		if(realUser != null) {
			session.setAttribute("realUser", realUser);
			logicalViewName = "redirect:/auth/findId/result.do";
		}else {			
			model.addAttribute("message", "등록되지 않은 사용자입니다.");
			logicalViewName = "cstmr/auth/findId";
		}
		
		return logicalViewName;
	}
	
	@GetMapping("/findId/result.do")
	public String findIdResult() {
		return "cstmr/auth/findResult";
	}
	
	@GetMapping("/findPwd.do")
	public String findPwd() {
		return "cstmr/auth/findPwd";
	}
	
	@PostMapping(value = "/findPwd.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String findPwdProcess(
		@RequestBody CstmrVO cst
	) {
		log.info("test ===>{}", cst);
		
		ServiceResult result = service.checkUserById(cst);
		mberId = service.retrieveMberId(cst);
		
		String message = null;
		if(mberId != null) {
			switch (result) {
			case OK:
				message = otpUtil.creatCode();
				break;
	
			default:
				message = "서버 오류 발생! 다시 입력해주세요.";
				break;
			}
		}else {
			message = "등록되지 않은 사용자입니다.";
		}
		return message;
	}
	
	@PostMapping(value= "/otp.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> checkOtp(
		@RequestBody Map<String, String> otpAuth
	) throws InvalidKeyException, NoSuchAlgorithmException{
		Map<String, Object> jsonObj = new HashMap<>();
		
		String otpNo = otpAuth.get("otpNo");
		String otpCd = otpAuth.get("otpCd");
		
		boolean checkResult = false;
		
		try {
			long codeCheck = Integer.parseInt(otpNo);
			long l = new Date().getTime();
			long ll =  l / 30000;
			checkResult = otpUtil.checkCode(otpCd, codeCheck, ll);
		} catch (NumberFormatException e) {
			checkResult = false;
		}
		
		if(!checkResult) {
			jsonObj.put("message", "error");
		}else {
			jsonObj.put("message", "ok");
			jsonObj.put("mberId", mberId);
		}
		
		return jsonObj;
	}
	
	
}
