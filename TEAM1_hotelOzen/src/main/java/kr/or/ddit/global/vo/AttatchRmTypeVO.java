package kr.or.ddit.global.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="attNo")
public class AttatchRmTypeVO {
	
	private String attNo;
	private String rmtTypeCd;
	private String attRmtFilename01;
	private String attRmtFilename02;
	private String attRmtFilename03;
	private String attRmtFilename04;
	private String attRmtFilename05;
	private String attRmtFilename06;
	
	private RoomTypeVO rmtype;

}
