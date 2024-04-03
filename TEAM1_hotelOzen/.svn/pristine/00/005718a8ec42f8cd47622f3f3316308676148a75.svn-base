package kr.or.ddit.emp.pms.parking.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pms.parking.service.EmpPmsParkingService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.ParkingAreaVO;
import kr.or.ddit.global.vo.ParkingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/parking")
public class ParkingController {
	
	@Inject
	private EmpPmsParkingService service;
	
	@RequestMapping(value="/parking.do", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public String parking(
		Model model	
	) {
		List<ParkingAreaVO> parkingAreaList = service.retrieveParkingAreaList();
		model.addAttribute("parkingAreaList", parkingAreaList);
		
		log.info("parkingAreaList:{}",parkingAreaList);
		
		return "emp/pms/parking/parking";
	}
	
	@RequestMapping(value="/carList.do", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public String carList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition	
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<ParkingVO> carList = service.retrieveParkingList(paging);
		model.addAttribute("carList",carList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/parking/carList";
	}
}
