package kr.or.ddit.global.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "rqstNo")
public class FxtrsRqstVO {

	private String rnum;
	
	private String rqstNo;
	private String rqstSn;
	private String empNo;
	private LocalDate rqstYmd;
	private Integer rqstAmnt;
	private String rqstSe;
	private LocalDate rqstRqYmd;
	private LocalDate rqstPurchsYmd;
	private String empRqNo;
	private String empPurchsNo;
	
	private String empNm;
	private String empRqNm;
	private String empPurchsNm;
	
	private EmpVO emp;
	private List<FxtrsRqstDetailsVO> fxtrsRqstDtl;
}
