package kr.or.ddit.cstmr.intrcn.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class CstmrRoomListController {
	
	@GetMapping("standard.do")
	public String standardList() {
		return "cstmr/intrcn/room/standard";
	}
	
	@GetMapping("deluxe.do")
	public String deluxeList() {
		return "cstmr/intrcn/room/deluxe";
	}
	
	@GetMapping("suite.do")
	public String suiteList() {
		return "cstmr/intrcn/room/suite";
	}
	
	@GetMapping("special.do")
	public String specialList() {
		return "cstmr/intrcn/room/special";
	}
}
