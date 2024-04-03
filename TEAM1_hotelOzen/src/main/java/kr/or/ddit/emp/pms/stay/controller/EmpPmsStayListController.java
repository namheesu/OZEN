package kr.or.ddit.emp.pms.stay.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pms.stay.service.EmpPmsStayListService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.ChkoutVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/stay")
public class EmpPmsStayListController {

	@Inject
	private EmpPmsStayListService service;
	
	@RequestMapping(value="/stayList", method=RequestMethod.GET)
	public String stayList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<ChkoutVO> stayList = service.retreieveStayList(paging);
		model.addAttribute("stayList",stayList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/stay/stayList";
	}
	
	@RequestMapping(value="/stayList/modal", method = {RequestMethod.GET})
	public Map<String, Object> rsvt(
		@RequestParam String chkinNo
		, Model model
	) {
		model.addAttribute("chkinNo", chkinNo);
		Map<String, Object> stay = service.retreieveStay(chkinNo);
		log.info("################stay{}",stay);
		model.addAttribute("stay",stay);

		return stay;
	}
}
