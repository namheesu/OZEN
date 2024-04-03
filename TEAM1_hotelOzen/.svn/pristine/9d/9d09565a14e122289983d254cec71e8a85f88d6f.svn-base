package kr.or.ddit.emp.pos.acnt.selling.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.pos.acnt.selling.service.EmpPosSellingService;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SellingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pos/acnt/selling")
public class EmpPosSellingController {

	@Inject
	private EmpPosSellingService service;

	/**
	 * 매출조회
	 * @param model
	 * @return
	 */
	@GetMapping
	public String sellingList(Model model) {
		LocalDate currentDate = LocalDate.now();
		String currentYear = String.valueOf(currentDate.getYear());

		// 연도별 매출
		List<SellingVO> yearSelling = service.retrieveYearSetle(currentYear);
		List<SellingVO> yearCKOTSelling = new ArrayList<>();;
		List<SellingVO> yearCPROSelling = new ArrayList<>();;
		List<SellingVO> yearWALKSelling = new ArrayList<>();;
		List<SellingVO> yearCPMBSelling = new ArrayList<>();;
		// 월별 매출
		List<SellingVO> monthSelling = service.retrieveMonthSetle(currentDate.toString());
		List<SellingVO> monthCKOTSelling = new ArrayList<>();;
		List<SellingVO> monthCPROSelling = new ArrayList<>();;
		List<SellingVO> monthWALKSelling = new ArrayList<>();;
		List<SellingVO> monthCPMBSelling = new ArrayList<>();;
		
		// 주간별 매출
		List<SellingVO> weekSelling = service.retrieveWeekSetle(currentDate.toString());
		List<SellingVO> weekCKOTSelling = new ArrayList<>();;
		List<SellingVO> weekCPROSelling = new ArrayList<>();;
		List<SellingVO> weekWALKSelling = new ArrayList<>();;
		List<SellingVO> weekCPMBSelling = new ArrayList<>();;
		
		// 주간별 예약건 수
		List<RsvtVO> weekRsvt = service.retrieveWeekRsvt(currentDate.toString());
		
		long yearTotal = 0;
		long monthTotal = 0;
		long dayTotal = 0;
		int rsvtCount = 0;
		
		// 연도별 매출
		for (int i = 0; i < yearSelling.size(); i++) {
			
			// 연매출
			yearTotal += yearSelling.get(i).getTotal();
			
			// 수익원 별 분류
			switch(yearSelling.get(i).getSetleAdd()) {
				case "CKOT":
					yearCKOTSelling.add(yearSelling.get(i));
					break;
				case "CPRO":
					yearCPROSelling.add(yearSelling.get(i));
					break;
				case "WALK":
					yearWALKSelling.add(yearSelling.get(i));
					break;
				case "CPMB":
					yearCPMBSelling.add(yearSelling.get(i));
			}
		}
		
		// 월별 매출
		for (int i = 0; i < monthSelling.size(); i++) {

			// 월매출
			monthTotal += monthSelling.get(i).getTotal();
		
			// 수익원 별 분류
			switch(monthSelling.get(i).getSetleAdd()) {
			case "CKOT":
				monthCKOTSelling.add(monthSelling.get(i));
				break;
			case "CPRO":
				monthCPROSelling.add(monthSelling.get(i));
				break;
			case "WALK":
				monthWALKSelling.add(monthSelling.get(i));
				break;
			case "CPMB":
				monthCPMBSelling.add(monthSelling.get(i));
			}
		}
		
		// 주간별 매출
		for (int i = 0; i < weekSelling.size(); i++) {
			// 일 매출
			if(weekSelling.get(i).getSellingDate().equals(currentDate) ) {
				dayTotal += weekSelling.get(i).getTotal();
			}
			
			// 수익원 별 분류
			switch(weekSelling.get(i).getSetleAdd()) {
			case "CKOT":
				weekCKOTSelling.add(weekSelling.get(i));
				break;
			case "CPRO":
				weekCPROSelling.add(weekSelling.get(i));
				break;
			case "WALK":
				weekWALKSelling.add(weekSelling.get(i));
				break;
			case "CPMB":
				weekCPMBSelling.add(weekSelling.get(i));
			}
		}

		// 금일 예약 건 수
		for(int i = 0; i< weekRsvt.size() ; i++) {
			
			if(weekRsvt.get(i).getRsvtDate().equals(currentDate) ) {
				rsvtCount = weekRsvt.get(i).getRsvtCount();
			}
		}
		
		model.addAttribute("yearCKOTSelling", yearCKOTSelling);
		model.addAttribute("yearCPROSelling", yearCPROSelling);
		model.addAttribute("yearWALKSelling", yearWALKSelling);
		model.addAttribute("yearCPMBSelling", yearCPMBSelling);
		
		model.addAttribute("monthCKOTSelling", monthCKOTSelling);
		model.addAttribute("monthCPROSelling", monthCPROSelling);
		model.addAttribute("monthWALKSelling", monthWALKSelling);
		model.addAttribute("monthCPMBSelling", monthCPMBSelling);
		
		model.addAttribute("weekCKOTSelling", weekCKOTSelling);
		model.addAttribute("weekCPROSelling", weekCPROSelling);
		model.addAttribute("weekWALKSelling", weekWALKSelling);
		model.addAttribute("weekCPMBSelling", weekCPMBSelling);

		model.addAttribute("yearTotal",yearTotal);
		model.addAttribute("monthTotal",monthTotal);
		model.addAttribute("dayTotal",dayTotal);
		
		model.addAttribute("weekRsvt", weekRsvt);
		model.addAttribute("rsvtCount", rsvtCount);
		
		return "emp/pos/acnt/selling/sellingList";
	}

