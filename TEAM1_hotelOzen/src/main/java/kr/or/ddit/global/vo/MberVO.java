package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.groups.Default;

import kr.or.ddit.global.validate.UpdateGroup;
import kr.or.ddit.global.validate.constraints.Password;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= "cstNo")
public class MberVO implements Serializable {
	private int rnum;
	private String cstNo;
	private String mberId;
	private String mberPw;
	@Password(groups = {Default.class, UpdateGroup.class})
	private String newPw;
	private String mberSpclNote;
	private String mberMbti;
	private String mberHomeTel;
	private String mberAddr;
	private boolean mberSecsnYn;
	private String mberSbscrbYmd;
	
	private int mberMileage;
	
	private List<String> userRoles;
	
	private CstmrVO cst;
	
	private List<MbrshSetleVO> mbrsh;
	
	private List<CouponVO> couponList;
	
	private int totalCoupon;
	private int availCoupon;
	private int unAvailCoupon;
	private int usedCoupon;
	
	private List<RsvtVO> rsvtList;
}
