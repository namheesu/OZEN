package kr.or.ddit.cstmr.scrap.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.cstmr.scrap.service.MemScrapService;
import kr.or.ddit.global.security.MberUser;
import kr.or.ddit.global.security.MberVOWrapper;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.ScrapVO;
import kr.or.ddit.mybatis.mappers.ScrapMapper;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = "kr.or.ddit.cstmr")
@Slf4j
@RequestMapping("/scrap")
public class MemScrapControllerAdvice {

	@Inject
	private ScrapMapper scrapDAO;
	
	@Inject
	private MemScrapService scrapService;
	
	@ModelAttribute("sbrsScrapList")
	public List<ScrapVO> addSbrsScrap(Authentication authentication) {
		Object wrapper = null;
		if(authentication != null) {
			wrapper = authentication.getPrincipal();
		}
		if(wrapper != null &&( wrapper instanceof MberVOWrapper) ) {
			MberVO mber = ((MberVOWrapper) wrapper).getMberUser();
			return scrapDAO.selectScrapSbrs(mber.getCstNo());
		} else {
			return Collections.emptyList();
		}
	}
	
	@ModelAttribute("carScrapList")
	public List<ScrapVO> addCarScrap(Authentication authentication) {
		Object wrapper = null;
		if(authentication != null) {
			wrapper = authentication.getPrincipal();
		}
		if(wrapper != null && (wrapper instanceof MberVOWrapper )) {
			MberVO mber = ((MberVOWrapper) wrapper).getMberUser();
			return scrapDAO.selectScrapCar(mber.getCstNo());
		} else {
			return Collections.emptyList();
		}
	}
	
	@PostMapping("deleteScrap") 
	public String deleteScrap(@RequestParam String scrapNo,
							@MberUser MberVO mber, Principal principal) {
		ScrapVO deleteScrap = new ScrapVO();
		deleteScrap.setCstNo(mber.getCstNo());
		deleteScrap.setScrapNo(scrapNo);
		int rowcnt = scrapService.deleteScrap(deleteScrap);
		log.info("rowcnttt {}", rowcnt);
		return null;
	}
	
}
