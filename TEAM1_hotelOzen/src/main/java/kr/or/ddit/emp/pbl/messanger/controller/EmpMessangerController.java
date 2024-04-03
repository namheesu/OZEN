package kr.or.ddit.emp.pbl.messanger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp/messanger")
public class EmpMessangerController {
	@GetMapping
	public String msngrList() {
		return "emp/pbl/messanger/messangerPage";
	}
}
