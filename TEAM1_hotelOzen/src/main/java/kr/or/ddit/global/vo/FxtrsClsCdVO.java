package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "fxClsCd")
public class FxtrsClsCdVO {
	
	private String fxClsCd;
	private String fxClsNm;
	
}
