package kr.or.ddit.cstmr.auth.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.cstmr.auth.service.MberAuthService;
import kr.or.ddit.global.vo.ClickWrapVO;

@Controller
@RequestMapping("auth/join")
public class CstmrAuthClickwrapController {
	
	@Inject
	MberAuthService service;
	
	@GetMapping("/terms.do")
	public String clickwrapPage(
		Model model
	) {
		List<ClickWrapVO> termList = service.retrieveTerms();
		
		model.addAttribute("termList", termList);
		return "cstmr/auth/clickwrap";
	}
}
