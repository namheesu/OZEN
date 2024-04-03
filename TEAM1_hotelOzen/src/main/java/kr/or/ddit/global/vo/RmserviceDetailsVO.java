package kr.or.ddit.global.vo;

import lombok.Data;

@Data
public class RmserviceDetailsVO {
	
	private String rsodNo;
	private String rsCd;
	private Integer rsdDtlCnt;
	
	private RmserviceVO rmService;
}
