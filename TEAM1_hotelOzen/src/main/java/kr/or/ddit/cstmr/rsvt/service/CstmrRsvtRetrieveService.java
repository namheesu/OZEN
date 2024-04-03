package kr.or.ddit.cstmr.rsvt.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;

public interface CstmrRsvtRetrieveService {

	/**
	 * 비회원 예약 조회
	 * 
	 * @param rsvtData
	 * @return
	 */
	public RsvtVO retrieveNberRsvt(CstmrVO cstmr);

	/**
	 * 회원 정보 조회
	 * 
	 * @param cstNo
	 * @return
	 */
	public MberVO retrieveMber(String cstNo);

	/**
	 * 회원 진행중인 예약목록 상세 조회
	 * 
	 * @param rsvtNo
	 * @return
	 */
	public List<RsvtDetailsVO> retrieveRsvtDetails(String rsvtNo);

	/**
	 * 회원 진행중인 예약목록 조회
	 * 
	 * @param cstNo
	 * @return
	 */
	public List<RsvtVO> retrieveMberRsvt(String cstNo);

	/**
	 * 회원 투숙완료목록 상세 조회
	 * 
	 * @param rsvtNo
	 * @return
	 */
	public List<RsvtDetailsVO> retrieveEndRsvtDetails(String rsvtNo);

	/**
	 * 회원 투숙완료목록 조회
	 * 
	 * @param cstNo
	 * @return
	 */
	public List<RsvtVO> retrieveMberEndRsvt(String cstNo);

	/**
	 * 회원 예약취소목록 상세 조회
	 * 
	 * @param rsvtNo
	 * @return
	 */
	public List<RsvtDetailsVO> retrieveCancelRsvtDetails(String rsvtNo);

	/**
	 * 회원 예약취소목록 조회
	 * 
	 * @param cstNo
	 * @return
	 */
	public List<RsvtVO> retrieveMberCancelRsvt(String cstNo);

	/**
	 * 결제정보 조회
	 * 
	 * @param setelNo
	 * @return
	 */
	public SetleVO retrieveSetle(String setelNo);

	/**
	 * 예약 취소
	 * 
	 * @param rsvtNo
	 * @return
	 */
	public ServiceResult rsvtCancel(Map<String, Object> requestData);


}
