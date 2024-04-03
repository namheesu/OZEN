package kr.or.ddit.emp.pms.fxtrs.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpAlramVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import kr.or.ddit.global.vo.FxtrsVO;

public interface EmpPmsFxtrsRqstService {

	/**
	 * 비품 요청서 목록 조회
	 * @param paging
	 * @return
	 */
	public Map<String, Object> retrieveFxtrsRqstList(PaginationInfo paging);
	
	//비품 요청번호 생성
	public String retrieveRqstNo();
	
	// 요청 승인 결재자 조회
	public EmpVO retrieveRqstEmp();
	
	/**
	 * 비품 상세 조회
	 * @param fxCd 비품코드
	 * @return
	 */
	public FxtrsVO retrieveFxtrs(String fxCd);
	
	// 비품 요청 insert
	public ServiceResult createFxtrsRqst(Map<String, Object> fxData);
	
	// 비품 요청 상세 insert
	public ServiceResult createFxtrsRqstDtl(Map<String, Object> fxData);
	
	/**
	 * 비품 요청서 상세 조회
	 * @return
	 */
	public Map<String, Object> retrieveFxtrsRqst(String fxtrsRqstNo);
	
	/**
	 * 비품 요청 승인
	 * @param fxRqstNo
	 * @return
	 */
	public ServiceResult updateFxtrsApproval(String fxRqstNo);
	
	/**
	 * 비품 요청 거부
	 * @param fxRqstNo
	 * @return
	 */
	public ServiceResult updateFxtrsRecusal(String fxRqstNo);
	
	
	/**
	 * 비품 알림 insert
	 * @param empAlram
	 * @return
	 */
	public int createEmpAlram(EmpAlramVO empAlram);
	
	
	/**
	 * 비품 구매요청 승인
	 * @param fxtrsRqstVO
	 * @return
	 */
	public ServiceResult updateFxtrsPurOk(FxtrsRqstVO fxtrsRqstVO);
	
	/**
	 * 비품 구매요청 반려
	 * @param fxtrsRqstVO
	 * @return
	 */
	public ServiceResult updateFxtrsPurDec(FxtrsRqstVO fxtrsRqstVO);
}
