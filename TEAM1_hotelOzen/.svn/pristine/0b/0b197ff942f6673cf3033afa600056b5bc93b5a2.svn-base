package kr.or.ddit.emp.hrm.empnotice.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.emp.hrm.empnotice.service.HrmEmpNoticeSevice;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.common.paging.SearchCondition;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.AtchmnflEmpNoticeVO;
import kr.or.ddit.global.vo.EmpNoticeVO;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 직원 공지.
 * @author 박지원
 *
 */
@Controller
@Slf4j
public class HrmEmpNoticeController {
	
	
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
	
	/**
	 * 첨부파일을 다운로드하는 메소드
	 * 
	 * @param attNo 첨부파일 번호
	 * @return ResponseEntity<Resource> 첨부파일 정보를 반환.
	 * @throws IOException
	 */
	@GetMapping("/emp/empnotice/download/{attNo}")
	public ResponseEntity<Resource> download(@PathVariable int attNo) throws IOException {
		AtchmnflEmpNoticeVO atc = service.downloadAtch(attNo);
		String saveName = atc.getAtcEmpNtUuid();
		Resource saveFile = empNtPath.createRelative(saveName);
		
		if(!saveFile.exists())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s 파일을 찾을 수 없음.", atc.getAtcEmpFileNm()));
		
		HttpHeaders headers = new HttpHeaders();
//		headers.setContentLength(atc.getAttFileSize());
		
		ContentDisposition disposition = ContentDisposition.attachment()
										.filename(atc.getAtcEmpFileNm(), Charset.forName("UTF-8"))
										.build();
		headers.setContentDisposition(disposition);
		return ResponseEntity.ok()
				.headers(headers)
				.body(saveFile);
	}
	
	@DeleteMapping("/emp/empnotice/atc/{attNo}")
	@ResponseBody
	public Map<String, Object> deleteAtc(@PathVariable int attNo) {
		service.removeAtch(attNo);
		return Collections.singletonMap("success", true);
	}
	
	
	@GetMapping(value = "/emp/hrm/empnotice/insert")
	public String form(Model model,  @EmpUser EmpVO authEmp) {
		
		model.addAttribute("authEmp", authEmp);
		return "emp/hrm/empnotice/empNoticeForm";
	}
	
	
	//새 직원 공지 등록
	@PostMapping(value = "/emp/hrm/empnotice")
	public String insert(
			@ModelAttribute(MODELNAME) EmpNoticeVO cmdObj 
			, Principal principal
			, @EmpUser EmpVO authEmp
			) {
		
		log.info("인서트할 값들.....{}", cmdObj);
		String newEmpNtNo = service.createEmpNotice(cmdObj);
		//log.info("newEmpNtNo : {}", newEmpNtNo );
		return "emp/hrm/empnotice/"+newEmpNtNo;
	}
	
	@GetMapping("/emp/hrm/empnotice/update")
	public String updateform(Model model, @RequestParam("empNtNo") String empNtNo) {
		log.info("수정해야할 공지의 pk :{}", empNtNo);
		EmpNoticeVO empNt = service.retrieveEmpNotice(empNtNo);
		model.addAttribute("empNt", empNt);
		return "emp/hrm/empnotice/empNoticeEdit";
	}
	
	@PostMapping("/emp/hrm/empnotice/{empNtNo}/update")
	public String update(@PathVariable("empNtNo") String empNtNo
			, @ModelAttribute(MODELNAME) EmpNoticeVO cmdObj 
			, Model model) {
	
		cmdObj.setEmpNtNo(empNtNo);
		service.modifyEmpNotice(cmdObj);
		model.addAttribute("url", "/emp/empnotice/"+ empNtNo);
		return "/emp/hrm/empnotice/"+ empNtNo;
	}
	
	
	@GetMapping(value="/emp/hrm/empnotice")
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
	
	@RequestMapping(value  = "/emp/hrm/empnotice/{empNtNo}", method = RequestMethod.DELETE)
	public String delete(
			@ModelAttribute EmpNoticeVO cmdObj
			, Principal principal
			, @EmpUser EmpVO authEmp
	) {
		
		service.removeEmpNotice(cmdObj);
		return "emp/hrm/empnotice/empNoticeList";
	}
	
	
	@GetMapping("/emp/empnotice/{empNtNo}")
	public String view(@PathVariable String empNtNo, Model model) {
		EmpNoticeVO empNt = service.retrieveEmpNotice(empNtNo);
		
		model.addAttribute("empNt", empNt);
		log.info("직원 공지 코드 번호 : {}", empNtNo);
		log.info("직원 공지: {}의 내용", empNt);
		return "emp/hrm/empnotice/empNoticeView";
	}
	
	
}
