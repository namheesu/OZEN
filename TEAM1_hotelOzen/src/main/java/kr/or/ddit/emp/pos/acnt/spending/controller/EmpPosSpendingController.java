package kr.or.ddit.emp.pos.acnt.spending.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.pos.acnt.spending.service.EmpPosSpendingService;
import kr.or.ddit.global.vo.SpendingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pos/acnt/spending")
public class EmpPosSpendingController {

	@Inject
	private EmpPosSpendingService service;
	
	@GetMapping
	public String spendingList(
			Model model
		) {
		LocalDate currentDate = LocalDate.now();
		String currentYear = String.valueOf(currentDate.getYear());
		
		// 연도별 인건비 지출목록
		List<SpendingVO> yearSalarySpending = service.retrieveYearSalary(currentYear);
		// 연도별 비품비 지출목록
		List<SpendingVO> yearFxtrsSpending  = service.retrieveYearFxtrs(currentYear);
		// 연도별 유지비 지출목록
		List<SpendingVO> yearMainSpending  = service.retrieveYearMain(currentYear);
		
		// 월별 인건비 지출목록
		List<SpendingVO> monthSalarySpending = service.retrieveMonthSalary(currentDate.toString());
		// 월별 비품비 지출목록
		List<SpendingVO> monthFxtrsSpending = service.retrieveMonthFxtrs(currentDate.toString());
		// 월별 유지비 지출목록
		List<SpendingVO> monthMainSpending = service.retrieveMonthMain(currentDate.toString());
		
		long yearSalary = 0;
		long yearFxtrs = 0;
		long yearMain = 0;
		long monthSalary = 0;
		long monthFxtrs = 0;
		long monthMain = 0;
		
		// 인건비 연지출
		for(int i = 0; i < yearSalarySpending.size(); i++ ) {
			yearSalary += yearSalarySpending.get(i).getTotal();
		}
		// 비품비 연지출
		for(int i = 0; i < yearFxtrsSpending.size(); i++ ) {
			yearFxtrs += yearFxtrsSpending.get(i).getTotal();
		}
		// 유지비 연지출
		for(int i = 0; i < yearMainSpending.size(); i++ ) {
			yearMain += yearMainSpending.get(i).getTotal();
		}
		// 인건비 월지출
		for(int i = 0; i < monthSalarySpending.size(); i++ ) {
			monthSalary += monthSalarySpending.get(i).getTotal();
		}
		// 비품비 월지출
		for(int i = 0; i <monthFxtrsSpending.size(); i++ ) {
			monthFxtrs += monthFxtrsSpending.get(i).getTotal();
		}
		// 유지비 월지출
		for(int i = 0; i < monthMainSpending.size(); i++ ) {
			monthMain += monthMainSpending.get(i).getTotal();
		}
		
		// 총 연 지출
		long yearTotal = yearSalary + yearFxtrs + yearMain;
		// 총 월 지출
		long monthTotal = monthSalary + monthFxtrs + monthMain;
		
		model.addAttribute("yearSalarySpending",yearSalarySpending);
		model.addAttribute("yearFxtrsSpending",yearFxtrsSpending);
		model.addAttribute("yearMainSpending",yearMainSpending);
		model.addAttribute("monthSalarySpending",monthSalarySpending);
		model.addAttribute("monthFxtrsSpending",monthFxtrsSpending);
		model.addAttribute("monthMainSpending",monthMainSpending);
		model.addAttribute("yearTotal",yearTotal);
		model.addAttribute("monthTotal",monthTotal);
		
		
		return "emp/pos/acnt/spending/spendingList";
	}
	
	@PostMapping("search")
	public String spendingList(
		Model model
		, @RequestBody String searchDate
		) {
		
		String searchYear = searchDate.substring(0,4);
		
		// 연도별 인건비 지출목록
		List<SpendingVO> yearSalarySpending = service.retrieveYearSalary(searchYear);
		// 연도별 비품비 지출목록
		List<SpendingVO> yearFxtrsSpending  = service.retrieveYearFxtrs(searchYear);
		// 연도별 유지비 지출목록
		List<SpendingVO> yearMainSpending  = service.retrieveYearMain(searchYear);
		
		// 월별 인건비 지출목록
		List<SpendingVO> monthSalarySpending = service.retrieveMonthSalary(searchDate);
		// 월별 비품비 지출목록
		List<SpendingVO> monthFxtrsSpending = service.retrieveMonthFxtrs(searchDate);
		// 월별 유지비 지출목록
		List<SpendingVO> monthMainSpending = service.retrieveMonthMain(searchDate);
		
		long yearSalary = 0;
		long yearFxtrs = 0;
		long yearMain = 0;
		long monthSalary = 0;
		long monthFxtrs = 0;
		long monthMain = 0;
		
		// 인건비 연지출
		for(int i = 0; i < yearSalarySpending.size(); i++ ) {
			yearSalary += yearSalarySpending.get(i).getTotal();
		}
		// 비품비 연지출
		for(int i = 0; i < yearFxtrsSpending.size(); i++ ) {
			yearFxtrs += yearFxtrsSpending.get(i).getTotal();
		}
		// 유지비 연지출
		for(int i = 0; i < yearMainSpending.size(); i++ ) {
			yearMain += yearMainSpending.get(i).getTotal();
		}
		// 인건비 월지출
		for(int i = 0; i < monthSalarySpending.size(); i++ ) {
			monthSalary += monthSalarySpending.get(i).getTotal();
		}
		// 비품비 월지출
		for(int i = 0; i <monthFxtrsSpending.size(); i++ ) {
			monthFxtrs += monthFxtrsSpending.get(i).getTotal();
		}
		// 유지비 월지출
		for(int i = 0; i < monthMainSpending.size(); i++ ) {
			monthMain += monthMainSpending.get(i).getTotal();
		}
		
		// 총 연 지출
		long yearTotal = yearSalary + yearFxtrs + yearMain;
		// 총 월 지출
		long monthTotal = monthSalary + monthFxtrs + monthMain;
		
		model.addAttribute("yearSalarySpending",yearSalarySpending);
		model.addAttribute("yearFxtrsSpending",yearFxtrsSpending);
		model.addAttribute("yearMainSpending",yearMainSpending);
		model.addAttribute("monthSalarySpending",monthSalarySpending);
		model.addAttribute("monthFxtrsSpending",monthFxtrsSpending);
		model.addAttribute("monthMainSpending",monthMainSpending);
		model.addAttribute("yearTotal",yearTotal);
		model.addAttribute("monthTotal",monthTotal);
		
		
		return "emp/pos/acnt/spending/spendingList";
	}
	

}
