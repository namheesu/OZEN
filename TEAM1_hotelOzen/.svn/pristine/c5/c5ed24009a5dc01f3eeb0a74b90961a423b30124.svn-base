package kr.or.ddit.emp.pbl.dclz.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pbl.dclz.service.YrycService;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.HrmAnnualVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pbl/dclz/yryc")
public class EmpYrycController {
	
	@Inject
	private YrycService service;
	
	@PostMapping(value = "insert.do", produces=MediaType.APPLICATION_JSON_VALUE)
	public void insertYryc(@ModelAttribute HrmAnnualVO hrmAnnualVO
			, @EmpUser EmpVO emp
			, Model model
			, BindingResult result) {
		log.info("왔니....???{}", hrmAnnualVO);
		hrmAnnualVO.setEmpNo(emp.getEmpNo());
		service.createAnnual(hrmAnnualVO);
		model.addAttribute("message", "컨트롤러에서 온 메시지");
		//return "emp/hrm/dclz/yrycForm";
	}
	
	/**
	 * 연차 신청 form
	 * @return
	 */
	@GetMapping
	public String viewYryc(@EmpUser EmpVO emp
			, Model model) {

		 HrmAnnualVO empRqVO = service.retrieveReceiver(emp.getEmpNo());
		 model.addAttribute("empRqVO", empRqVO);
		 
		return "emp/hrm/dclz/yrycView";
	}
	
	/**
	 * 연차 상세 view
	 * @param anlLeaUseNo
	 * @param model
	 * @return
	 */
	@GetMapping("{anlLeaUseNo}")
	public String yrycDetail(@PathVariable("anlLeaUseNo") String anlLeaUseNo
			, Model model) {
		log.info("여기입니다.");
		HrmAnnualVO annual = service.retrieveAnnual(anlLeaUseNo);
		log.info("{}", annual);
		
		model.addAttribute("annual", annual);
		return "emp/pbl/yryc/yrycView";
	}
	
	
	@ResponseBody
	@PostMapping(value ="{anlLeaUseNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String yrycUpdate(@RequestBody HrmAnnualVO annual
			 , Model model) {
		log.info("반려 또는 승인할 예정.");
		log.info("확인 {}",annual);
		
		service.modifyAnnualOfReceiver(annual);
		return "emp/pbl/oprtnstts/oprtnsttsList.do";
	}

}
