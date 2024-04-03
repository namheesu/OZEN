package kr.or.ddit.emp.pos.setle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/pos/setle")
public class EmpPosSetleController {
	
	@GetMapping
	public String setleList() {
		return "emp/pos/setle/setleList";
	}
	
	@GetMapping("{prchsNo}")
	public String setleView(
		@PathVariable String prchsNo	
		) {
		return "emp/pos/setle/setleView";
	}
}
