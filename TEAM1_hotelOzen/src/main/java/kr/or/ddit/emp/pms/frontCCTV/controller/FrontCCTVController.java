package kr.or.ddit.emp.pms.frontCCTV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp/pms/frontCCTV")
public class FrontCCTVController {

	@GetMapping
	public String frontCCTV() {
//		
//		String url = "http://127.0.0.1:5000/";
//		String sb = "";
//		
//		try {
//			RestTemplate restTemplate = new RestTemplate();	// Http 요청 보내고 응답받는 객체 생성
//			sb = restTemplate.getForObject(url, String.class);
//			
//			System.out.println("========br======" + sb); // 가져온 데이터를 출력
//			if (sb.contains("ok")) { // 가져온 데이터에 "ok" 문자열이 포함되어 있는지 확인
//				System.out.println("test");
//			}
//			
//			System.out.println("" + sb);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        
//		model.addAttribute("test1", sb);
//		model.addAttribute("fail", false);
//		
		return "emp/pms/frontCCTV/frontCCTV";
	}
	
}
