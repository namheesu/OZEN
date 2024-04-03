package kr.or.ddit.global.common.error.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	@GetMapping("/403")
	public String error403UI() {
		
		return "error/403";
	}

	@GetMapping("/404")
	public String error404UI() {
		
		return "error/404";
	}

	@GetMapping("/500")
	public String error500UI() {
	
		return "error/500";
	}

}