package kr.or.ddit.emp.crm.cstmr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.crm.cstmr.service.EmpCRMCstmrService;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.MbrshGrdVO;
import kr.or.ddit.global.vo.MbrshSetleVO;
import kr.or.ddit.mybatis.mappers.MbrshMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping({"/emp/crm/cstmr", "/emp/crm/cstmr/*"})
public class EmpCRMCstmrRetrieveController {
	
	@Inject
	private MbrshMapper mbrshDao;
	
	@Inject
	private EmpCRMCstmrService service;
	
	@GetMapping
	public String cstmrListUI(
		Model model
	) {
		Map<String, String> mbrshCnt = mbrshDao.selectMbrshCountList();
		
		model.addAttribute("mbrshCnt", mbrshCnt);

		List<MbrshGrdVO> mbrshList = mbrshDao.selectMbrshList();
	 	
		model.addAttribute("mbrshList", mbrshList);

		return "emp/crm/cstmr/cstmrList";
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MberVO> listData(
			@RequestBody Map<String, String> jsonData 
		){
		
		List<MberVO> mberList = service.retrieveMemberList();
		
		
		return mberList;
	}
	
	@GetMapping(value = "/{cstNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getOne(
		@PathVariable String cstNo
	) {
		Map<String, Object> jsonObj  = new HashMap<>();
		
		MberVO mber = service.retrieveMember(cstNo);
		List<MbrshSetleVO> mbrshList = mbrshDao.selectUserMbershList(cstNo);
		
		jsonObj.put("mber", mber);
		jsonObj.put("mbrshList", mbrshList);
		
		log.info("mber : {]", mber);
		
		return jsonObj;
	}
	
}
