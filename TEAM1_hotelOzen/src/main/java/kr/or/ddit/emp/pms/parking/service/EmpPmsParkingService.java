package kr.or.ddit.emp.pms.parking.service;

import java.util.List;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ParkingAreaVO;
import kr.or.ddit.global.vo.ParkingVO;

public interface EmpPmsParkingService {

	/**
	 * 차량 조회 
	 * @param paging
	 * @return
	 */
	public List<ParkingVO> retrieveParkingList(PaginationInfo paging);
	
	/**
	 * 주차장 현황 조회
	 * @return
	 */
	public List<ParkingAreaVO> retrieveParkingAreaList();
}
