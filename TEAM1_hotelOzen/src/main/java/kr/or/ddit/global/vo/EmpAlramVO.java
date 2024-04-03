package kr.or.ddit.global.vo;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpAlramVO {
	private Integer alramNo;
	private String empNo;
	private String message;
	private String readYn;
	private String sanctnNo;
	
	private String rqstNo;
	private LocalDate rqstYmd;
	private String empRqNo;
	
}
