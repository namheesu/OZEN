package kr.or.ddit.emp.pms.rsvt.service;

import java.util.List;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RsvtVO;

public interface EmpPmsRsvtListService {

	/**
	 * 예약내역 조회
	 * @param paging
	 * @return
	 */
	public List<RsvtVO> retrieveRsvtList(PaginationInfo paging);
	
	/**
	 * 예약 상세 조회
	 * @param rsvtNo
	 * @return
	 */
	public RsvtVO retrieveRsvt(String rsvtNo);
	
	
	/**
	 * 예약 취소
	 * @param rsvtNo
	 */
	public boolean modifyRsvt(String rsvtNo);
	
}
