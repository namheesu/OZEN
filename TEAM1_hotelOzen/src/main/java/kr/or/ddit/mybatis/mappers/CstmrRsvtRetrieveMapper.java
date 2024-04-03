package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.RefndVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;

@Mapper
public interface CstmrRsvtRetrieveMapper extends AbstractCommonMapper<RsvtVO, String>{

	/**
	 * 비회원 단건 예약조회
	 * @param rsvtData
	 * @return
	 */
	RsvtVO selectNberRsvt(CstmrVO cstmrVO);
	
	/**
	 * 비회원 예약 상세 조회
	 * @param rsvtNo
	 * @return
	 */
	List<RsvtDetailsVO> selectNberRsvtDetailsList(String rsvtNo);
	
	/**
	 * 회원 예약진행중 리스트 조회
	 * @param cstNo
	 * @return
	 */
	List<RsvtVO> selectMberRsvtList(String cstNo);
	
	/**
	 * 예약진행중 상세 조회
	 * @param rsvtNo
	 * @return
	 */
	List<RsvtDetailsVO> selectRsvtDetailsList(String rsvtNo);
	
	
	/**
	 * 회원 투숙완료 리스트 조회
	 * @param cstNo
	 * @return
	 */
	List<RsvtVO> selectMberEndRsvtList(String cstNo);
	
	/**
	 * 투숙완료 상세 조회
	 * @param rsvtNo
	 * @return
	 */
	List<RsvtDetailsVO> selectEndRsvtDetailsList(String rsvtNo);
	
	/**
	 * 회원 예약취소 리스트 조회
	 * @param cstNo
	 * @return
	 */
	List<RsvtVO> selectMberCancelRsvtList(String cstNo);
	
	/**
	 * 예약취소 상세 조회
	 * @param rsvtNo
	 * @return
	 */
	List<RsvtDetailsVO> selectCancelRsvtDetailsList(String rsvtNo);
	
	/**
	 * 결제 정보 조회
	 * @param setleNo
	 * @return
	 */
	SetleVO selectSetle(String setleNo);
	
	/**
	 * 예약취소
	 * @param rsvtNo
	 * @return
	 */
	int rsvtCancel(String rsvtNo); 
	
	/**
	 * 환불정보 저장
	 * @param refndVO
	 * @return
	 */
	int insertRefnd(RefndVO refndVO);
	
	/**
	 * 예약 취소 시 결제상태 변경
	 * @param rsvtNo
	 * @return
	 */
	int updateSetle(String setleNo);
	
	/**
	 * 환불번호 생성
	 * @return
	 */
	String selectNewRefndNo();
	
	/**
	 * 예약상세 정보 수정
	 * @param rsvtNo
	 * @return
	 */
	int updateRsvtDetails(String rsvtNo);

}
