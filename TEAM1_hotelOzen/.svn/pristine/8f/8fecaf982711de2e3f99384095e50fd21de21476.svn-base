package kr.or.ddit.emp.pbl.dclz.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pbl.dclz.service.WorkSchdlService;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.WorkSchdlVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/hrm/dclz/workingSchdl")
public class EmpWorkingSchdlController {
	
	@Inject
	private WorkSchdlService service;
	
	
//	@GetMapping("insert.do")
//	public String insert() {	
//		return "emp/hrm/dclz/workingSchdl/workingSchdlForm";
//	}
	
	@GetMapping
	public String workSchdlUI() {
		return "emp/hrm/dclz/workingSchdl/workingSchdlForm";
	}
	
	
	@GetMapping(value="json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WorkSchdlVO> aggridWorkSchdl() {
		//페이징 처리를 하지 않기 때문에 PaginationInfo 는 더미 객체를 생성하고 전달함.
		return service.retrieveWorkSchdlList(new PaginationInfo());
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public WorkSchdlVO workSchdlUpdate(@RequestBody WorkSchdlVO workSchdl) {
		service.modifyWorkSchdl(workSchdl);
		return workSchdl;
	}
	
//	@GetMapping("update.do")
//	public String update() {
//		return "emp/hrm/dclz/workingSchdl/workingSchdlEdit";
//	}
//	
//	@GetMapping("delete.do")
//	public String delete() {
//		return "emp/hrm/dclz/workingSchdl/workingSchdlList";
//	}
//	
//	@GetMapping
//	public String view() {
//		return "emp/hrm/dclz/workingSchdl/workingSchdlView";
//	}
	
}
