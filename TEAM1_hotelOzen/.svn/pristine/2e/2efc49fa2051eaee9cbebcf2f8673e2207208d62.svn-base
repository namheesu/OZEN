package kr.or.ddit.cstmr.rsvt.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.AttatchRmTypeVO;
import kr.or.ddit.global.vo.CouponIsnVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RecomRoomVO;
import kr.or.ddit.global.vo.RoomTypeVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;

public interface CstmrRsvtService {
	
	/**
	 * 회원 나이 조회
	 * @return
	 */
	public CstmrVO retrieveCstmrAge(String cstNo);
	
	/**
	 * 객실 타입 추천 조회
	 * @param customerData 
	 * @return
	 */
	public List<RecomRoomVO> retrieveRcRm(Map<String, Object> customerData);
	
	/**
	 * 객실타입 조회
	 * @return
	 */
	public AttatchRmTypeVO retrieveRmt(String rmType);
	
	
	/**
	 * 가용객실 조회
	 * @param rsvtData
	 * @return
	 */
	public List<RoomTypeVO> retrieveRsvtRmt(RsvtVO rsvtData);
	
	
	/**
	 * 예약 정보 등록
	 * @param newRsvt
	 * @return
	 */
	public ServiceResult createNewRsvt(Map<String,Object> rsvtData);
	
	/**
	 * 현재 사용자 조회
	 * @param cstNo
	 * @return
	 */
	public MberVO retrieveMber(String cstNo);
	
	
	/**
	 * 보유 쿠폰 및 사용 가능 쿠폰 조회
	 * @param parameterMap
	 * @return
	 */
	public List<CouponIsnVO> retrieveCoupon(Map<String,Object> parameterMap);
	
}
