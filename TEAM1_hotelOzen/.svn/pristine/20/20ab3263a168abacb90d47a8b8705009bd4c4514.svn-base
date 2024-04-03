package kr.or.ddit.emp.crm.cstmr.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.MberNoticeVO;

public interface EmpCrmCstrmNoticeService {
	
	
	/**
	 * crm 직원 공지사항 조회 메서드
	 * @param paging
	 * @return
	 */
	public List<MberNoticeVO> retrieveNoticeList(PaginationInfo paging);

	public MberNoticeVO retrieveNotice(String mberNtNo);
	
	public ServiceResult createNotice(MberNoticeVO notice);
	
	public ServiceResult modifyNotice(MberNoticeVO notice);
	
	public ServiceResult removeNotice(String mberNtNo);
	
}
