package kr.or.ddit.emp.pbl.schdl.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pbl.schdl.service.EmpSchdlService;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.EmpSchdlVO;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("emp/pbl/schdl")
@Slf4j
public class EmpSchdlController {
	
	@Inject
	private EmpSchdlService serviceSchdl;
	
//	@ModelAttribute("empSchdl")
//	public EmpSchdlVO empSchdl() {
//		return new EmpSchdlVO();
//	}
	
	@GetMapping("insertSchdl")
	public String schdlList(@EmpUser EmpVO empUser, Model model, Principal authPrincipal) {
		log.info("empUserrr {}", empUser.getEmpNo());
		List<EmpSchdlVO> empSchdlList = serviceSchdl.retrieveSchdlList(empUser.getEmpNo());
		log.info("empSchdlListtt {}", empSchdlList);
		model.addAttribute("empSchdlList",empSchdlList);
		return "emp/pbl/schdl/schdlList";
	}
	
	@PostMapping(value = "insertSchdl", produces = MediaType.APPLICATION_JSON_VALUE)
	public String schdlList(@RequestBody EmpSchdlVO schdlVo
				,@EmpUser EmpVO empUser, Principal authPrincipal) {
		
			schdlVo.setEmpNo(empUser.getEmpNo());
			log.info("schdlVo {}", schdlVo);
			
			int rowcnt = serviceSchdl.insertEmpSchdl(schdlVo);
			
			log.info("rowcnttt {}", rowcnt);
			
		return "emp/pbl/schdl/schdlList";
	}

	
//  일정 삭제 메소드
	@PostMapping(value = "deleteSchdl", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteSchdl(@RequestBody String schdlTitle, @EmpUser EmpVO empUser
							, Principal principal) {
		
		EmpSchdlVO deleteVO = new EmpSchdlVO();
		deleteVO.setSchdlTitle(schdlTitle);
		deleteVO.setEmpNo(empUser.getEmpNo());
		serviceSchdl.deleteEmpSchdl(deleteVO);
		
		int deleteCnt = serviceSchdl.deleteEmpSchdl(deleteVO);
		log.info("delelteCntttt {}", deleteCnt);
		
		return "emp/pbl/schdl/schdlList";
	}
}
