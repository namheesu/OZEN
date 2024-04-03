package kr.or.ddit.emp.myinfo.service;

import java.util.List;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.DclzVO;

public interface EmpMyInfoDclzService {
	
	
	/**
	 * 직원 마이페이지-근태조회
	 * @param empNo : 현재 로그인한 직원 정보
	 * @param paging : D,E,N,O로 분류하여 검색하기 위해 사용
	 * @return List<DclzVO>
	 */
	public List<DclzVO> retrieveDlczList(String empNo, PaginationInfo paging);
}
