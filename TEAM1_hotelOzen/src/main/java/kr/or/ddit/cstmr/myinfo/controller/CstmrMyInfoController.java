package kr.or.ddit.cstmr.myinfo.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.cstmr.auth.service.MberAuthService;
import kr.or.ddit.cstmr.myinfo.service.CstmrMyInfoService;
import kr.or.ddit.cstmr.rsvt.service.CstmrRsvtRetrieveService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.MberUser;
import kr.or.ddit.global.validate.UpdateGroup;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.MbrshSetleVO;
import kr.or.ddit.global.vo.MileageVO;
import kr.or.ddit.global.vo.RegistVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.ScrapVO;
import kr.or.ddit.mybatis.mappers.MberMapper;
import kr.or.ddit.mybatis.mappers.MbrshMapper;
import kr.or.ddit.mybatis.mappers.ScrapMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/myinfo")
public class CstmrMyInfoController {

	@Inject
	private CstmrMyInfoService service;
	
	@Inject
	private CstmrRsvtRetrieveService rsvtService;	
	
	@Inject
	private MberMapper dao;
	
	@Inject
	private MbrshMapper mbrshDao;
	
	@Inject
	private ScrapMapper scrapDAO;
	
	@Inject
	MberAuthService authService;
	
	MberVO user;
	
	@GetMapping("/mypage.do")
	public String mypage(
		Model model
		, @MberUser MberVO mber
	) {
		LocalDate checkin;
		LocalDate checkout;
		long rsvtDay;

		String cstNo = mber.getCstNo();
		List<RsvtVO> mberRsvtList = rsvtService.retrieveMberRsvt(cstNo);

		List<RsvtDetailsVO> rsvtDetailList;
		String rsvtNo;
		int rsvtCnt = mberRsvtList.size();

		for (int i = 0; i < rsvtCnt; i++) {
			checkin = mberRsvtList.get(i).getRsvtCheckinYmd();
			checkout = mberRsvtList.get(i).getRsvtCheckoutYmd();
			rsvtDay = ChronoUnit.DAYS.between(checkin, checkout);

			mberRsvtList.get(i).setRsvtDay(rsvtDay);
			rsvtNo = mberRsvtList.get(i).getRsvtNo();
			rsvtDetailList = rsvtService.retrieveRsvtDetails(rsvtNo);

			mberRsvtList.get(i).setRsvtDetails(rsvtDetailList);
			model.addAttribute("mberRsvtList", mberRsvtList);
		}
		
		user = service.retrieveUser(cstNo);
		model.addAttribute("user", user);
		
		return "cstmr/myinfo/mypage";
	}

	@GetMapping("/mileageList.do")
	public String mileageList(
		Model model
	) {
		List<MileageVO> mileageList = dao.selectMileageList(user.getCstNo());
		log.info("mileageList : >>>>>>>>>>>>>>> {}", mileageList);
		model.addAttribute("user", user);
		model.addAttribute("mileageList", mileageList);
		
		return "cstmr/myinfo/mypage/mileageList";
	}

	@GetMapping("/couponList.do")
	public String couponList(
		Model model
	) {
		model.addAttribute("user", user);

		return "cstmr/myinfo/mypage/couponList";
	}
	
	@GetMapping("/updateInfo.do")
	public String updateInfoForm(
		Model model
	) {
		model.addAttribute("user", user);
		return "cstmr/myinfo/mypage/updateInfo";
	}

