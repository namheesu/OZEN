package kr.or.ddit.emp.pms.cctv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp/pms/cctv")
public class CctvController {
	@GetMapping("cctv.do")
	public String cctv() {
		return "emp/pms/cctv/cctv";
	}
	
	@GetMapping("cctvLive.do") 
	public String cctvLive() {
		return "emp/pms/cctv/cctvLive";
	}
}
