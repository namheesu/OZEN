package kr.or.ddit.global.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import kr.or.ddit.global.validate.InsertGroup;
import kr.or.ddit.global.validate.LoginGroup;
import kr.or.ddit.global.validate.constraints.Adult;
import kr.or.ddit.global.validate.constraints.Password;
import kr.or.ddit.global.validate.constraints.TelNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "cstNo")
public class RegistVO {
	
	private String cstNo;
	
	@NotBlank(groups = {Default.class, InsertGroup.class, LoginGroup.class})
	private String mberId;

	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstNm;
	
	private String cstClsfcCd;
	
	@Password(groups = {Default.class, InsertGroup.class, LoginGroup.class})
	@NotBlank(groups = {Default.class, InsertGroup.class, LoginGroup.class})
	private String mberPw;
	
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstMail;
	
	private String mailAddr;
	
	private String mberMbti;
	
	@TelNumber(groups = {Default.class, InsertGroup.class})
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstHp;
	
	@TelNumber(regex = "\\d{2,3}-\\d{3,4}-\\d{4}")
	private String mberHomeTel;
	
	private String mberAddr;
	private String mberDetailAddr;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Adult(groups = {Default.class, InsertGroup.class})
	@NotNull(groups = {Default.class, InsertGroup.class})
	private LocalDate cstBirth;

	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstGen;
	
}
