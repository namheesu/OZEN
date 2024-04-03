package kr.or.ddit.cstmr.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.cstmr.auth.service.MberAuthService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.validate.UpdateGroup;
import kr.or.ddit.global.vo.CstmrVO;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Controller
@RequestMapping
public class CstmrAuthChangePwdController {
	
	@Inject
	MberAuthService service;
	
	@PostMapping("/auth/changePwd.do")
	@ResponseBody
	public Map<String, Object> changePwd(
		@Validated(UpdateGroup.class) @RequestBody CstmrVO cst
		, BindingResult errors
	){
		log.info("업데이트 대상자 : {}", cst);
		Map<String, Object> jsonObj = new HashMap<>();
		
		ServiceResult result = null;
		
		if(!errors.hasErrors()) {
			result = service.changePwd(cst);
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
			log.info("errors ====> {}", errorsMap);
			jsonObj.put("errors", errorsMap);
		}
		
		return jsonObj;
	}
	
}
