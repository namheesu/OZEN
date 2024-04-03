package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import kr.or.ddit.global.validate.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "rsvtNo")

public class RsvtVO implements Serializable {
	
	private int rnum;
	
	private String rsvtNo;
	
	private String cstNo;
	
	private LocalDate rsvtYmd;
	
	private Integer rsvtAmnt;
	
	private String rsvtCnclYn;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate rsvtCheckinYmd;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate rsvtCheckoutYmd;
	
	private Integer rsvtRoomCnt;
	
	private Integer rsvtAdultCnt;
	
	private Integer rsvtChildCnt;
	
	private String rsvtSetleNo;
	
	private Integer rsvtNberCnt;
	
	private long rsvtDay;
	
	private Integer rsvtMaxNberCnt;
	
	
	
	private CstmrVO cstmr; 
	
	private List<RsvtDetailsVO> rsvtDetails;
	
	private RecomRoomVO rcrm;
	
	private RoomVO room;
	
	private LocalDate rsvtDate;
	private int rsvtCount;
	
}
