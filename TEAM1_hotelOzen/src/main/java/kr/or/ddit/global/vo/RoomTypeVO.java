package kr.or.ddit.global.vo;

import lombok.Data;

@Data
public class RoomTypeVO {
	private String rmtTypeCd;
	private Integer rmtMaxnbrCnt;
	private int rmtAmnt;
	private String rmtBedType;
	private Integer rmtBedCnt;
	private Integer rmtLabel;
	private String rmtNmDetails;
	private String rmtChkinTime;
	private String rmtChkoutTime;
	private String rmtNm;
	
	private int count;
	
	private AttatchRmTypeVO attRmt;
}
