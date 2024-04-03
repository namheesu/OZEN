package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.global.vo.CouponVO;
import kr.or.ddit.global.vo.MbrshSetleVO;
import kr.or.ddit.global.vo.SetleVO;

/**
 * @author PC-2
 *
 */
@Mapper
public interface MbrshSetleMapper {
	
	/**
	 * 새로 insert할 멤버십 번호 생성
	 * @return
	 */
	public String selectMbsNo();
	
	/**
	 * 새로 insert할 결제 번호 생성
	 * @return
	 */
	public String selectMbsSetleNo();
	
	/**
	 * 멤버십 가입 테이블에 insert
	 * @param mbrsh
	 * @return
	 */
	public int insertToMbsSetle(MbrshSetleVO mbrsh);
	
	/**
	 * 결제 정보 테이블에 insert
	 * @param setle
	 * @return
	 */
	public int insertToSetle(SetleVO setle);
	
	/**
	 * 멤버십 가입자에게 마일리지 부여
	 * @param cstNo
	 * @param mileage
	 * @return
	 */
	public int insertMileage(@Param("cstNo") String cstNo,@Param("mileage") int mileage);
	
	/**
	 * 멤버십 가입자에게 쿠폰 발급
	 * @param couponList
	 * @return
	 */
	public int insertCoupon(List<CouponVO> couponList);
	
}
