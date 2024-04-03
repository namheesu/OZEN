package kr.or.ddit.emp.pms.fxtrs.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.springframework.web.client.RestTemplate;

import kr.or.ddit.emp.pms.fxtrs.service.EmpPmsFxtrsRqstService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.security.EmpVOWrapper;
import kr.or.ddit.global.vo.EmpAlramVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import kr.or.ddit.global.vo.FxtrsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("emp/pms/fxtrs")
public class EmpPmsFxrsRqstController {
	
	@Inject
	private EmpPmsFxtrsRqstService service;
	
	@RequestMapping(value="/rqstList.do", 
			method = {RequestMethod.GET, RequestMethod.POST}) //발주 신청 리스트 조회페이지
	public String fxtrsOrder(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model	
		, @ModelAttribute("simpleCondition") SearchCondition simpleCondition	
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		log.info("#################{}", paging);
		
		Map<String, Object> fxtrsrqstList = service.retrieveFxtrsRqstList(paging);
		model.addAttribute("fxtrsrqstList",fxtrsrqstList);
		
		log.info("#################{}", fxtrsrqstList);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML",pagingHTML);
		
		return "emp/pms/fxtrs/rqstList";
	}
	
	@GetMapping("rqstListadd.do")
	public String fxtrsUseadd(
		Authentication authentication
		, Model model
	) {
		EmpVO emp = ((EmpVOWrapper) authentication.getPrincipal()).getEmpUser();
		String empNm = emp.getEmpNm();
		String empNo = emp.getEmpNo();
		model.addAttribute("empNm", empNm);
		model.addAttribute("empNo", empNo);
		
		String rqstNo = service.retrieveRqstNo();
		model.addAttribute("rqstNo",rqstNo);
		
		return "emp/pms/fxtrs/rqstListadd";
	}
	
	@RequestMapping(value="/rqstListadd.do", method = RequestMethod.POST) 
	public void fxtrsUseFxtrs(
		@RequestParam("checkedItems") String checkedItems
		,Model model	
	) {
		log.info("메소드 들어옴");
		
		Map<String, Object> fxCd = new HashMap<>();
		
		String[] checkedItemsArray = checkedItems.split("','");

        // 각 항목에서 따옴표 제거하여 정리된 배열 생성
        List<FxtrsVO> fxtrsList = Arrays.stream(checkedItemsArray)
                                         .map(item -> item.replaceAll("'", "")) // 따옴표 제거
                                         .map(item -> {
                                             fxCd.put(item, item);
                                             return service.retrieveFxtrs(item);
                                         })
                                         .collect(Collectors.toList());

        // 결과를 모델에 추가
        model.addAttribute("fxtrsList", fxtrsList);
        
        EmpVO fxRqstEmp = service.retrieveRqstEmp();
        model.addAttribute("fxRqstEmp",fxRqstEmp);

        log.info("model:{}",model);
        
	}
	
