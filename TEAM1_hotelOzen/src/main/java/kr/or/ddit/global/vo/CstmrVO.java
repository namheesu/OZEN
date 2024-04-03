package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import kr.or.ddit.global.validate.InsertGroup;
import kr.or.ddit.global.validate.UpdateGroup;
import kr.or.ddit.global.validate.constraints.Adult;
import kr.or.ddit.global.validate.constraints.Password;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="cstNo")
public class CstmrVO implements Serializable {

	private String cstNo;
	
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstMail;
	
	private String mailAddr;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Adult(groups = {Default.class, InsertGroup.class})
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private LocalDate cstBirth;
	
	private String cstClsfcCd;
	
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstGen;
	
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstNm;
	
	@NotBlank(groups = {Default.class, InsertGroup.class})
	private String cstHp;
	
	@Password(groups = {Default.class, UpdateGroup.class})
	private String newPw;
	
	private String age;
	
	private MberVO mber;
	
	private List<RsvtVO> rsvt;
}

