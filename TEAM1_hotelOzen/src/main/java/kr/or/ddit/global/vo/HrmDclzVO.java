package kr.or.ddit.global.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of="dclzNo")
@NoArgsConstructor
public class HrmDclzVO {
	
	private String dclzNo;
	private String empNo;
	private String workTypeCd;
	private LocalDate dclzYmd;
	private LocalDateTime dclzBgnDt;
	private LocalDateTime dclzEndDt;
	private String dclzStts;
	
	private String inTime;
	private String outTime;

}
