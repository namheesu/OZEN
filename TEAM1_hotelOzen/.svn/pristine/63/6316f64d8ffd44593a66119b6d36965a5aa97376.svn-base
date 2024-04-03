package kr.or.ddit.emp.hrm.dclz.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.hrm.dclz.service.HrmDclzTimeService;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.HrmDclzVO;
import kr.or.ddit.global.vo.HrmEmpVO;

@Controller
@RequestMapping("/emp/hrm/dclz/dclzTime")
public class HrmDclzTimeController {
	
	@Inject
	private HrmDclzTimeService service;
	@GetMapping
	public String dclzTime(Model model, @EmpUser EmpVO authEmp) {
		List<HrmEmpVO> dclzList = service.retrieveHrmEmpDclzList();
		HrmDclzVO dclz = service.retrieveHrmEmpInfo(authEmp.getEmpNo());
		model.addAttribute("dclz",dclz);
		String today = service.dateFormat();
		model.addAttribute("dclzList", dclzList);
		model.addAttribute("authEmp", authEmp);
		model.addAttribute("today", today);
		return "emp/hrm/dclz/dclzTime";
		
	}

}
