package kr.or.ddit.global.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmpSchdlVO {
	private int empschdlNo;
	private String empNo;
	private String schdlTitle;
	private LocalDate schdlStart;
	private LocalDate schdlEnd;
	private String bgColor;
}
