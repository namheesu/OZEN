package kr.or.ddit.cstmr.rsvt.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.cstmr.rsvt.service.CstmrRsvtRetrieveService;
import kr.or.ddit.cstmr.rsvt.service.RefundService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.MberVOWrapper;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;

@Controller
@RequestMapping("cstmr/rsvt")
public class CstmrRsvtRetrieveController {

	@Inject
	private CstmrRsvtRetrieveService service;

	@Inject
	private RefundService refundService;
	/**
	 * 회원일 시 예약조회 페이지 이동, 비회원은 입력 폼 이동
	 * 
	 * @param model
	 * @param authentication
	 * @return
	 */
	@GetMapping("rsvtList")
	public String rsvtList(Model model, Authentication authentication) {
		// 비회과 회원을 구분하기 위해 authentication으로 인증유무 확인, 현재 사용자의 정보를 가져와 mberVo의 인스턴스인지 확인
		if (authentication != null && authentication.getPrincipal() instanceof MberVOWrapper) {
			MberVO mber = ((MberVOWrapper) authentication.getPrincipal()).getMberUser();

			if (mber != null) {
				LocalDate checkin;
				LocalDate checkout;
				long rsvtDay;

				String cstNo = mber.getCstNo();
				List<RsvtVO> mberRsvtList = service.retrieveMberRsvt(cstNo);
				List<RsvtVO> mberEndRsvtList = service.retrieveMberEndRsvt(cstNo);
				List<RsvtVO> mberCancelRsvtList = service.retrieveMberCancelRsvt(cstNo);
				
				List<RsvtDetailsVO> rsvtDetailList = new ArrayList<RsvtDetailsVO>();
				int rsvtCnt = mberRsvtList.size();
				int endRsvtCnt = mberEndRsvtList.size();
				int cancelRsvtCnt = mberCancelRsvtList.size();
				
				String rsvtNo;
				String setleNo;
				SetleVO setle;
				
				List<SetleVO> setleVO = new ArrayList<>();
				
				for (int i = 0; i < rsvtCnt; i++) {
					checkin = mberRsvtList.get(i).getRsvtCheckinYmd();
					checkout = mberRsvtList.get(i).getRsvtCheckoutYmd();
					rsvtDay = ChronoUnit.DAYS.between(checkin, checkout);

					mberRsvtList.get(i).setRsvtDay(rsvtDay);
					rsvtNo = mberRsvtList.get(i).getRsvtNo();
					rsvtDetailList = service.retrieveRsvtDetails(rsvtNo);

					mberRsvtList.get(i).setRsvtDetails(rsvtDetailList);
					
					// 결제번호
					setleNo = mberRsvtList.get(i).getRsvtSetleNo();
					// 결제정보 조회 (파라미터 : 결제번호)
					setle = service.retrieveSetle(setleNo);
					setleVO.add(setle);
				}

				for (int j = 0; j < endRsvtCnt; j++) {
					checkin = mberEndRsvtList.get(j).getRsvtCheckinYmd();
					checkout = mberEndRsvtList.get(j).getRsvtCheckoutYmd();
					rsvtDay = ChronoUnit.DAYS.between(checkin, checkout);

					mberEndRsvtList.get(j).setRsvtDay(rsvtDay);
					rsvtNo = mberEndRsvtList.get(j).getRsvtNo();
					rsvtDetailList = service.retrieveEndRsvtDetails(rsvtNo);

					mberEndRsvtList.get(j).setRsvtDetails(rsvtDetailList);

				}

				for (int k = 0; k < cancelRsvtCnt; k++) {
					checkin = mberCancelRsvtList.get(k).getRsvtCheckinYmd();
					checkout = mberCancelRsvtList.get(k).getRsvtCheckoutYmd();
					rsvtDay = ChronoUnit.DAYS.between(checkin, checkout);

					mberCancelRsvtList.get(k).setRsvtDay(rsvtDay);
					rsvtNo = mberCancelRsvtList.get(k).getRsvtNo();
					rsvtDetailList = service.retrieveCancelRsvtDetails(rsvtNo);
					mberCancelRsvtList.get(k).setRsvtDetails(rsvtDetailList);
				}
				
				model.addAttribute("mberRsvtList", mberRsvtList);
				
				model.addAttribute("mberEndRsvtList", mberEndRsvtList);
				model.addAttribute("mberCancelRsvtList", mberCancelRsvtList);
				model.addAttribute("setleVO", setleVO);

				return "cstmr/rsvt/rsvtMberView";
			}
		}
		return "cstmr/rsvt/rsvtList";
	}

	@GetMapping("rsvtMberView")
	public String rsvtMberView() {
		return "cstmr/rsvt/rsvtMberView";
	}

	/**
	 * 비회원 예약조회
	 * 
	 * @param cstmrVO
	 * @param model
	 * @return
	 */
	@PostMapping("rsvtNberView")
	public String rsvtNberView(
			@ModelAttribute CstmrVO cstmrVO
			, Model model
			) {
		
		RsvtVO nberRsvtList = null;

		// 비회원 예약조회 (파라미터 : 예약번호, 전화번호)
		nberRsvtList = service.retrieveNberRsvt(cstmrVO);
		if(nberRsvtList == null) {
			String message = "조회되는 예약정보가 없습니다.";
			model.addAttribute("message", message);
			return "cstmr/rsvt/rsvtNberView";
		}

		LocalDate checkin = nberRsvtList.getRsvtCheckinYmd();
		LocalDate checkout = nberRsvtList.getRsvtCheckoutYmd();
		
		// 숙박일
		long rsvtDay = ChronoUnit.DAYS.between(checkin, checkout);
		nberRsvtList.setRsvtDay(rsvtDay);
		
		// 예약번호
		String rsvtNo = nberRsvtList.getRsvtNo();
		// 결제번호
		String setleNo = nberRsvtList.getRsvtSetleNo();
		
		// 예약 상세조회 (파라미터 : 예약번호)
		List<RsvtDetailsVO> rsvtDetailList = service.retrieveRsvtDetails(rsvtNo);
		// 결제정보 조회 (파라미터 : 결제번호)
		SetleVO setleVO = service.retrieveSetle(setleNo);
		
		// 예약정보에 상세정보 추가
		nberRsvtList.setRsvtDetails(rsvtDetailList);

		model.addAttribute("nberRsvtList", nberRsvtList);
		model.addAttribute("setleVO", setleVO);
		
		return "cstmr/rsvt/rsvtNberView";
	}

	// 결제 키 정보
	public static final String KEY = "2321751576818553";
	public static final String SECRET = "blhkWoYeaswfXI5HHqu7apes10sIdWTwsUk8cqZgQJcf3aQnZ4eKtFCz5fc20VZ50J2eqnUBIwsLljqI";

	/**
	 * 결제취소 메소드
	 * @throws IOException
	 */
	@PostMapping(value = "rsvtCancel", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String rsvtCancel(
	        @RequestBody Map<String, Object> requestData
	) throws IOException {
	    
	    String merchantUid = requestData.get("setleMerchantUid").toString();
	    
		String token = refundService.getToken(KEY, SECRET);
		
		ServiceResult result = service.rsvtCancel(requestData);
		if(result == ServiceResult.OK) {
			refundService.refundRequest(token, merchantUid, "예약취소");			
		}
		
		return "redirect:rsvtCancel";
	}
}
