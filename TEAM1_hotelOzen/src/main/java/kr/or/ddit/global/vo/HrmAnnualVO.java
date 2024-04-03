package kr.or.ddit.global.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 인사관리에서 사용하는 연차VO
 *
 */
@Data
@NoArgsConstructor
public class HrmAnnualVO {
	private String rnum;
	
	private String empRqNo;
	private String rqstSe;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate rqstPurchsYmd;
	private String anlLeaUseNo;
	private String empNo;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate anlLeaBgnYmd;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate anlLeaEndYmd;
	private String anlLeaRm;
	private String anlLeaInfo;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate anlLeaYmd;
	
	private String empNm;
	private String empRqNm;
	
	private int anlLeaGiveYmd;
	private int anlLeaGiveAmnt;
	private int empAnnualLeave;
	
	private String empDept;
	private String empJbgd;
	private String empTel;
	private int useDate;

}
