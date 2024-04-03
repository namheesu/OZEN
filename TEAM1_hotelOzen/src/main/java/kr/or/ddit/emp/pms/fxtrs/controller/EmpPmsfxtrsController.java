package kr.or.ddit.emp.pms.fxtrs.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pms.fxtrs.service.EmpPmsFxtrsService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.FxtrsVO;
import kr.or.ddit.global.vo.RsvtVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("emp/pms/fxtrs")
public class EmpPmsfxtrsController {
	
	@Inject
	private EmpPmsFxtrsService service;
	
	@RequestMapping(value="/presList.do", 
			method = {RequestMethod.GET, RequestMethod.POST}) //현재 비품 수량 페이지
	public String fxtrs(
		Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition	
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setSimpleCondition(simpleCondition);
		
		List<FxtrsVO> fxtrsList = service.retrieveFxtrsList();
		model.addAttribute("fxtrsList",fxtrsList);
		
		log.info("#################{}", fxtrsList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/fxtrs/presList";
	}
	

}
