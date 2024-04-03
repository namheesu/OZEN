package kr.or.ddit.cstmr.recom.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.cstmr.recom.service.CstmrIntrcnRecomCarService;
import kr.or.ddit.global.security.MberUser;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.ScrapVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/recom")
public class CarScrapController {

	@Inject
	private CstmrIntrcnRecomCarService serviceCar;
	
	@PostMapping("insertCar")
	public String insertSbrs(@RequestParam String carNo, @MberUser MberVO mber, Principal authPrincipal) {
		ScrapVO newCar = new ScrapVO();
		newCar.setCstNo(mber.getCstNo());
		newCar.setScrapNo(carNo);
		int rowcnt = serviceCar.insertCarScrap(newCar);
		log.info("rowcnt {}", rowcnt);
		return null;
	}
	
	@PostMapping("deleteCar") 
	public String deleteCar(@RequestParam String carNo, @MberUser MberVO mber , Principal principal) {
		ScrapVO deleteCar = new ScrapVO();
		deleteCar.setCstNo(mber.getCstNo());
		deleteCar.setScrapNo(carNo);
		int rowcnt = serviceCar.deleteCarScrap(deleteCar);
		log.info("rowcnttt {}", rowcnt);
		return null;
	}
	
}