	@PostMapping("search")
	public String sellingList(
			Model model
			, @RequestBody String searchDate
			) {
		String searchYear = searchDate.substring(0, 4);

		// 연도별 매출
		List<SellingVO> yearSelling = service.retrieveYearSetle(searchYear);
		List<SellingVO> yearCKOTSelling = new ArrayList<>();;
		List<SellingVO> yearCPROSelling = new ArrayList<>();;
		List<SellingVO> yearWALKSelling = new ArrayList<>();;
		List<SellingVO> yearCPMBSelling = new ArrayList<>();;
		// 월별 매출
		List<SellingVO> monthSelling = service.retrieveMonthSetle(searchDate);
		List<SellingVO> monthCKOTSelling = new ArrayList<>();;
		List<SellingVO> monthCPROSelling = new ArrayList<>();;
		List<SellingVO> monthWALKSelling = new ArrayList<>();;
		List<SellingVO> monthCPMBSelling = new ArrayList<>();;
		
		// 주간별 매출
		List<SellingVO> weekSelling = service.retrieveWeekSetle(searchDate);
		List<SellingVO> weekCKOTSelling = new ArrayList<>();;
		List<SellingVO> weekCPROSelling = new ArrayList<>();;
		List<SellingVO> weekWALKSelling = new ArrayList<>();;
		List<SellingVO> weekCPMBSelling = new ArrayList<>();;
				
		long yearTotal = 0;
		long monthTotal = 0;
		long dayTotal = 0;
		int rsvtCount = 0;
		
		// 주간별 예약건 수
		List<RsvtVO> weekRsvt = service.retrieveWeekRsvt(searchDate);
		
		// 연도별 매출
		for (int i = 0; i < yearSelling.size(); i++) {
			
			// 연매출
			yearTotal += yearSelling.get(i).getTotal();
						
			// 수익원 별 분류
			switch(yearSelling.get(i).getSetleAdd()) {
				case "CKOT":
					yearCKOTSelling.add(yearSelling.get(i));
					break;
				case "CPRO":
					yearCPROSelling.add(yearSelling.get(i));
					break;
				case "WALK":
					yearWALKSelling.add(yearSelling.get(i));
					break;
				case "CPMB":
					yearCPMBSelling.add(yearSelling.get(i));
			}
		}
				
		// 월별 매출
		for (int i = 0; i < monthSelling.size(); i++) {
			
			// 월매출
			monthTotal += monthSelling.get(i).getTotal();
			
			// 수익원 별 분류
			switch(monthSelling.get(i).getSetleAdd()) {
			case "CKOT":
				monthCKOTSelling.add(monthSelling.get(i));
				break;
			case "CPRO":
				monthCPROSelling.add(monthSelling.get(i));
				break;
			case "WALK":
				monthWALKSelling.add(monthSelling.get(i));
				break;
			case "CPMB":
				monthCPMBSelling.add(monthSelling.get(i));
			}
		}
		
		// 주간별 매출
		for (int i = 0; i < weekSelling.size(); i++) {
			
			// 일 매출
			if(weekSelling.get(i).getSellingDate().equals(LocalDate.parse(searchDate))) {
				dayTotal += weekSelling.get(i).getTotal();
			}
						
			// 수익원 별 분류
			switch(weekSelling.get(i).getSetleAdd()) {
			case "CKOT":
				weekCKOTSelling.add(weekSelling.get(i));
				break;
			case "CPRO":
				weekCPROSelling.add(weekSelling.get(i));
				break;
			case "WALK":
				weekWALKSelling.add(weekSelling.get(i));
				break;
			case "CPMB":
				weekCPMBSelling.add(weekSelling.get(i));
			}
		}
		
		// 금일 예약 건 수
		for(int i = 0; i< weekRsvt.size() ; i++) {
			
			if(weekRsvt.get(i).getRsvtDate().equals(LocalDate.parse(searchDate)) ) {
				rsvtCount = weekRsvt.get(i).getRsvtCount();
			}
		}
				
		model.addAttribute("yearCKOTSelling", yearCKOTSelling);
		model.addAttribute("yearCPROSelling", yearCPROSelling);
		model.addAttribute("yearWALKSelling", yearWALKSelling);
		model.addAttribute("yearCPMBSelling", yearCPMBSelling);
		
		model.addAttribute("monthCKOTSelling", monthCKOTSelling);
		model.addAttribute("monthCPROSelling", monthCPROSelling);
		model.addAttribute("monthWALKSelling", monthWALKSelling);
		model.addAttribute("monthCPMBSelling", monthCPMBSelling);
		
		model.addAttribute("weekCKOTSelling", weekCKOTSelling);
		model.addAttribute("weekCPROSelling", weekCPROSelling);
		model.addAttribute("weekWALKSelling", weekWALKSelling);
		model.addAttribute("weekCPMBSelling", weekCPMBSelling);
		
		model.addAttribute("yearTotal",yearTotal);
		model.addAttribute("monthTotal",monthTotal);
		model.addAttribute("dayTotal",dayTotal);
		
		model.addAttribute("weekRsvt", weekRsvt);
		model.addAttribute("rsvtCount", rsvtCount);
		
		return "emp/pos/acnt/selling/sellingList";
	}

}
