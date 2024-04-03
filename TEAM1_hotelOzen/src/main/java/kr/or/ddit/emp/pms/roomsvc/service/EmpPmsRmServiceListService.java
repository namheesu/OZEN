package kr.or.ddit.emp.pms.roomsvc.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RmSvcOrderVO;
import kr.or.ddit.global.vo.RmserviceOrderVO;
import kr.or.ddit.global.vo.RmserviceVO;

public interface EmpPmsRmServiceListService {
	
	/**
	 * 룸서비스 주문 내역 조회
	 * @param paging
	 * @return
	 */
	public List<RmserviceOrderVO> retieveRmServiceOrderList(PaginationInfo paging);
	
	/**
	 * 룸서비스 조리 내역 조회
	 * @param paging
	 * @return
	 */
	public List<RmserviceOrderVO> retieveRmServiceRqstList(PaginationInfo paging);
	
	/**
	 * 룸서비스 종류 조회
	 * @return
	 */
	public List<RmserviceVO> retieveRmServiceList();
	
	/**
	 * 룸서비스 주문
	 * @return
	 */
	public ServiceResult createRmSvcList(List<RmSvcOrderVO> orders);
}
