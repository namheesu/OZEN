package kr.or.ddit.global.vo;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="cpnNo")
public class CouponVO {

	private String cpnNo;
	private String cpnkNo;
	private String cstNo;
	private String cpnkNm;
	private String cpnUse;
	private int cpnPrvCnt;
	private Integer cpnDscntPrice;
	private LocalDate cpnIssuYmd;
	
	private LocalDate cpnExprtYmd;
	
//	Y:사용 가능 U:이미 사용함 N:기한이 지나서 사용 불가
	private String cpnAvailYn;
	private LocalDate cpnUseYmd;
}
