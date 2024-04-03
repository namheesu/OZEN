package kr.or.ddit.cstmr.comm.faq.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.cstmr.comm.faq.service.CstmrFAQService;
import kr.or.ddit.global.vo.FaqVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("comm/FAQ")
@Slf4j
public class CstmrFAQController {
	
	@Inject
	private CstmrFAQService service;
	
	@GetMapping
	public String FAQPage(Model model) {
		
		List<FaqVO> faqList = service.selectFAQList();
		model.addAttribute("faqList", faqList);
		log.info("faqListModel {}", faqList);
		
		return "cstmr/comm/faq/faqList";
	}
}
