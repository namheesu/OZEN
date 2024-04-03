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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pms.stay.service.EmpPmsStayChkoutListService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.vo.ChkoutVO;
import kr.or.ddit.global.vo.RsvtVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms/stay")
public class EmpPmsStayChkoutListControlelr {

	@Inject
	private EmpPmsStayChkoutListService service;
	
	@RequestMapping(value="/checkoutList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String staychkoutList(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition	
	) {
		
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		
		List<ChkoutVO> chkoutList = service.retreieveChkoutList(paging);
		model.addAttribute("chkoutList",chkoutList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/stay/checkOutList";
	}
	
	@RequestMapping(value="/chkoutList/modal", method = {RequestMethod.GET})
	public Map<String, Object> chkout(
		@RequestParam String chkinNo
		, Model model
	) {
		Map<String, Object> chkout = service.retreieveChkout(chkinNo);
		log.info("################chkout:{}",chkout);
		model.addAttribute("chkout{}",chkout);

		return chkout;
	}
	
	@RequestMapping(value="/chkoutList/updatemodal", method = {RequestMethod.PUT})
	@ResponseBody
	public ServiceResult rsvtupdate(
	    @RequestParam String chkinNo,
	    Model model
	) {
	    log.info("chkinNo{}", chkinNo);
	    ServiceResult result = service.modifyChkout(chkinNo);
	    return result;
	}
}
