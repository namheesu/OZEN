package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="empNo")
public class HrmEmpVO implements Serializable{
	
	private int rnum;
	
	private String userRole;
	private String empNo;
	private String empNm;
	private String empTel;
	private String empHomeTel;
	private String empEml;
	private String empAddr;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate empJncmpYmd;
	private String empRtrmYn;
	private String empProflNm;
	private String empProflUuid;
	private Integer empAnnualLeave;
	private String empJbgd;
	private String empDept;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate empBirth;
	private String empPw;
	
	//정렬하기 위함.
	private String empDeptNo;
	private String empJbgdNo;
	
	private DclzVO dclz;
	
}
