package kr.or.ddit.emp.crm.cstmr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.crm.cstmr.service.EmpCrmCstrmNoticeService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.MberNoticeVO;

@Controller
@RequestMapping("/emp/crm/cstmr")
public class EmpCRMCstmrNoticeController {

	@Inject
	private EmpCrmCstrmNoticeService service;

	/**
	 * 고객 공지사항 렌더링 컨트롤러
	 * @return
	 */
	@GetMapping("/noticeList.do")
	public String listUI() {
		return "emp/crm/cstmr/noticeList";
	}

	/**
	 * 수정을 위한 공지사항 단건 조회 컨트롤러
	 * 현재 로그인한 사용자와 수정할 공지사항의 작성자가 다르면 error를 내보냄
	 * @return
	 */
	@PostMapping("noticeOne")
	@ResponseBody
	public Map<String, Object> retrieveOne(
		@RequestBody Map<String, Object> data
	){
		Map<String, Object> jsonObj = new HashMap<>();
		String mberNtNo = data.get("mberNtNo").toString();
		
		MberNoticeVO notice = service.retrieveNotice(mberNtNo);
		jsonObj.put("notice", notice);
		
		return jsonObj;
	}
	/**
	 * 고객 공지사항 목록용(페이징처리) 컨트롤러
	 * @param model
	 * @param currentPage
	 * @param simpleCondition
	 */
	@PostMapping("/noticeList.do")
	public void listProcess(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int currentPage,
			@ModelAttribute("simpleCondition") SearchCondition simpleCondition) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);

		List<MberNoticeVO> noticeList = service.retrieveNoticeList(paging);

		model.addAttribute("noticeList", noticeList);

		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");

		String pagingHTML = renderer.renderPagination(paging);

		model.addAttribute("pagingHTML", pagingHTML);
	}

	/**
	 * 고객 공지사항 등록용 컨트롤러
	 * @param notice
	 * @return
	 */
	@PostMapping(value = "noticeInsert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> insertProcess(
		@RequestBody MberNoticeVO notice
	) {
		
		Map<String, Object> jsonObj = new HashMap<>();
		
		ServiceResult result = service.createNotice(notice);

		switch (result) {
		case OK:
			jsonObj.put("message", "ok");
			break;

		default:
			jsonObj.put("message", "error");
			break;
		}

		return jsonObj;
	}

	@PostMapping(value = "noticeUpdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> updateProcess(
		@RequestBody MberNoticeVO notice
	) {
		
		Map<String, Object> jsonObj = new HashMap<>();
		
		ServiceResult result = service.modifyNotice(notice);
		
		switch (result) {
		case OK:
			jsonObj.put("message", "ok");
			break;
			
		default:
			jsonObj.put("message", "error");
			break;
		}
		
		return jsonObj;
	}
	
	/**
	 * 고객 공지사항 삭제용 컨트롤러
	 * @param data : 삭제할 공지사항의 primary key
	 * @return
	 */
	@PostMapping("noticeDelete")
	@ResponseBody
	public Map<String, Object> deleteProcess(
		@RequestBody Map<String, Object> data
	) {
		
		Map<String, Object> jsonObj = new HashMap<>();		
		
		String mberNtNo = data.get("mberNtNo").toString();
		
		ServiceResult result = service.removeNotice(mberNtNo);
		
		switch (result) {
		case OK:
			jsonObj.put("message", "ok");
			break;

		default:
			jsonObj.put("message", "error");
			break;
		}

		return jsonObj;
	}
}
