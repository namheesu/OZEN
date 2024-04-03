package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= "fxCd" )
public class FxtrsVO {
	
	private int rnum;
	
	private String fxClsCd;
	private Integer fxUnit;
	private String fxCd;
	private String fxNm;
	private Integer fxPresCnt;
	private Integer fxTtrtnCnt;
	private Integer fxAmnt;
	
	private FxtrsClsCdVO fxtrsClsCd;
	
}
