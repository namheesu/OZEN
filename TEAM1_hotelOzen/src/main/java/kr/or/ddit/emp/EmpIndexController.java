package kr.or.ddit.emp;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.hrm.dclz.service.HrmDclzTimeService;
import kr.or.ddit.emp.hrm.empnotice.service.HrmEmpNoticeSevice;
import kr.or.ddit.emp.pbl.schdl.service.EmpSchdlService;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.security.EmpUser;
import kr.or.ddit.global.vo.EmpNoticeVO;
import kr.or.ddit.global.vo.EmpSchdlVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.HrmDclzVO;
import kr.or.ddit.global.vo.HrmEmpVO;
import kr.or.ddit.mybatis.mappers.EmpFxtrsRqstMapper;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp")
@Slf4j
public class EmpIndexController {
	
	@Inject
	private HrmDclzTimeService service;
	
	@Inject
	private EmpSchdlService serviceSchdl;
	
	@Inject
	private HrmEmpNoticeSevice serviceNotice;
	
	@Inject
	private EmpFxtrsRqstMapper rqstDao;

//	@RequestMapping("/emp/index.do")
//	public String index() {
//		return "emp/index";
//	}
	
//	@RequestMapping("/emp/index.do")
//	public String index2(Model model, @EmpUser EmpVO authEmp) {
//		List<HrmEmpVO> dclzList = service.retrieveHrmEmpDclzList();
//		HrmDclzVO dclz = service.retrieveHrmEmpInfo(authEmp.getEmpNo());
//		model.addAttribute("dclz",dclz);
//		String today = service.dateFormat();
//		model.addAttribute("dclzList", dclzList);
//		model.addAttribute("authEmp", authEmp);
//		model.addAttribute("today", today);
//		
//		return "emp/index";
//	}
	
	@GetMapping
	public String schdlList(@EmpUser EmpVO empUser, Model model, Principal authPrincipal) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(1);
		paging.setSimpleCondition(null);
		
		log.info("empUserrr {}", empUser.getEmpNo());
		List<EmpSchdlVO> empSchdlList = serviceSchdl.retrieveSchdlList(empUser.getEmpNo());
		log.info("empSchdlListtt {}", empSchdlList);
		model.addAttribute("empSchdlList",empSchdlList);
		
		//근태조회 정보
		List<HrmEmpVO> dclzList = service.retrieveHrmEmpDclzList();
		HrmDclzVO dclz = service.retrieveHrmEmpInfo(empUser.getEmpNo());
		model.addAttribute("dclz",dclz);
		String today = service.dateFormat();
		model.addAttribute("dclzList", dclzList);
		model.addAttribute("authEmp", empUser);
		model.addAttribute("today", today);

		List<EmpNoticeVO> empNoticeList = serviceNotice.retrieveEmpNoticeList(paging);
		model.addAttribute("empNoticeList",empNoticeList);  
		
		Map<String, Integer> rqstMap = rqstDao.selectRqst(empUser.getEmpNo());          
		
		model.addAttribute("proceeding", rqstMap.get("PROCEEDING"));
		model.addAttribute("waiting", rqstMap.get("WAITING"));
		
		return "emp/index";
	}
	
	@PostMapping(value = "insertSchdl", produces = MediaType.APPLICATION_JSON_VALUE)
	public String schdlList(@RequestBody EmpSchdlVO schdlVo
				,@EmpUser EmpVO empUser, Principal authPrincipal) {
		
			schdlVo.setEmpNo(empUser.getEmpNo());
			log.info("schdlVo {}", schdlVo);
			
			int rowcnt = serviceSchdl.insertEmpSchdl(schdlVo);
			
			log.info("rowcnttt {}", rowcnt);
			
		return "emp/index";
	}

	
//  일정 삭제 메소드
	@PostMapping(value = "deleteSchdl", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteSchdl(@RequestBody String schdlTitle, @EmpUser EmpVO empUser
							, Principal principal) {
		
		EmpSchdlVO deleteVO = new EmpSchdlVO();
		deleteVO.setSchdlTitle(schdlTitle);
		deleteVO.setEmpNo(empUser.getEmpNo());
		serviceSchdl.deleteEmpSchdl(deleteVO);
		
		int deleteCnt = serviceSchdl.deleteEmpSchdl(deleteVO);
		log.info("delelteCntttt {}", deleteCnt);
		
		return "emp/index";
	}
}
