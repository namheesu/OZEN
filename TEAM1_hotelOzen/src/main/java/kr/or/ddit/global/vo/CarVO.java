package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="carNo")
public class CarVO {

	private String carNo;
	private String carNm;
	private Integer carLim;
	private String carKind;
	private String carAge;
	
	private RecomCarVO recomCarVO;
	private CstmrVO cstmrVO;
	private ScrapVO scrapVO;
}
