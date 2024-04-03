package kr.or.ddit.global.vo;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *	연차VO
 */
@Data
@NoArgsConstructor
public class AnnualVO {
	
	private String anlRnum;
	
	private String empRqNo;
	private String rqstSe;
	private LocalDate rqstPurchsYmd;
	private String anlLeaUseNo;
	private String empNo;
	private LocalDate anlLeaBgnYmd;
	private LocalDate anlLeaEndYmd;
	private String anlLeaRm;
	private String anlLeaInfo;
	private LocalDate anlLeaYmd;
	
	private String empNm;
	private String empRqNm;
}
