package kr.or.ddit.emp.pms.rsvt.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.pms.rsvt.service.EmpPmsQrRsvtService;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pms")
public class EmpPmsQrRsvtController {
	
	@Inject
	private EmpPmsQrRsvtService service;
	
	@RequestMapping(value="rsvt/QRRsvt", method = {RequestMethod.GET})
	public String qrRsvt() {
		return "emp/pms/rsvt/qrRsvtList";
	}
	
	@RequestMapping(value="stay/QRRsvtList", method = {RequestMethod.GET})
	public String qrRsvtList(
		@RequestParam String rsvtNo
		,Model model
	) {
		String logicaViewName = null;
		boolean isReservationInProgress = false;
		
		List<RsvtDetailsVO> rsvtDtlList = service.retrieveRsvtDtlList(rsvtNo);
		model.addAttribute("rsvtDtlList", rsvtDtlList);
		
		log.info("{######################rsvtDtlList:{}",rsvtDtlList );
		
		for(int i=0; i<rsvtDtlList.size(); i++) {
			log.info("#####{}",rsvtDtlList.get(i).getRsvtSe());
			
			if(rsvtDtlList.get(i).getRsvtSe().equals("예약중")) {
		        isReservationInProgress = true; 
		        break;
		    }
			
		}
		
		if(isReservationInProgress) {
		    logicaViewName = "emp/pms/rsvt/qrRsvtList";
		} else {
			logicaViewName = "redirect:/emp/pms/stay/checkinList.do";
		}
		
		return logicaViewName;
	}
	
	@RequestMapping(value="stay/QRRsvtList", method = {RequestMethod.POST})
	public RsvtDetailsVO qrRsvtDtl(
		@RequestParam String rsvtDtlNo 
		, Model model	
	) {
		
		RsvtDetailsVO rsvtDtl = service.retrieveRsvtDtl(rsvtDtlNo);
		model.addAttribute("rsvtDtl",rsvtDtl);
		
		log.info("############rsvtDtl{}",rsvtDtl);
		
		return rsvtDtl;
	}
}
