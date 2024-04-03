package kr.or.ddit.emp.pbl.dclz.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pbl.dclz.service.YrycService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.HrmAnnualVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/hrm/dclz/yryc")
public class HrmYrycController {
	
	@Inject
	private YrycService service;

	@GetMapping
	public String yrycList(
			 @RequestParam(name="page", required =false, defaultValue="1") int currentPage
			, Model model
			, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo(5,5);
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<HrmAnnualVO> yrycList = service.retrieveAnnualList(paging);
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("yrycList", yrycList);
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "emp/hrm/dclz/yrycList";
	}
	
	/**
	 * 연차 상세 view
	 * @param anlLeaUseNo
	 * @param model
	 * @return
	 */
	@GetMapping("{anlLeaUseNo}")
	public HrmAnnualVO yrycDetail(@PathVariable("anlLeaUseNo") String anlLeaUseNo
			, Model model) {
		log.info("여기입니다.");
		HrmAnnualVO annual = service.retrieveAnnual(anlLeaUseNo);
		log.info("{}", annual);
		return annual;
	}
}
