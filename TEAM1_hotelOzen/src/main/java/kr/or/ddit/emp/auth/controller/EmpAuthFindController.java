package kr.or.ddit.emp.auth.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.auth.service.EmpAuthService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.otp.OtpUtils;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/auth")
public class EmpAuthFindController {
	
	@Inject
	private EmpAuthService serivce;
	
	@Inject
	OtpUtils otpUtil;
	
	private String realUser;
	
	@GetMapping("/findId.do")
	public String findId() {
		return "emp/auth/findId";
	}
	
	@GetMapping("/findPwd.do")
	public String findPwd() {
		return "emp/auth/findPwd";
	}
	
	
	@PostMapping(value = "/findLogic.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String authenticate(
		@RequestBody EmpVO emp
	) {
		log.info("test ======> {}", emp);
		
		ServiceResult result = serivce.checkUser(emp);
		
		String message = null;
		
		switch (result) {
			case OK:
				//인증키 생성
				message = otpUtil.creatCode();
				realUser = serivce.findEmpNo(emp);
				break;
			default:
				message = "서버 오류 발생! 다시 입력해주세요";
				break;
		}
		return message;
	}
	
	@PostMapping(value="/otp.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
		}catch (NumberFormatException e) {
			checkResult = false;
		}
		
		if(!checkResult) {
			jsonObj.put("message", "error");
		}else {
			jsonObj.put("message", "ok");
			jsonObj.put("empNo", realUser);
		}
		
		return jsonObj;
	}
	
}
