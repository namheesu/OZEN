package kr.or.ddit.cstmr.intrcn.sbrsliar.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.cstmr.intrcn.sbrsliar.service.MberSbrsLiarService;
import kr.or.ddit.global.vo.SbrsVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/intrcn/sbrsLiar")
@Slf4j
public class CstmrSbrsLiarController {

	@Inject
	private MberSbrsLiarService service;
	
	@GetMapping
	public String getSbrsLiar(Model model) {
		
		List<SbrsVO> sbrsLiarList = service.sbrsLiarList();
		model.addAttribute("sbrsLiarList",sbrsLiarList);
		log.info("sbrsLiarListttt {}", sbrsLiarList);
		
		return "cstmr/intrcn/sbrsliar/sbrsLiarList";
	}
}
