package kr.or.ddit.cstmr.intrcn.mbrsh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.cstmr.intrcn.mbrsh.service.CstmrMbrshService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.MberUser;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.MbrshGrdVO;
import kr.or.ddit.global.vo.MbrshSetleVO;
import kr.or.ddit.global.vo.SetleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mbrsh")
public class CstmrMbrshController {
	
	MbrshSetleVO setleVO;
	
	@Inject
	CstmrMbrshService service;
	
	@GetMapping
	public String mbrshList(
		Model model
	) {
		
	    List<MbrshGrdVO> mbrshList = service.retrieveMbrshList();
		
	    model.addAttribute("mbrshList", mbrshList);
	    
		return "cstmr/intrcn/mbrsh/mbrshList";
	}
	
	
	@GetMapping("{mbsGrdCd}")
	public String mbrshView(
		@PathVariable String mbsGrdCd
		, Model model
	) {
		
		log.info("=========>>>>>>>>>>>>>> {}", mbsGrdCd);
		
		List<MbrshGrdVO> mbsGrdList = service.retrieveMbrsh(mbsGrdCd);
		
		model.addAttribute("mbsGrdCd", mbsGrdCd);
		model.addAttribute("mbsGrdList", mbsGrdList);
		
		return "cstmr/intrcn/mbrsh/mbrshView";
	}
	
	@GetMapping("{mbrGrdCd}/detail")
	@ResponseBody
	public Map<String, Object> mbrshDetailView(
		@PathVariable String mbrGrdCd
	){
		log.info("mbrGrdCd : {}", mbrGrdCd);
		MbrshGrdVO mbrsh = service.retrieveOneMbrsh(mbrGrdCd);
		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("mbrsh", mbrsh);
		return jsonData;
	}
	
	@GetMapping("subscribe/{mbsGrdCd}")
	public String mbrshsubscribe(
		@PathVariable String mbsGrdCd
		, @MberUser MberVO user
		, Model model
	) {
		log.info("=========>>>>>>>>>>>>>> {}", user);
		
		MberVO realUser = service.retrieveSubscriber(user.getCstNo());
		
		MbrshGrdVO mbrsh = service.retrieveOneMbrsh(mbsGrdCd);
		
		List<MbrshGrdVO> mbrshList = service.retrieveAllMbrshList();
		
		AtomicBoolean found = new AtomicBoolean(false);
		
		mbrshList.forEach(m->{
			if(m.getMbsGrdCd().equals(mbsGrdCd)) {
				found.set(true);
				return;
			}
		});
		if(!found.get()) {
			throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "Requested resource not found", null);
		}
		
		if(mbrsh == null) {
			throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "Requested resource not found", null);
		}
		
		model.addAttribute("mbsGrdCd", mbsGrdCd);
		
		model.addAttribute("mbrsh",mbrsh);
		
		model.addAttribute("realUser", realUser);

		return "cstmr/intrcn/mbrsh/subscribe";
	}

	@PostMapping("subscribe/{mbsGrdCd}")
	@ResponseBody
	public Map<String, Object> mbrshsubscribeProcess(
		@PathVariable String mbsGrdCd
		, @ModelAttribute("setleVo") SetleVO setleVo
		, @ModelAttribute("mbrshSetleVO") MbrshSetleVO mbrshSetleVO
	) {
		Map<String, Object> mbrshData = new HashMap<>();
		Map<String, Object> jsonData = new HashMap<>();
		
		mbrshData.put("setleVo", setleVo);
		mbrshData.put("mbrshSetleVO", mbrshSetleVO);
	
		ServiceResult result = service.createMbrshInfo(mbrshData);
		
		switch (result) {
		case OK:
			jsonData.put("message", "ok");
			break;

		default:
			jsonData.put("message", "error");
			break;
		}
		
		setleVO = mbrshSetleVO;
		
		return jsonData;
	}
	
	@GetMapping("subDone/{mbsGrdCd}")
	public String subDone(
		@PathVariable String mbsGrdCd
		, @MberUser MberVO user
		, Model model
		, HttpSession session
		
	) {
		if(session.isNew()) {
			throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "Requested resource not found", null);
		}
		
		List<MbrshGrdVO> mbrshList = service.retrieveAllMbrshList();
		
		AtomicBoolean found = new AtomicBoolean(false);
		
		mbrshList.forEach(m->{
			if(m.getMbsGrdCd().equals(mbsGrdCd)) {
				found.set(true);
				return;
			}
		});
		if(!found.get()) {
			throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "Requested resource not found", null);
		}
		
		
		MberVO realUser = service.retrieveSubscriber(user.getCstNo());
		
		model.addAttribute("mbsGrdCd", mbsGrdCd);
		
		model.addAttribute("realUser", realUser);
		
		model.addAttribute("setleVO", setleVO);
		
		
		
		return "cstmr/intrcn/mbrsh/subDone";
	}
}
