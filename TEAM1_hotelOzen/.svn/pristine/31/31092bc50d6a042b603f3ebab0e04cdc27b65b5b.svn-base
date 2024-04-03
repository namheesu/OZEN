package kr.or.ddit.emp.pos.acnt.refund.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pos.acnt.refund.service.EmpPosRefndService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.RefndVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pos/acnt/refnd")
public class EmpPosRefundController {
	
	@Inject
	private EmpPosRefndService service;
	
	@RequestMapping(value="/refndList", method = {RequestMethod.GET})
	public String refundList(
			@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
			, Model model
			, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
		) {
			PaginationInfo paging = new PaginationInfo();
			paging.setCurrentPage(currentPage);
			paging.setSimpleCondition(simpleCondition);
			
			List<RefndVO> refndList = service.retrieveRefndList(paging);
			model.addAttribute("refndList",refndList);
			
			PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
			String pagingHTML = renderer.renderPagination(paging);
			model.addAttribute("pagingHTML",pagingHTML);
			
			
		return "emp/pos/acnt/refund/refndList";
	}
	
	
}
