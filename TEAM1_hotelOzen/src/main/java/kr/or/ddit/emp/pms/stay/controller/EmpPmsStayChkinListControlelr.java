package kr.or.ddit.emp.pms.stay.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pms.rsvt.service.EmpPmsRsvtAddServcie;
import kr.or.ddit.emp.pms.stay.service.EmpPmsStayChkinListService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.validate.InsertGroup;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/stay")
public class EmpPmsStayChkinListControlelr {

	@Inject
	private EmpPmsStayChkinListService service;
	
	@Inject
	private EmpPmsRsvtAddServcie addService;
		
	@RequestMapping(value="/checkinList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String stayChkinList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		
		List<RsvtVO> chkinList = service.retrieveChkinList(paging);
		model.addAttribute("chkinList",chkinList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/stay/checkInList";
	}

	@RequestMapping(value="chkin", method= {RequestMethod.GET})
	public String chkin(
		@RequestParam String rsvtDtlNo 
		, Model model	
	) {
		RsvtDetailsVO rsvtDtl = service.retrieveRsvt(rsvtDtlNo);
		log.info("################rsvt{}",rsvtDtlNo);
		model.addAttribute("rsvtDtl",rsvtDtl);
		
		return "emp/pms/stay/checkIn";
	}
	
	@RequestMapping(value="/chkin.do", method= {RequestMethod.POST})
	public String chkinadd(
		@Validated(InsertGroup.class) @ModelAttribute("newChkin") ChkinVO newChkin
		, BindingResult errors
		, Model model
	) {
		log.info("POST 메서드 들어옴!!! newChkin : {}",newChkin);
				
		String logicaViewName = null;
		String message = null;
		
		log.info("errors: {}", errors);
		log.info("errors.hasErrors(): {}", errors.hasErrors());
		if (!errors.hasErrors()) {
			ServiceResult result = null;
			result = service.createChkin(newChkin);
			
			switch (result) {
			// 가입 성공 페이지로 이동
			case OK:
				logicaViewName = "redirect:/emp/pms/stay/nowStayList";
				break;

			default:
				message = "서버에 문제가 발생했습니다. 다시 시도해주세요";
				logicaViewName = "emp/pms/rsvt/rsvtadd";
				break;
			}
			log.info("message : {}", message);
			
			model.addAttribute("message", message);
		} else {
			logicaViewName = "emp/pms/rsvt/rsvtadd";
		}
		return logicaViewName;
		
	}
	
	
	/**
	 * roomType별 객실 조회
	 * @param roomTypeNm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/rsvtRoomList", method= {RequestMethod.GET})
	public Map<String, Object> rsvtRoomList(
		@RequestParam String roomTypeNm
		, Model model
	){
		Map<String, Object> rsvtRoomList = addService.retrieveRoomList(roomTypeNm);
		model.addAttribute("rsvtRoomList",rsvtRoomList);
		
		return rsvtRoomList;
	}
	
	/**
	 * 차량 유무 조회
	 * @param carNo
	 * @param model
	 */
	@RequestMapping(value="/carYN", method= {RequestMethod.POST})
	public void carYN(
		@RequestParam String carNo
		, Model model
	) {
		int carYN = addService.retrieveCarYN(carNo);
		model.addAttribute("carYN",carYN);
		
	}
}
