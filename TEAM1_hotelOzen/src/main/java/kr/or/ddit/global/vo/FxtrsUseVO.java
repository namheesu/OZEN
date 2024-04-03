package kr.or.ddit.global.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= "fxuseNo" )
public class FxtrsUseVO {

	private String rnum;
	
	private String fxuseNo;
	private String empNo;
	private LocalDate fxuseYmd;
	private String rmNo;
	
	private EmpVO emp;
	
	private List<FxtrsUseDetailsVO> fxtrsUseDtl;
}
