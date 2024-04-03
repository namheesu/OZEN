package kr.or.ddit.emp.pos.sanctn.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pos.sanctn.service.EmpPosSanctnService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.FxtrsPrchsSttstVO;

@Controller
@RequestMapping("/emp/pos/acnt/sanctn")
public class EmpPosSanctnController {

	@Inject
	private EmpPosSanctnService service;
	
	@RequestMapping(value="/sanctnList", method= {RequestMethod.GET})
	public String sanctnList(
		@RequestParam(value="page", required=false, defaultValue = "1")	int currentPage
		, Model model
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
		) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<FxtrsPrchsSttstVO> sanctnList = service.retrieveSanctnList(paging);
		model.addAttribute("sanctnList", sanctnList);
//		log.info("@@@@@:{}",sanctnList);
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pos/sanctn/sanctnList";
	}
	
//	@GetMapping("{rqstCd}")
//	public String sanctnView(
//		@PathVariable String rqstCd	
//		) {
//		return "emp/pos/sanctn/sanctnView";
//	}
}
