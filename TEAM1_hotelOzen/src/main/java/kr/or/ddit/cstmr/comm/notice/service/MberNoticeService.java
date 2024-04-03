package kr.or.ddit.cstmr.comm.notice.service;

import java.util.List;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.MberNoticeVO;

public interface MberNoticeService {

	public List<MberNoticeVO> retrieveNoticeList(PaginationInfo paging);
	
	public MberNoticeVO retrieveNoticeView(String mberNtNo);
	
	/**
	 * 조회수 증가 메소드
	 * @param mberNtNo
	 * @return
	 */
	public int noticeCount(String mberNtNo);
}
