package kr.or.ddit.emp.pms.fxtrs.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.FxtrsClsCdVO;
import kr.or.ddit.global.vo.FxtrsUseVO;
import kr.or.ddit.global.vo.FxtrsVO;
import kr.or.ddit.global.vo.RoomVO;

public interface EmpPmsFxtrsUseService {
	/**
	 * 비품 사용내역리스트 조회
	 * @param paging
	 * @return
	 */
	public List<FxtrsUseVO> retrieveFxtrsUseList(PaginationInfo paging);
	
	/**
	 * 비품 상세 조회
	 * @param fxuseNo
	 * @return
	 */
	public Map<String, Object> retrieveFxtrs(String fxuseNo);

	//비품 사용서 일련번호
	public String retrieveFxUseNo();
	
	//비품분류명 조회
	public List<FxtrsClsCdVO> retrieveFxtrsCd();
	
	//비품분류별 비품명 조회
	public List<FxtrsVO> retrieveFxtrsNmList(String fxtrsCd);
	
	// 층별 객실호수 조회
	public List<RoomVO> retrievefloorList(String floor);
	
	//비품 사용 create
	public ServiceResult createFxtrsUse(Map<String, Object> fxData);
	
	//비품 사용 상세 create
	public ServiceResult createFxtrsUseDtl(Map<String, Object> fxData);
}
