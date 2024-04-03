package kr.or.ddit.cstmr.rsvt.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.cstmr.rsvt.service.CstmrRsvtService;
import kr.or.ddit.cstmr.rsvt.service.RefundService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.MberVOWrapper;
import kr.or.ddit.global.validate.InsertGroup;
import kr.or.ddit.global.vo.AttatchRmTypeVO;
import kr.or.ddit.global.vo.CouponIsnVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RecomRoomVO;
import kr.or.ddit.global.vo.RoomTypeVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 고객 예약 클래스
 */
@Slf4j
@Controller
@RequestMapping("cstmr/rsvt")
public class CstmrRsvtRmtRetrieveController {

	/**
	 * 예약 서비스 객체 인스턴스 주입
	 */
	@Inject
	private CstmrRsvtService service;

	@Inject
	private RefundService refundService;

	// 결제 키 정보
	public static final String KEY = "2321751576818553";
	public static final String SECRET = "blhkWoYeaswfXI5HHqu7apes10sIdWTwsUk8cqZgQJcf3aQnZ4eKtFCz5fc20VZ50J2eqnUBIwsLljqI";

	/**
	 * 예약 1단계(예약 가능 객실 조회)
	 */
	@PostMapping("rsvtStep01")
	public String rsvtStep01(
			@ModelAttribute("rsvtVO") RsvtVO rsvtVO
			, HttpServletRequest request
			, Authentication authentication
			, Model model
			, RedirectAttributes redirect

	) {

		log.info("#####authentication:{}", authentication);

		LocalDate checkin = rsvtVO.getRsvtCheckinYmd();
		LocalDate checkout = rsvtVO.getRsvtCheckoutYmd();
		int child = rsvtVO.getRsvtDetails().get(0).getRsvtDtlChildCnt();
		int adult = rsvtVO.getRsvtDetails().get(0).getRsvtDtlAdultCnt();
		int maxNber = child + adult;

		// 예약상세에 인원 수 정보 저장
		rsvtVO.getRsvtDetails().get(0).setRsvtDtlNmprCnt((child + adult));

		int roomCnt = rsvtVO.getRsvtRoomCnt();
		int nbrCnt = rsvtVO.getRsvtAdultCnt() + rsvtVO.getRsvtChildCnt();
		long rsvtDay = ChronoUnit.DAYS.between(checkin, checkout);

		// 객실 2개 이상일 때 객실의 인원 수를 받기 위함
		if (roomCnt >= 2) {
			int child2 = rsvtVO.getRsvtDetails().get(1).getRsvtDtlChildCnt();
			int adult2 = rsvtVO.getRsvtDetails().get(1).getRsvtDtlAdultCnt();
			nbrCnt += (child2 + adult2);
			rsvtVO.getRsvtDetails().get(1).setRsvtDtlNmprCnt((child2 + adult2));
			if (maxNber < (child2 + adult2)) {
				maxNber = child2 + adult2;
			}

			if (roomCnt >= 3) {
				int child3 = rsvtVO.getRsvtDetails().get(2).getRsvtDtlChildCnt();
				int adult3 = rsvtVO.getRsvtDetails().get(2).getRsvtDtlAdultCnt();
				nbrCnt += (child3 + adult3);
				rsvtVO.getRsvtDetails().get(2).setRsvtDtlNmprCnt((child2 + adult2));
				if (maxNber < (child3 + adult3)) {
					maxNber = child3 + adult3;
				}
			}
		}

		boolean mmb = false;
		
		if (authentication != null && authentication.getPrincipal() instanceof MberVOWrapper) {
			MberVO mber = ((MberVOWrapper) authentication.getPrincipal()).getMberUser();

			if (mber != null) { // 회원일때
				String cstNo = mber.getCstNo();
				mmb = true;
				log.info("######################################mmb:{}", mmb);

				CstmrVO cstmr = service.retrieveCstmrAge(cstNo);
				String age = cstmr.getAge();
				redirect.addFlashAttribute("cstmr",cstmr);
				log.info("##############cstmr:{}",cstmr);
				

				Map<String, Object> customerData = new HashMap<>();
				customerData.put("age", age);
				redirect.addFlashAttribute("age",age);
				
				customerData.put("totalNmpr", maxNber);
				redirect.addFlashAttribute("totalNmpr",maxNber);

				List<RecomRoomVO> rcRm = service.retrieveRcRm(customerData);
				model.addAttribute("rcRm", rcRm);
				log.info("######################rcRm:{}", rcRm);

				String rmType1 = rcRm.get(0).getRermRmtype();
				String rmType2 = rcRm.get(1).getRermRmtype();

				log.info("##########################rmType1:{}", rmType1);

				AttatchRmTypeVO attRmt1 = service.retrieveRmt(rmType1);
				AttatchRmTypeVO attRmt2 = service.retrieveRmt(rmType2);

				log.info("##########################attRmt1:{}", attRmt1);

				Map<String, AttatchRmTypeVO> attRmtMap = new HashMap<>();
				attRmtMap.put("attRmt1", attRmt1);
				attRmtMap.put("attRmt2", attRmt2);

				log.info("attRmtMap:{}", attRmtMap);

//	            model.addAttribute("attRmtMap", attRmtMap);
				redirect.addFlashAttribute("attRmtMap", attRmtMap);
			} else {

			}
		}
		redirect.addFlashAttribute("mmb", mmb);
		
		log.info("######################################mmb:{}", mmb);
		log.info("######################################model:{}", model);

		rsvtVO.setRsvtMaxNberCnt(maxNber);
		rsvtVO.setRsvtNberCnt(nbrCnt);
		rsvtVO.setRsvtDay(rsvtDay);

		HttpSession session = request.getSession();

		// 새로운 세션으로 접근 시
		if (session.isNew()) {
			// 에러 처리
		}

		session.setAttribute("rsvtVO", rsvtVO);

		// 받은 파라미터 값으로 예약가능객실 조회 후 리스트에 저장
		List<RoomTypeVO> rsvtRmtList = service.retrieveRsvtRmt(rsvtVO);

		// 파라미터가 비어있지 않을 떄
		if (!rsvtRmtList.isEmpty()) {
			Iterator<RoomTypeVO> value = rsvtRmtList.iterator();

			List<AttatchRmTypeVO> attatchRmTypeVO = new ArrayList<>();

			while (value.hasNext()) {
				// 다음 요소의 RmtTypeCd를 저장
				String rmtTypeCd = value.next().getRmtTypeCd();

				// 조회한 RmtTypeCd로 객실타입 조회 후 저장
				AttatchRmTypeVO rmtList = service.retrieveRmt(rmtTypeCd);

				attatchRmTypeVO.add(rmtList);

			}
			session.setAttribute("attatchRmTypeVO", attatchRmTypeVO);

			// 파라미터가 비어있을 시
		} else {

			// 예약객실 없음 메세지 추가
		}
		return "redirect:rsvtStep01";
	}

