package kr.or.ddit.emp.crm.cstmr.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.emp.crm.cstmr.service.CrmMembshRecomService;
import kr.or.ddit.global.vo.RecomMbrshVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CrmMembshRecomController {
	
	@Inject
	private CrmMembshRecomService service;
	

	@GetMapping("/emp/crm/cstmr/membsh")
	public String cstmrMembsh(Model model) {
		String cstNo = "M1800004";
//		String cstNo = "M1900013";
		
		String mberNm = "홍길동";
		RecomMbrshVO vo = service.getRecomMbrsh(cstNo);
		
		model.addAttribute("vo", vo);
		model.addAttribute("mberNm", mberNm);
		log.info("vo : {}", vo);
		return "emp/crm/cstmr/cstmrMembsh";
	}

	
}
