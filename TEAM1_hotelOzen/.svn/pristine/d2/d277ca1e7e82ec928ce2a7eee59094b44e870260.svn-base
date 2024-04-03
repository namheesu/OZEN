package kr.or.ddit.cstmr.recom.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.cstmr.recom.service.CstmrRecomSbrsService;
import kr.or.ddit.global.security.MberUser;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.ScrapVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/recom")
public class SbrsScrapController {

   @Inject
   private CstmrRecomSbrsService serviceSbrs;
   
   @PostMapping("insertSbrs")
   public String insertSbrs(@RequestParam String sbrsCd, @MberUser MberVO mber, Principal authPrincipal) {
      ScrapVO newSbrs = new ScrapVO();
      newSbrs.setCstNo(mber.getCstNo());
      newSbrs.setScrapNo(sbrsCd);
      int rowcnt = serviceSbrs.insertSbrsScrap(newSbrs);
      log.info("rowcnt {}", rowcnt);
      return null;
   }
   
   @PostMapping("deleteSbrs")
   public String deleteSbrs(@RequestParam String sbrsCd, @MberUser MberVO mber, Principal auPrincipal) {
	   ScrapVO deleteScrap = new ScrapVO();
	   deleteScrap.setCstNo(mber.getCstNo());
	   deleteScrap.setScrapNo(sbrsCd);
	   int rowcnt = serviceSbrs.deleteSbrsScrap(deleteScrap);
	   log.info("deleteCnt {}" , rowcnt);
	   return null;
   }
}