	@GetMapping("rsvtStep01")
	public String rsvtStep01() {
		return "cstmr/rsvt/rsvtStep01";
	}

	@GetMapping("rsvtStep02")
	public String rsvtStep02() {
		return "cstmr/rsvt/rsvtStep02";
	}

	/**
	 * 예약 2단계(예약 정보 확인)
	 */
	@PostMapping("rsvtStep02")
	public String rsvtStep02(
			HttpServletRequest request
			, @RequestParam("rmtTypeCd") String rmtTypeCd
			) {

		HttpSession session = request.getSession();

		// 고객인 선택한 객실 타입
		AttatchRmTypeVO roomType = service.retrieveRmt(rmtTypeCd);

		session.setAttribute("roomType", roomType);

		return "redirect:rsvtStep02";
	}

	/**
	 * 예약 3단계(예약자 정보 입력 및 확인)
	 */
	@PostMapping("rsvtStep03")
	public String rsvtStep03(
			Authentication authentication
			, HttpServletRequest request
		) {
		HttpSession session = request.getSession();
		
		// 비회과 회원을 구분하기 위해 authentication으로 인증유무 확인, 현재 사용자의 정보를 가져와 mberVo의 인스턴스인지 확인
		if (authentication != null && authentication.getPrincipal() instanceof MberVOWrapper) {
			MberVO mber = ((MberVOWrapper) authentication.getPrincipal()).getMberUser();

			if (mber != null) {
				Map<String, Object> parameterMap = new HashMap<>();
				
				String cstNo = mber.getCstNo();
				MberVO realMber = service.retrieveMber(cstNo);
				session.setAttribute("realMber", realMber);
				
				AttatchRmTypeVO roomType = (AttatchRmTypeVO) session.getAttribute("roomType");
				
				String roomTypeNm = roomType.getRmtype().getRmtNmDetails().substring(0,2);
				
				parameterMap.put("cstNo", cstNo);
				parameterMap.put("roomTypeNm", roomTypeNm.trim());
				log.info("cstNo@@@@@:{} ", cstNo);
				log.info("roomTypeNm@@@@@:{} ", roomTypeNm);
				
				List<CouponIsnVO> couponList =  service.retrieveCoupon(parameterMap);
				session.setAttribute("couponList", couponList);
			}
		}

		return "redirect:rsvtStep03";
	}

