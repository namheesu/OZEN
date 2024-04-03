package kr.or.ddit.global.vo;

import java.util.List;

import lombok.Data;

@Data
public class RoomVO {
	
	private String rnum;
	
	private String rmNo;
	private String rmtTypeCd;
	private String rmAvlblYn;
	private String rmAvlblDetails;
	private String rmClean;
	
	private List<RsvtDetailsVO> rsvtDetails; 
	private RoomTypeVO roomType;
}