	@ResponseBody
	@RequestMapping(value = "/fxtrsRqst", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String fxtrsRqst(
		@RequestBody Map<String, Object> jsonData
		, BindingResult errors
		, Model model
		, @EmpUser EmpVO empUser
		, HttpServletRequest req
	) {	
		log.info("요청서작성 메서드들어옴.");
		
		String contextPath = req.getContextPath();
		
		Map<String, Object> fxData = new HashMap<>();
//		EmpAlramVO empAlram = new EmpAlramVO();
		String logicaViewName = null;
		String message = null;
		
		
		if (!errors.hasErrors()) {
			ServiceResult result = null;
			
			List<Map<String, Object>> fxtrsDataList = (List<Map<String, Object>>) jsonData.get("fxtrsData");
			
			for (Map<String, Object> fxtrsData : fxtrsDataList) {
				String rqstNo = (String) fxtrsData.get("rqstNo");
		        fxData.put("rqstNo", rqstNo);
//		        empAlram.setRqstNo(rqstNo);
		        String empNo = (String) fxtrsData.get("empNo"); 
		        fxData.put("empNo", empNo);
//		        empAlram.setEmpNo(empNo);
		        String fxTotalAmnt = (String) fxtrsData.get("fxTotalAmnt");
		        fxData.put("fxTotalAmnt", fxTotalAmnt);
		        String empRqNo = (String) fxtrsData.get("empRqNo");
		        fxData.put("empRqNo", empRqNo);
		        String ymd = (String) fxtrsData.get("ymd");
		        fxData.put("ymd", ymd);
		        
		        log.info("#########rqstNo:{}, empNo:{}, fxTotalAmnt:{}, empRqNo:{}, ymd:{} "
		        		,rqstNo, empNo, fxTotalAmnt,empRqNo, ymd);
			}
			result = service.createFxtrsRqst(fxData);
//			int rowcnt = service.createEmpAlram(empAlram);
			
			for (Map<String, Object> fxtrsData : fxtrsDataList) {
		        
		        String fxCd = (String) fxtrsData.get("fxCd");
		        fxData.put("fxCd", fxCd);
		        String fxudCnt = (String) fxtrsData.get("fxudCnt");
		        fxData.put("fxudCnt", fxudCnt);
		        String totalAmnt = (String) fxtrsData.get("totalAmnt");
		        fxData.put("totalAmnt", totalAmnt);
		        
		        log.info("#########fxCd: {}, fxudCnt: {}, totalAmnt: {}"
		        		, fxCd, fxudCnt, totalAmnt);
		        
		        result = service.createFxtrsRqstDtl(fxData);
			}
			
			
		    log.info("result:{}", result);
//		    log.info("rowcntttttt {}", rowcnt);
		    
		    
			switch (result) {
			// 가입 성공 페이지로 이동
			case OK:
				logicaViewName =  contextPath+ "/emp/pms/fxtrs/rqstList.do";
				break;

			default:
				message = "서버에 문제가 발생했습니다. 다시 시도해주세요";
				logicaViewName = contextPath+"/emp/pms/fxtrs/presList.do";
				break;
			}
			log.info("message : {}", message);
			
			model.addAttribute("message", message);
		} else {
			logicaViewName =  contextPath + "/emp/pms/fxtrs/presList.do";
		}
		return logicaViewName;
	}
	
	@RequestMapping(value="rqstView", method= {RequestMethod.GET})
	public String fxtrsUseView(
		@RequestParam String fxtrsRqstNo
		, Authentication authentication
		, Model model
	) {
		EmpVO emp = ((EmpVOWrapper) authentication.getPrincipal()).getEmpUser();
		String empNm = emp.getEmpNm();
		String empNo = emp.getEmpNo();
		model.addAttribute("empNm", empNm);
		model.addAttribute("empNo", empNo);
		
		
		Map<String, Object> fxtrs =  service.retrieveFxtrsRqst(fxtrsRqstNo);
		model.addAttribute("fxtrs",fxtrs);
		
		log.info("##################model:{}",model);
		return "emp/pms/fxtrs/rqstView";
	}
	
	@ResponseBody
	@RequestMapping(value = "/fxtrsUseApproval", method = RequestMethod.POST)
	public String fxtrsApprovalUpdate(
		@RequestParam String fxRqstNo
	) {
		log.info("승인 들어옴");
		service.updateFxtrsApproval(fxRqstNo);
		return "./rqstList.do";
	}
	
	@ResponseBody
	@RequestMapping(value = "/fxtrsUseRefusal", method = RequestMethod.POST)
	public String fxtrsRecusalUpdate(
		@RequestParam String fxRqstNo
	) {
		log.info("거부 들어옴");
		service.updateFxtrsRecusal(fxRqstNo);
		return "./rqstList.do";
	}
	
	@ResponseBody
	@RequestMapping(value = "/fxtrsPur", method = RequestMethod.POST)
	public String fxtrsPurUpdate(
			@RequestParam String fxRqstNo
			, @RequestBody String cd
		) {
		FxtrsRqstVO fxtrsRqstVO = new FxtrsRqstVO();
		fxtrsRqstVO.setRqstNo(fxRqstNo);
		
		// 구매요청 상태 변경
		if(cd.equals("Y")) {
			fxtrsRqstVO.setRqstSe("구매완료");
			service.updateFxtrsPurOk(fxtrsRqstVO);
			
		}else if(cd.equals("N")) {
			fxtrsRqstVO.setRqstSe("반려");
			service.updateFxtrsPurDec(fxtrsRqstVO);
		}
		
		return "./oprtnsttsList.do";
	}
}