	@GetMapping("rsvtStep03")
	public String rsvtStep03() {
		return "cstmr/rsvt/rsvtStep03";
	}

	/**
	 * 예약 4단계(예약 정보, 고객 정보, 카드 정보 등 단순 데이터 insert 과정)
	 * 
	 * @throws IOException
	 */
	@PostMapping("rsvtStep04")
	public String rsvtSetle(
			@ModelAttribute CstmrVO rsvtCstmr
			, @ModelAttribute SetleVO setle
			, @ModelAttribute RsvtVO rsvt
			, @RequestParam("cpnNo") String cpnNo
			, BindingResult errors
			, Model model
			, HttpServletRequest request)
		throws IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		Map<String, Object> rsvtData = new HashMap<>();

		int rsvtDtlAmnt = 0;

		// 선택 객실 타입정보
		AttatchRmTypeVO roomType = (AttatchRmTypeVO) session.getAttribute("roomType");
		RsvtVO rsvtVO = (RsvtVO) session.getAttribute("rsvtVO");

		// 객실 별 금액정보
		for (int i = 0; i < rsvtVO.getRsvtRoomCnt(); i++) {
			rsvtDtlAmnt = rsvt.getRsvtDetails().get(i).getRsvtDtlAmnt();
			rsvtVO.getRsvtDetails().get(i).setRsvtDtlAmnt(rsvtDtlAmnt);
		}
		log.info("@@@@@@@@@@@cpnNo:{}",cpnNo);
		rsvtData.put("rsvtVO", rsvtVO);
		rsvtData.put("rsvtCstmr", rsvtCstmr);
		rsvtData.put("setle", setle);
		rsvtData.put("roomType", roomType);
		rsvtData.put("contextPath", contextPath);
		rsvtData.put("cpnNo", cpnNo);
		
		ServiceResult result = service.createNewRsvt(rsvtData);

		// 예약에 실패했을 경우 결제 취소
		if (result != ServiceResult.OK) {
			String token = refundService.getToken(KEY, SECRET);
			String merchantUid = setle.getSetleMerchantUid();

			refundService.refundRequest(token, merchantUid, "예약실패");
		}

		model.addAttribute("rsvtCstmr", rsvtCstmr);

		return "redirect:rsvtEnd";
	}

	/**
	 * 예약 완료 페이지
	 */
	@GetMapping("rsvtEnd")
	public String rsvtEnd() {
		return "cstmr/rsvt/rsvtEnd";
	}

	@PostMapping("recomRsvtList")
	public String rcRmList(String adult, String child, Model model) {
		int totalNmpr = Integer.parseInt(adult) + Integer.parseInt(child);
		String cstNo = "M2400019"; // 추후 가져와야됨.
		CstmrVO cstmr = service.retrieveCstmrAge(cstNo);
		String age = cstmr.getAge();

		Map<String, Object> customerData = new HashMap<>();
		customerData.put("age", age);
		customerData.put("totalNmpr", totalNmpr);

		List<RecomRoomVO> rcRm = service.retrieveRcRm(customerData);
		model.addAttribute("rcRm", rcRm);
		log.info("######################rcRm:{}", rcRm);

		String rmType1 = rcRm.get(0).getRermRmtype();
		String rmType2 = rcRm.get(1).getRermRmtype();

		log.info("##########################rmType1:{}", rmType1);

		AttatchRmTypeVO attRmt1 = service.retrieveRmt(rmType1);
		AttatchRmTypeVO attRmt2 = service.retrieveRmt(rmType2);

		log.info("##########################attRmt1:{}", attRmt1);

		Map<String, AttatchRmTypeVO> attRmtMap = new HashMap<>();
		attRmtMap.put("attRmt1", attRmt1);
		attRmtMap.put("attRmt2", attRmt2);

		log.info("attRmtMap:{}", attRmtMap);

		model.addAttribute("attRmtMap", attRmtMap);

		return "cstmr/rsvt/recomRsvtList";
	}

}
