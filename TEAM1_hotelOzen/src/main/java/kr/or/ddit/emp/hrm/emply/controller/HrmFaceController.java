package kr.or.ddit.emp.hrm.emply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/hrm/hr/faceList")
public class HrmFaceController {
	
	@GetMapping("insert")
	public String insert() {
		return "emp/hrm/face/faceForm";
	}
	
	@GetMapping("delete")
	public String delete() {
		return "emp/hrm/face/faceEdit";
	}
	
	@GetMapping("update")
	public String update() {
		return "emp/hrm/face/faceEdit";
	}
	
	@GetMapping
	public String List() {
		return "emp/hrm/face/faceList";
	}

}
