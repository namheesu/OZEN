package kr.or.ddit.global.vo;

import java.util.List;

import lombok.Data;

@Data
public class MbrshGrdVO {
	
	private String mbsGrdCd;
	private String mbsGrdNm;
	private Integer mbsGrdAmnt;
	private String mbsGrdPrk;
	
	private Integer discount;
	
	private Integer totalCoupon;
	
	private String accomCoupon;
	private Integer accomCouponCnt;
	
	private Integer bnfCouponCnt;
	
	private List<CouponVO> couponList;
	
	

}
