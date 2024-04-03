package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of= {"empNo", "workDate"})
public class WorkSchdlVO implements Serializable{
	
	private int rnum;
	
	private String empNo;
	private String empNm;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate workDate;
	private String workType;
	
	private String empDept;
	
	//한달 동안의 근무타입지정
	private List<String> monthWorkSchdl; // ['D', 'D', 'N']
	

}
