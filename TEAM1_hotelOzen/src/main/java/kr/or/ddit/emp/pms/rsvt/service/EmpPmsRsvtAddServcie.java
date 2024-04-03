package kr.or.ddit.emp.pms.rsvt.service;

import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.CstmrVO;

public interface EmpPmsRsvtAddServcie {

	/**
	 * 가용가능 객실 조회
	 * @param roomType
	 * @return
	 */
	public Map<String, Object> retrieveRoomList(String roomTypeNm);
	
	/**
	 * 차량 유무 조회
	 * @param carNo
	 */
	public int retrieveCarYN(String carNo);
		
	/**
	 * 체크인 
	 * @param newChkin
	 * @return
	 */
	public ServiceResult createChkin(ChkinVO newChkin);
}
