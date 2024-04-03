package kr.or.ddit.emp.pms.room.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RoomVO;

public interface EmpPmsRoomListService {
	
	/**
	 * 객실 조회
	 * @return
	 */
	public Map<String, Object> retieveRoomList(PaginationInfo paging);
	
	/**
	 * 객실 상세 조회
	 * @param roomNo
	 * @return
	 */
	public RoomVO retieveRoom(String roomNo);
	
	/**
	 * 객실 청소상태 변경 
	 * @param roomNo
	 * @return
	 */
	public boolean modifyRoom(String roomNo);
}
