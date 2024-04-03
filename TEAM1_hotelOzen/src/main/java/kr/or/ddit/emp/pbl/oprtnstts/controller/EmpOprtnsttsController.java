package kr.or.ddit.emp.pbl.oprtnstts.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pbl.oprtnstts.service.EmpOprtnsttsService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmpOprtnsttsController {
	
	@Inject
	private EmpOprtnsttsService serviceOprtn;
	

	@RequestMapping(value = "emp/pbl/oprtnstts/oprtnsttsList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String oprtnsttsList(
		@EmpUser EmpVO empUser
		, Model model
		, Principal principal
		, @RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	){
	
	// 비품 
		PaginationInfo fxPaging = new PaginationInfo();
		fxPaging.setCurrentPage(currentPage);
		fxPaging.setSimpleCondition(simpleCondition);
		
		List<FxtrsRqstVO> fxtrsList = serviceOprtn.fxtrsStatusList(empUser.getEmpNo(), fxPaging);
		model.addAttribute("fxtrsList",fxtrsList);
		
		PaginationRenderer fxRenderer = new BootstrapFormBasePaginationRenderer("#fxSearchForm");
		String fxPagingHtml = fxRenderer.renderPagination(fxPaging);
		model.addAttribute("fxPagingHtml", fxPagingHtml);
		
		log.info("fxPagingggg {}", fxPaging);
		
		
	// 연차
		PaginationInfo annPaging = new PaginationInfo();
		annPaging.setCurrentPage(currentPage);
		annPaging.setSimpleCondition(simpleCondition);
		
		List<AnnualVO> annualList = serviceOprtn.annualStatusList(empUser.getEmpNo(), annPaging);
		model.addAttribute("annualList",annualList);
		
		PaginationRenderer annRenderer = new BootstrapFormBasePaginationRenderer("#annSearchForm");
		String annPagingHtml = annRenderer.renderPagination(annPaging);
		model.addAttribute("annPagingHtml", annPagingHtml);
		
		log.info("annPagingggg {}", annPaging);
		
		return "emp/pbl/oprtnstts/oprtnsttsList";
	}
	
}

	

