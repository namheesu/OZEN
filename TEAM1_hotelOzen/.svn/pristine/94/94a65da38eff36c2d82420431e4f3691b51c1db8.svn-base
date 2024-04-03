package kr.or.ddit.emp.crm.cstmr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.MberNoticeVO;
import kr.or.ddit.mybatis.mappers.MberNoticeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpCrmCstrmNoticeServiceImpl implements EmpCrmCstrmNoticeService {

	private final MberNoticeMapper dao;
	
	@Override
	public List<MberNoticeVO> retrieveNoticeList(PaginationInfo paging) {
		
		int totalRecord = dao.selectTotalRecord(paging);
		
		paging.setTotalRecord(totalRecord);
		
		List<MberNoticeVO> noticeList = dao.selectList(paging);
		
		return noticeList;
	}

	@Override
	public MberNoticeVO retrieveNotice(String mberNtNo) {
		MberNoticeVO notice = dao.select(mberNtNo);
		return notice;
	}
	
	@Override
	public ServiceResult createNotice(MberNoticeVO notice) {
		ServiceResult result = null;

		int cnt = dao.insert(notice);
		
		if(cnt == 1) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result;
	}

	@Override
	public ServiceResult modifyNotice(MberNoticeVO notice) {
		ServiceResult result = null;

		int cnt = dao.update(notice);
		
		if(cnt == 1) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result;
	}

	@Override
	public ServiceResult removeNotice(String mberNtNo) {
		ServiceResult result = null;

		int cnt = dao.delete(mberNtNo);
		
		if(cnt == 1) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}
}
