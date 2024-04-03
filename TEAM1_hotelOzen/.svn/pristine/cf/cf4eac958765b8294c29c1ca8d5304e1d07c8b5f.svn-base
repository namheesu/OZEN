package kr.or.ddit.cstmr.comm.notice.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.cstmr.comm.notice.service.MberNoticeService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.MberNoticeVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("comm/notice")
@Slf4j
public class MberNoticeController {
	
	@Inject
	private MberNoticeService service;
	
	@RequestMapping(value="/noticeList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String noticeList(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
						, Model model, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		
		
		List<MberNoticeVO> memNoticeList = service.retrieveNoticeList(paging);
		model.addAttribute("memNoticeList", memNoticeList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML", pagingHTML);
		
		log.info("paginggggg {}", paging);
		
		return "cstmr/comm/notice/noticeList";
	}
	
	@GetMapping("/noticeView.do/{mberNtNo}")
	public String noticeView(@PathVariable String mberNtNo, Model model) {
		MberNoticeVO memNoti = service.retrieveNoticeView(mberNtNo);
		model.addAttribute("memNoti",memNoti);
		log.info("공지사항번호 {}", mberNtNo);
		
		service.noticeCount(mberNtNo);
		
		return "cstmr/comm/notice/noticeView";
	}
	
}
