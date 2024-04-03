package kr.or.ddit.emp.pms.roomsvc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pms.roomsvc.service.EmpPmsRmServiceListService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.RmSvcOrderVO;
import kr.or.ddit.global.vo.RmserviceOrderVO;
import kr.or.ddit.global.vo.RmserviceVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/roomSvc")
public class RoomSvcListController {
	
	@Inject
	private EmpPmsRmServiceListService service;
	
	@RequestMapping(value="/roomSvcOrderList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String selectRoomList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		log.info("################################{}", paging);
		
		List<RmserviceOrderVO> rmSOrderList = service.retieveRmServiceOrderList(paging);
		model.addAttribute("rmSOrderList",rmSOrderList);
		
		log.info("################################rmSOrderList{}", rmSOrderList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/roomSvc/roomSvcOrderList";
	}
		
	@RequestMapping(value="/roomSvcRqstList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String roomSvcRqsList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		log.info("################################{}", paging);
		
		List<RmserviceOrderVO> rmSRqstList = service.retieveRmServiceRqstList(paging);
		model.addAttribute("rmSRqstList",rmSRqstList);
		
		log.info("################################rmSRqstList{}", rmSRqstList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);		
		
		return "emp/pms/roomSvc/roomSvcRqstList";
	}
	
	@RequestMapping(value="/rmSvc", method = { RequestMethod.POST})
	public List<RmserviceVO> roomSvcList(
		Model model
	) {	
		log.info("룸서비스리스트 조회 메서드들어옴.");
		List<RmserviceVO> rmSvcList = service.retieveRmServiceList();
		model.addAttribute("rmSvcList",rmSvcList);
		return rmSvcList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/rmSvcAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void rommSvcAdd(
		@RequestBody List<RmSvcOrderVO> orders
		, Model model
	) {	
		log.info("룸서비스리스트 조회 메서드들어옴.");
		
		for(RmSvcOrderVO order : orders) {
			log.info("룸서비스 코드 : {}, 수량 : {}, 체크인 번호 : {}", order.getRsCd(), order.getRsdDtlCnt(), order.getChkinNo());
        }
		
		service.createRmSvcList(orders);
		
	}
	

}