	// 개인정보 업데이트 컨트롤러
	@PostMapping("/updateInfo.do")
	@ResponseBody
	public Map<String, Object> updateInfoProcess(
		@RequestBody RegistVO modMber
		, Model model
	) {
		Map<String, Object> jsonObj = new HashMap<>();
		
		ServiceResult result = service.modify(modMber);
		
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
	
	@GetMapping("/mypwchange.do")
	public String mypwchange(
		Model model
	) {
		model.addAttribute("user", user);
		return "cstmr/myinfo/mypage/mypwchange";
	}
	
	@PostMapping("/mypwchange.do")
	@ResponseBody
	public Map<String, Object> pwchangeProcess(
		@Validated(UpdateGroup.class) @RequestBody MberVO mber
		, BindingResult errors
	){
		Map<String, Object> jsonObj = new HashMap<>();
		
		log.info("업데이트 대상자 : {}", mber);
		
		ServiceResult result = null;
		
		MberVO realUser = dao.select(mber.getCstNo());
		
		log.info("realUser.getMberPw() : {}", realUser.getMberPw());
		log.info("mber.getMberPw()) : {}", mber.getMberPw());
		
		if(!realUser.getMberPw().equals(mber.getMberPw())) {
			jsonObj.put("message", "dismatch");
			return jsonObj;
		}
		
		if(!errors.hasErrors()) {
			result = authService.changeMyPwd(mber);
			
			switch (result) {
			case OK:
				jsonObj.put("message", "ok");
				break;

			default:
				jsonObj.put("message", "error");
				break;
			}
		}else {
			jsonObj.put("message", "error");
			Map<String, String> errorsMap= new HashMap<>();
			errors.getFieldErrors().forEach(fe->{
				errorsMap.put(fe.getField(),fe.getDefaultMessage());
			});
			jsonObj.put("errors", errorsMap);
		}
		return jsonObj;
	}
	
	@GetMapping("/secsn.do")
	public String secsn() {
		return "cstmr/myinfo/mypage/secsn";
	}
	
	@PostMapping("/checkPwd.do")
	@ResponseBody
	public Map<String, Object> checkPwd(
		@RequestBody Map<String, String> jsonObj
		, @MberUser MberVO mber
	) {
		Map<String, Object> jsonData = new HashMap<>();
		
		log.info("(jsonObj.get(\"currentPwd\")!= mber.getMberPw() = > {}, {}",jsonObj.get("currentPwd"), mber.getMberPw());
		
		if(jsonObj.get("currentPwd").equals(mber.getMberPw())) {
			jsonData.put("message", "ok");			
		}else {
			jsonData.put("message", "error");
		}
		return jsonData;
	}
	
	@GetMapping("/secsnCheck.do")
	public String secsnCheck(
		HttpSession session
	) {
		if(session.isNew()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
		}
		return "cstmr/myinfo/mypage/secsnCheck";
	}
	
	
	@PostMapping("/secsnCheck.do")
	@ResponseBody
	public Map<String, Object> secsnConfirm(
		@MberUser MberVO mber
	){
		Map<String, Object> jsonData = new HashMap<>();
		ServiceResult result = service.secsn(mber.getCstNo());
		
		switch (result) {
		case OK:
			jsonData.put("message", "ok");
			break;

		default:
			jsonData.put("message", "error");
			break;
		}
		return jsonData;
	}
	
	@GetMapping("/mbrshSetle.do")
	public String mbrshSetle(
		Model model
	) {

		List<MbrshSetleVO> mbrshList = mbrshDao.selectUserMbershList(user.getCstNo());
		
		model.addAttribute("mbrshList", mbrshList);
		
		return "cstmr/myinfo/mypage/mbrshSetle";
	}

	/**
	 * 마이페이지-스크랩 목록 컨트롤러
	 * @return
	 */
	@GetMapping("/myscrapList.do")
	public String scrapList(
		Model model
	) {
		
		String cstNo = user.getCstNo();
		
		List<ScrapVO> carList = scrapDAO.selectScrapCar(cstNo);
		List<ScrapVO> sbrsList = scrapDAO.selectScrapSbrs(cstNo);
		
		model.addAttribute("carList", carList);
		model.addAttribute("sbrsList", sbrsList);
		
		return "cstmr/myinfo/mypage/myscrapList";
		
	}
}
