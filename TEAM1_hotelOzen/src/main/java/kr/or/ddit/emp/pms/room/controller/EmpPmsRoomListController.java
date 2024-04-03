package kr.or.ddit.emp.pms.room.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pms.room.service.EmpPmsRoomListService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.RoomVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/room")
public class EmpPmsRoomListController {
	
	@Inject
	private EmpPmsRoomListService service;
	
	@RequestMapping(value="/roomList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String selectRoomList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		log.info("################################{}", paging);
		
		Map<String, Object> roomListMap = service.retieveRoomList(paging);
		model.addAttribute("roomListMap",roomListMap);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/room/roomList";
	}
	
	@RequestMapping(value="/roomList/modal", method = {RequestMethod.GET})
	public RoomVO rsvt(
		@RequestParam String roomNo
		, Model model
	) {
		RoomVO room = service.retieveRoom(roomNo);
		log.info("################rsvt{}",room);
		model.addAttribute("room",room);

		return room;
	}
	
	@RequestMapping(value="/roomList/updatemodal", method = {RequestMethod.PUT})
	@ResponseBody
	public boolean rsvtupdate(
	    @RequestParam String roomNo,
	    Model model
	) {
	    log.info("######roomNo{}", roomNo);
	    boolean success = service.modifyRoom(roomNo);
	    log.info("######success{}", success);
	    return success;
	}
}
