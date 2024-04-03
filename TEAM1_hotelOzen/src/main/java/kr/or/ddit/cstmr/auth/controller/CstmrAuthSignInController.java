package kr.or.ddit.cstmr.auth.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.cstmr.auth.service.MberAuthService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.validate.InsertGroup;
import kr.or.ddit.global.vo.RegistVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/auth")
public class CstmrAuthSignInController {

	@Inject
	private MberAuthService service;
	
	@ModelAttribute("newMber")
	public RegistVO newMber() {
		return new RegistVO();
	}
	
	
	/**
	 * 회원가입 페이지 접근
	 * @return
	 */
	@GetMapping("join.do")
	public String singIn() {
		return "cstmr/auth/join";
	}

	/**
	 * 아이디 중복 확인 컨트롤러
	 * @param mberId
	 * @return
	 */
	@PostMapping(value = "idvalid.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> idValidateProcess(
		@RequestBody Map<String, String> mberId
	){
		boolean check = false;
		
		Map<String, Object> jsonObj = new HashMap<>();
		check = service.idDuplicateCheck(mberId.get("mberId"));
		if(!check) {
			jsonObj.put("check", check);
			jsonObj.put("message", "duplicated");
			return jsonObj;
		}else {
			String regex = "^[a-zA-Z0-9]+$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(mberId.get("mberId"));
			check = matcher.matches();
			
			jsonObj.put("check", check);
			jsonObj.put("message", "regex");
			return jsonObj;
		}
		
		
	}
	
	/**
	 * 회원가입 검증 컨트롤러
	 * @param newMber
	 * @param errors
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("join.do")
	public String signInProcess(
		@Validated(InsertGroup.class) @ModelAttribute("newMber") RegistVO newMber
		, BindingResult errors
		, Model model
		, HttpSession session
	) {
		String logicaViewName = null;
		String message = null;
		
		// 에러가 없는 경우
		if (!errors.hasErrors()) {
			ServiceResult result = null;
			result = service.createNewMber(newMber);
			
			switch (result) {
			// 가입 성공 페이지로 이동
			case OK:
				session.setAttribute("cstNm", newMber.getCstNm());
				logicaViewName = "redirect:/auth/joinComplete.do";
				break;

			// 사용자 이름, 전화번호 중복
			case USERDUPLICATED:
				message = "이미 등록된 사용자입니다.";
				logicaViewName = "cstmr/auth/join";
				break;

			// 서버 오류, 가입 실패
			// 다시 회원가입 페이지로 돌아가기
			default:
				message = "서버에 문제가 발생했습니다. 다시 시도해주세요";
				logicaViewName = "cstmr/auth/join";
				break;
			}
			log.info("message : {}", message);
			
			model.addAttribute("message", message);
		// 검증 실패, 가입 페이지로 돌아가기
		} else {
			logicaViewName = "cstmr/auth/join";
		}
		return logicaViewName;
	}
	
	
	/**
	 * 회원가입 성공 페이지 이동 컨트롤러
	 * @return
	 */
	@GetMapping("joinComplete.do")
	public String joinDonePage(
	) {
		return "cstmr/auth/joinDone";			
	}
	
}
