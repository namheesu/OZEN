package kr.or.ddit.emp.hrm.emply.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.emp.hrm.emply.service.HrmEmpService;
import kr.or.ddit.global.vo.HrmEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/hrm/emply")
public class HrmEmpInsertDeleteController {
	
	public static final String MODELNAME = "hrmEmp";
	
	
	@Inject
	private HrmEmpService service;

	@GetMapping("insert")
	public String insert(Model model) {
		String newEmpNo= service.createHrmEmpNo();
		model.addAttribute("newEmpNo", newEmpNo);
		return "emp/hrm/emply/empForm";
	}
	
	@PostMapping(value="insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insert(
//			@RequestBody HrmEmpVO hrmEmpVO
			@ModelAttribute(MODELNAME) HrmEmpVO hrmEmpVO
			, Model model
			
			) {
		
		log.info("hrmEmpVO: {}",hrmEmpVO);
		log.info("hrmEmpVO: {}",hrmEmpVO.getEmpJncmpYmd());
		
		service.createHrmEmp(hrmEmpVO);
//		model.addAttribute("empNo", hrmEmpVO.getEmpNo());
//		model.addAttribute("empNm", hrmEmpVO.getEmpNm());
		
		//return "emp/hrm/emply/empForm";
	}
	
	
	@PostMapping(value="insertEmps", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertEmps(
			@RequestParam("file") MultipartFile file
			, Model model
			) {
		log.info("신규계정생성 다량", file);
		
		File excelFile = new File(file.getOriginalFilename());
		try {
			file.transferTo(excelFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cnt = 0;
		if(excelFile instanceof File) cnt = service.createHrmEmpsUsingExcel(excelFile);
		model.addAttribute("cnt", cnt);
		
		//service.createHrmEmp(hrmEmpVO);
//		model.addAttribute("empNo", hrmEmpVO.getEmpNo());
//		model.addAttribute("empNm", hrmEmpVO.getEmpNm());
		
		//return "emp/hrm/emply/empForm";
	}
	
	

	@GetMapping(value="delete/{empNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable("empNo") String empNo
			, Model model) {
		service.removeHrmEmp(empNo);
		model.addAttribute("empNo", empNo);
		return "emp/hrm/emply/empList";
	}
}
