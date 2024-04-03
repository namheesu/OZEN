package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="refndPlcyNo")
public class RefndPolicyVO {

	private String refndPlcyNo;
	
	private Integer refndPlcyRemndrYmd;
	
	private Integer refndPlcyRate;
}
