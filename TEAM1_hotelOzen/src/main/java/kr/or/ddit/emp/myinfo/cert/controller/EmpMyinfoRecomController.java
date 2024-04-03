package kr.or.ddit.emp.myinfo.cert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/myInfo")
public class EmpMyinfoRecomController {
	
	@GetMapping("/recomCert.do")
	public String recomUI() {
		return "emp/myinfo/recomCert";
	}
	
	
}
