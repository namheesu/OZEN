package kr.or.ddit.emp.pms.room.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RoomVO;
import kr.or.ddit.mybatis.mappers.EmpRoomMapper;

@Service
public class EmpPmsRoomListServiceImpl implements EmpPmsRoomListService {

	@Inject
	private EmpRoomMapper dao;
	
	@Override
	public Map<String, Object> retieveRoomList(PaginationInfo paging) {
		
		Map<String, Object> roomListMap = new HashMap<>();
		
		int totalRecord = dao.selectTotalRecord(paging);
		roomListMap.put("totalRecord", totalRecord);
		paging.setTotalRecord(totalRecord);
		
		int emptyRecord = dao.selectEmptyTotal(); // 전체 예약수
		roomListMap.put("emptyRecord", emptyRecord);
		
		int stayRecord = dao.selectStayTotal(); //투숙 수
		roomListMap.put("stayRecord", stayRecord);
		
		int cleanRecord = dao.selectCleanTotal(); //청소중인객실 수
		roomListMap.put("cleanRecord", cleanRecord);
		
		int breakRecord = dao.selectBreakTotal(); // 고장 객실 수
		roomListMap.put("breakRecord", breakRecord);
		
		List<RoomVO> roomList =  dao.selectList(paging);
		roomListMap.put("roomList", roomList);
		return roomListMap;
	}

	@Override
	public RoomVO retieveRoom(String roomNo) {
		RoomVO room = dao.select(roomNo);
		return room;
	}

	@Override
	public boolean modifyRoom(String roomNo) {
		return dao.updateRoom(roomNo) > 0;
	}

}
