package kr.or.ddit.global.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SellingVO {
	
	private LocalDate sellingDate;
	private int total;
	private String setleAdd;
}
