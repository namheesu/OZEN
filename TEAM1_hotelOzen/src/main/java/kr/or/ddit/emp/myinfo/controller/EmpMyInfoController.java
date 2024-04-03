package kr.or.ddit.emp.myinfo.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.global.vo.CertVO;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;
import kr.or.ddit.emp.myinfo.cert.service.EmpMyinfoCertService;
import kr.or.ddit.global.security.EmpUser;

@Controller
@RequestMapping("/emp/myInfo")
public class EmpMyInfoController {
	
	@Inject
	private EmpMyinfoCertService service;
	
	@GetMapping("/mypage.do")
	public String mypage(
			@EmpUser EmpVO empUser
			, @ModelAttribute("empVO") EmpVO emp
			, Model model
		) {
		List<CertVO> recomCertList = service.retrieveRecomCertList(empUser.getEmpNo());
		List<CertVO> certList = service.retrieveCertList(empUser.getEmpNo());
		model.addAttribute("recomCertList", recomCertList);
		model.addAttribute("certList", certList);
		
		return "emp/myinfo/mypage";
	}
	
	@GetMapping("/updateInfo.do")
	public String updateInfo() {
		return "emp/myinfo/updateInfo";
	}
}
