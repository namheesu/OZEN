package kr.or.ddit.global.vo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="refndNo")
public class RefndVO {

	private int rnum;
	
	private String refndNo;
	
	private String setleNo;
	
	private String refndPlcyNo;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate refndCncdeYmd;
	
	private Integer refndAmnt;
	
	private String refndYmd;
	
	private String refndSttus;
			
	
	private SetleVO setleVO;
	
	private CstmrVO cstmrVO;
	
	private RefndPolicyVO refndPolicyVO;
	
	
}
