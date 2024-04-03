package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "rsCd")
public class RmserviceVO {
	
	private String rsCd;
	private String rsMenuNm;
	private Integer rsAmnt;
	private String rsUuid;
	private String rsFileNm;
	
}
