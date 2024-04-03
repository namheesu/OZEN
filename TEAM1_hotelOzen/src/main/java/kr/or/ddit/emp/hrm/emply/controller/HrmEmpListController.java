package kr.or.ddit.emp.hrm.emply.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.hrm.emply.service.HrmEmpService;
import kr.or.ddit.global.vo.HrmEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pbl/emply")
public class HrmEmpListController {
	
	@Inject
	private HrmEmpService service;
	
	@GetMapping
	public String List(Model model) {
		List<HrmEmpVO> hrmEmpList = service.retrieveHrmEmpList();
		List<HrmEmpVO> hrmEmpDclzList = service.retrieveHrmEmpDclzList();
		List<HrmEmpVO> hrmEmpRtrmList = service.retrieveHrmEmpRtrmList();
		model.addAttribute("hrmEmpList", hrmEmpList);
		model.addAttribute("hrmEmpDclzList", hrmEmpDclzList);
		model.addAttribute("hrmEmpRtrmList", hrmEmpRtrmList);
		
		log.info("hrmEmpDclzList: {}", hrmEmpDclzList);
		log.info("hrmEmpRtrmList: {}", hrmEmpRtrmList);
		
		return "emp/hrm/emply/empList";
	}
	
	@GetMapping("view")
	public String View() {
		return "emp/hrm/emply/empView";
	}
	

}
