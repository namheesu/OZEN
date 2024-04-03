package kr.or.ddit.emp.pbl.dclz.service;

import java.util.List;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.HrmAnnualVO;

/**
 * 연차 관리 Business Logic Layer
 *
 */
public interface YrycService {
	
//개별 직원의 연차 목록 조회는 아마 업무현황에서 진행될 예정	
// 연차 상세 조회에서 수정 삭제가 가능하도록 구현할 예정
// 연차 신청 페이지 
	
	/**
	 * 연차 상세 조회(인사관리 연차VO 사용)
	 * @param anlLeaUseNo
	 * @return
	 */
	public HrmAnnualVO retrieveAnnual(String anlLeaUseNo);
	
	/**
	 * 연차 목록 조회(인사관리 연차VO 사용)
	 * @param paging
	 * @return
	 */
	public List<HrmAnnualVO> retrieveAnnualList(PaginationInfo paging);
	
	/**
	 * 연차 신규 등록
	 * @param annual
	 */
	public void createAnnual(HrmAnnualVO annual);
	
//	/**
//	 * 연차 기록 수정
//	 * @param annual
//	 */
//	public void modifyAnnual(AnnualVO annual);
	
	/**
	 * 연자 신청자 입장에서 연차 기록 수정
	 * @param annual
	 */
	public void modifyAnnualOfSender(HrmAnnualVO annual);
	
	/**
	 * 연차 결재자 입장에서 연차 기록 수정(승인 또는 반려)
	 * @param annual
	 */
	public void modifyAnnualOfReceiver(HrmAnnualVO annual);
	
	/**
	 * 연차 기록 삭제
	 * @param anlLeaUseNo
	 */
	public void removeAnnual(String anlLeaUseNo);
	
	/**
	 * 연차를 신청할 때 결재권자(팀장) 정보 조회
	 * @param empNo
	 * @return
	 */
	public HrmAnnualVO retrieveReceiver(String empNo);
	

}
