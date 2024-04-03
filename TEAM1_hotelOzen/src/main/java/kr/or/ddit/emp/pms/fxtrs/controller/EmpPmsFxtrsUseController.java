package kr.or.ddit.emp.pms.fxtrs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pms.fxtrs.service.EmpPmsFxtrsUseService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.security.EmpVOWrapper;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.FxtrsClsCdVO;
import kr.or.ddit.global.vo.FxtrsUseVO;
import kr.or.ddit.global.vo.FxtrsVO;
import kr.or.ddit.global.vo.RoomVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("emp/pms/fxtrs")
public class EmpPmsFxtrsUseController {

	@Inject
	private EmpPmsFxtrsUseService service;
	 
	@RequestMapping(value="/useList.do", 
			method = {RequestMethod.GET, RequestMethod.POST}) //비품 사용 내역 리스트
	public String fxtrsUse(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition	
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		log.info("#################{}", paging);
		
		List<FxtrsUseVO> fxtrsUseList = service.retrieveFxtrsUseList(paging);
		model.addAttribute("fxtrsUseList",fxtrsUseList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/fxtrs/useList";
	}
	
	@RequestMapping(value="/useList/modal", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> rsvtupdate(
	    @RequestParam String fxuseNo,
	    Model model
	) {
		log.info("############{}", fxuseNo);
		Map<String, Object> fxtrs = service.retrieveFxtrs(fxuseNo);
	    return fxtrs;
	}
	
	@GetMapping("useListadd.do")
	public String fxtrsUseadd(
		Authentication authentication
		, Model model
	) {
		EmpVO emp = ((EmpVOWrapper) authentication.getPrincipal()).getEmpUser();
		String empNm = emp.getEmpNm();
		String empNo = emp.getEmpNo();
		model.addAttribute("empNm", empNm);
		model.addAttribute("empNo", empNo);
		
		String fxUseNo = service.retrieveFxUseNo();
		model.addAttribute("fxUseNo", fxUseNo);
		
		List<FxtrsClsCdVO> fxtrsCdList = service.retrieveFxtrsCd();
		model.addAttribute("fxtrsCdList", fxtrsCdList);
			
		return "emp/pms/fxtrs/useListadd";
	}
	
	@RequestMapping(value="/floorList", method= {RequestMethod.GET})
	public List<RoomVO> floorList(
		@RequestParam String floor
		, Model model
	){
		
		List<RoomVO> floorList = service.retrievefloorList(floor);
		model.addAttribute("floorList",floorList);
		
		return floorList;
	}
	
	@RequestMapping(value="/fxtrsNmList", method= {RequestMethod.GET})
	public List<FxtrsVO> fxtrsNmList(
			@RequestParam String fxtrsCd
			, Model model
			){
		
		List<FxtrsVO> fxtrsNmList = service.retrieveFxtrsNmList(fxtrsCd);
		model.addAttribute("fxtrsNmList",fxtrsNmList);
		
		return fxtrsNmList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/fxtrsUse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String rommSvcAdd(
		@RequestBody Map<String, Object> jsonData
		, BindingResult errors
		, Model model
		, HttpServletRequest req
			) {	
		log.info("비품신청 메서드들어옴.");
		
		String contextPath = req.getContextPath();
		
		Map<String, Object> fxData = new HashMap<>();
		String logicaViewName = null;
		String message = null;
		
		log.info("errors: {}", errors);
		log.info("errors.hasErrors(): {}", errors.hasErrors());
		if (!errors.hasErrors()) {
			ServiceResult result = null;
			
			List<Map<String, Object>> fxtrsDataList = (List<Map<String, Object>>) jsonData.get("fxtrsData");
			
			for (Map<String, Object> fxtrsData : fxtrsDataList) {
				String fxuseNo = (String) fxtrsData.get("fxuseNo");
		        fxData.put("fxuseNo", fxuseNo);
		        String rmNo = (String) fxtrsData.get("rmNo");
		        fxData.put("rmNo", rmNo);
		        String empNo = (String) fxtrsData.get("empNo");
		        fxData.put("empNo", empNo);
		        String fxuseYmd = (String) fxtrsData.get("fxuseYmd");
		        fxData.put("fxuseYmd", fxuseYmd);
		        
		        log.info("#########fxuseNo:{}, rmNo:{}, empNo:{}, fxuseYmd:{} "
		        		,fxuseNo, rmNo, empNo,fxuseYmd);
		        
		        
			}
			
			result = service.createFxtrsUse(fxData);
			
		    for (Map<String, Object> fxtrsData : fxtrsDataList) {
		        
		    	String fxclsNm = (String) fxtrsData.get("fxclsNm");
		        fxData.put("fxclsNm", fxclsNm);
		        String fxCd = (String) fxtrsData.get("fxCd");
		        fxData.put("fxCd", fxCd);
		        String fxNm = (String) fxtrsData.get("fxNm");
		        fxData.put("fxNm", fxNm);
		        String fxudCnt = (String) fxtrsData.get("fxudCnt");
		        fxData.put("fxudCnt", fxudCnt);
		        
		        result = service.createFxtrsUseDtl(fxData);
		       		        
		        log.info("#########fxclsNm: {}, fxCd: {}, fxNm: {}, fxudCnt: {}"
		        		, fxclsNm, fxCd, fxNm, fxudCnt);
		        
		    }
			
		    log.info("result:{}", result);
		    
			switch (result) {
			case OK:
				logicaViewName =  contextPath+"/emp/pms/fxtrs/useList.do";
				break;

			default:
				message = "서버에 문제가 발생했습니다. 다시 시도해주세요";
				logicaViewName = contextPath + "/emp/pms/fxtrs/useListadd.do";
				break;
			}
			log.info("message : {}", message);
			
			model.addAttribute("message", message);
		} else {
			logicaViewName = contextPath + "/emp/pms/fxtrs/useListadd.do";
		}
		return logicaViewName;
		
		
	}
}
