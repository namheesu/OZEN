package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.global.validate.ChangePwdGroup;
import kr.or.ddit.global.validate.InsertGroup;
import kr.or.ddit.global.validate.LoginGroup;
import kr.or.ddit.global.validate.UpdateGroup;
import kr.or.ddit.global.validate.constraints.Password;
import kr.or.ddit.global.validate.constraints.TelNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "empNo")
public class EmpVO implements Serializable {
	private int rnum;

	@NotBlank(groups = {Default.class, LoginGroup.class})
	private String empNo;
	
	private String empNm;
	
	@TelNumber(groups = {InsertGroup.class})
	private String empTel;
	
	@TelNumber(groups = {InsertGroup.class}, regex = "\\d{2,3}-\\d{3,4}-\\d{4}")
	private String empHomeTel;
	
	@Email
	private String empEml;
	private String empAddr;
	private LocalDate empJncmpYmd;
	private String empRtrmYn;
	private String empProflNm;
	private String empProflUuid;
	private Integer empAnnualLeave;
	private String empJbgd;
	private String empDept;
	private String empDeptName;
	private LocalDate empBirth;
	
	@Password(groups = {Default.class, ChangePwdGroup.class, LoginGroup.class})
	@NotBlank(groups = {Default.class, ChangePwdGroup.class, LoginGroup.class})
	private String empPw;
	
	@Password(groups = {UpdateGroup.class})
	private String newPwd;
	
	private List<String> UserRoles;
	
	private int empAnnual;
	
	private int empCareer;
	
	private MultipartFile proflImg;
	
}
