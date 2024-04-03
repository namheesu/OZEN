package kr.or.ddit.emp.hrm.empnotice.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.emp.hrm.empnotice.service.HrmEmpNoticeSevice;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.AtchmnflEmpNoticeVO;
import kr.or.ddit.global.vo.EmpNoticeVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PblEmpNoticeController {
	
	public static final String MODELNAME = "empNotice";

	/**
	 * 직원 공지 서비스 객체 인스턴스 주입
	 */
	@Inject
	private HrmEmpNoticeSevice service;
	
	/**
	 * 스프링 프레임워크 프로퍼티 정보를 주입해서 가지고 옴.
	 */
	@Value("#{appInfo.empNtPath}")
	private Resource empNtPath;
	
	
	
//	@GetMapping("view")
//	public String viewPblEmpNotice() {
//		return "emp/hrm/empnotice/empNoticeView";
//	}
	
	
	@GetMapping("/emp/pbl/empnotice")
	public String list(
//			@ModelAttribute("paging") PaginationInfo paging
			 @RequestParam(name="page", required =false, defaultValue="1") int currentPage
			, Model model
			, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo(5,5);
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		List<EmpNoticeVO> empNoticeList = service.retrieveEmpNoticeList(paging);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		
		String pagingHTML = renderer.renderPagination(paging);
		
		
		log.info("simpleCondition :=====================================================>>>>>>>>>>. {}",simpleCondition );
		
		model.addAttribute("empNoticeList", empNoticeList);
		model.addAttribute("pagingHTML", pagingHTML);
//		model.addAttribute("condition", detailCondition);
		
		return "emp/hrm/empnotice/empNoticeList";
	}

}
