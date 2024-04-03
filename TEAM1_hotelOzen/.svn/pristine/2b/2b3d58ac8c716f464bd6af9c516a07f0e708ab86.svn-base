package kr.or.ddit.cstmr;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.crm.cstmr.service.CrmMembshRecomService;
import kr.or.ddit.global.security.MberVOWrapper;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RecomMbrshVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CstmrIndexController {
	
	@Inject
	private CrmMembshRecomService service;
	
//	@RequestMapping("/cstmr/index.do")
//	public String index() {
//		return "cstmr/index";
//	}
	
	
	/**
	 * 멤버십 추천 팝업이 있는 경우
	 * @param model
	 * @return
	 */
	@RequestMapping("/cstmr/index.do")
	public String index2(Model model) {
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		log.info("지금 사이트에 입장한 사람은 {} 입니다.", user.getClass());
			if( user instanceof MberVOWrapper) { //MberVOWrapper
//				log.info("찾았습니다. {}",((MberVOWrapper) user).getMberUser());
				MberVO cst = ((MberVOWrapper) user).getMberUser();
				String cstNo = cst.getCstNo();
				String cstNm = cst.getCst().getCstNm();
		
				RecomMbrshVO vo = service.getRecomMbrsh(cstNo);
				log.info("{}", vo);
				model.addAttribute("vo", vo);
				model.addAttribute("cstNm", cstNm);
		}else {
//			log.info("못 찾음");
		}
		return "cstmr/index";
	} 
}
