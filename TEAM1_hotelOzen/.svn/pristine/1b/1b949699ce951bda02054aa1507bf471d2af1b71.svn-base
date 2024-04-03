package kr.or.ddit.cstmr.comm.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.MberNoticeVO;
import kr.or.ddit.mybatis.mappers.MberNoticeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MberNoticeServiceImpl implements MberNoticeService {

	private final MberNoticeMapper dao;

	@Override
	public List<MberNoticeVO> retrieveNoticeList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);

		List<MberNoticeVO> noticeList = dao.selectList(paging);
		return noticeList;
	}

	@Override
	public MberNoticeVO retrieveNoticeView(String mberNtNo) {
		MberNoticeVO mbernt = dao.select(mberNtNo);
		if(mbernt == null) {
			throw new PKNotFoundException(String.format("%s에 해당하는 사용자 없음",mberNtNo));
		}
		return mbernt;
	}

	@Override
	public int noticeCount(String mberNtNo) {
		return dao.noticeCount(mberNtNo);
	}
	


}
