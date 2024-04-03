package kr.or.ddit.emp.pms.stay.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;

public interface EmpPmsStayChkinListService {
	
	/**
	 * 체크인 예정 명단 조회
	 * @param paging
	 * @return
	 */
	public List<RsvtVO> retrieveChkinList(PaginationInfo paging);
	
	/**
	 * 상세조회
	 * @param rsvtNo
	 * @return
	 */
	public RsvtDetailsVO retrieveRsvt(String rsvtDtlNo);
	
	/**
	 * 체크인
	 * @param newChkin
	 * @return
	 */
	public ServiceResult createChkin(ChkinVO newChkin);
}
