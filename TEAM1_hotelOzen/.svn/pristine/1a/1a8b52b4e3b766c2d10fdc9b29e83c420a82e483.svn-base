package kr.or.ddit.emp.myinfo.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.myinfo.service.EmpMyInfoDclzService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.DclzVO;
import kr.or.ddit.global.vo.EmpVO;

@Controller
@RequestMapping("/emp/myInfo")
public class EmpMyInfoDclzController {

	@Inject
	private EmpMyInfoDclzService service;
	
	@RequestMapping(value = "/dclzList.do", method = {RequestMethod.POST, RequestMethod.GET})
	public void dclzListProcess(
		@EmpUser EmpVO emp
		, Model model
		, @RequestParam(value = "page", required = false, defaultValue = "1") int currentPage 
		, @ModelAttribute("simpleCondition") SearchCondition simCondition
	) {
		
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simCondition);
		
		List<DclzVO> dclzList = service.retrieveDlczList(emp.getEmpNo(), paging);
	
		model.addAttribute("dclzList", dclzList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
	
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("pagingHTML", pagingHTML);
		
	}
	
}
