 package kr.or.ddit.emp.pms.rsvt.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pms.rsvt.service.EmpPmsRsvtListService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.RsvtVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/rsvt")
public class EmpPmsRsvtListController {
	
	@Inject
	private EmpPmsRsvtListService service;
		
	@RequestMapping(value="/rsvtList", method = {RequestMethod.GET})
	public String rsvtList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<RsvtVO> rsvtList = service.retrieveRsvtList(paging);
		model.addAttribute("rsvtList",rsvtList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/rsvt/rsvtList";
	}
	
	@RequestMapping(value="/rsvtList/modal", method = {RequestMethod.GET})
	public RsvtVO rsvt(
		@RequestParam String rsvtNo
		, Model model
	) {
		RsvtVO rsvt = service.retrieveRsvt(rsvtNo);
		log.info("################rsvt{}",rsvt);
		model.addAttribute("rsvt",rsvt);

		return rsvt;
	}
	
	@RequestMapping(value="/rsvtList/updatemodal", method = {RequestMethod.PUT})
	@ResponseBody
	public boolean rsvtupdate(
	    @RequestParam String rsvtNo,
	    Model model
	) {
	    log.info("######rsvtNO{}", rsvtNo);
	    boolean success = service.modifyRsvt(rsvtNo);
	    return success;
	}

}
