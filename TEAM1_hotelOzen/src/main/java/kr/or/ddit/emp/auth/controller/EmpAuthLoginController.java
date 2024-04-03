package kr.or.ddit.emp.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.auth.service.EmpAuthService;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.mybatis.mappers.EmpMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/auth")
public class EmpAuthLoginController {
	
	@Inject
	EmpAuthService service;
	
	@Inject
	EmpMapper dao;
	
	@GetMapping("Login.do")
	public String loginPage(
		Model model
	) {
		List<EmpVO> empList = service.loginList();
		
		model.addAttribute("empList",empList);
		
		return "emp/auth/login";
	}
	
	@ResponseBody
	@PostMapping("selectPw")
	public Map<String, Object> selectPw(@RequestBody EmpVO loginUser){
		Map<String, Object> jsonObj = new HashMap<>();
		
		log.info("=======>>>>>{}", loginUser);
		
		EmpVO realUser = dao.selectEmpByUserName(loginUser.getEmpNo());
		
		jsonObj.put("password", realUser.getEmpPw());
		
		return jsonObj;
	}
	
}
