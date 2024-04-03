package kr.or.ddit.global.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="chkinNo")
public class ChkinVO {
	
	private String chkinNo;
	private String rmNo;
	private String cstNo;
	private String ciDt;
	private String ciCarNo;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate ciCowillYmd;
	private Integer ciTotalNmpr;
	private Integer ciAdultCnt;
	private Integer ciChildCnt;
	private String ciSetleYn;
	private String ciSetleNo;
	private String ciSeCd;
	private String ciCarKind;
	private String rsvtDtlNo;
	
	
	private CstmrVO cstmr;
	private CarVO car;
	private RoomVO room;
	private SetleVO setle;
	private RsvtDetailsVO rsvtDetails;
	
	private Integer checkinCount;
	
}
