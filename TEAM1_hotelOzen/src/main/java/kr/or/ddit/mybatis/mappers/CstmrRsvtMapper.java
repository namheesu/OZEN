package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.AttatchRmTypeVO;
import kr.or.ddit.global.vo.CouponIsnVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.RecomRoomVO;
import kr.or.ddit.global.vo.RoomTypeVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;

/**
 * @author PC-25
 *
 */
@Mapper
public interface CstmrRsvtMapper extends AbstractCommonMapper<CstmrVO, String>{
	
	
	List<RecomRoomVO> selectRcRm(Map<String, Object> parameterMap);
	
	// 객실타입 조회
	AttatchRmTypeVO selectRmt(String rmType);
	
	// 예약가능 객실 정보 조회
	List<RoomTypeVO> selectRsvtRmt(RsvtVO rsvt);
	
	// 예약정보 저장
	int insertRsvt(RsvtVO rsvt);
	
	// 예약 상세정보 저장
	int insertRsvtDetails(RsvtDetailsVO rsvtDetail);
	
	// 비회원정보 저장
	int insertNber(CstmrVO nber);
	
	// 결제정보 저장
	int insertSetle(SetleVO setle);
	
	// 비회원번호 발급
	String selectNewNberCstNo();
	
	// 결제번호 발급
	String selectNewSelteNo();
	
	// 예약번호 발급
	String selectNewRsvtNo();
	
	// 예약상세 번호 발급
	String selectRsvtDetailNo();
	
	// 보유 쿠폰 조회
	List<CouponIsnVO> selectCouponIsn(Map<String, Object> parameterMap);
	
	// 사용쿠폰 수정
	int updateCouponIsn(CouponIsnVO couponIsnVO);
}
