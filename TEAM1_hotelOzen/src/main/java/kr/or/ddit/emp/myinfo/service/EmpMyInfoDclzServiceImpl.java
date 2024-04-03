package kr.or.ddit.emp.myinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.DclzVO;
import kr.or.ddit.mybatis.mappers.DclzMapper;
import lombok.RequiredArgsConstructor;

/**
 * @author 김승연
 * 직원 마이페이지 근태 목록 조회 컨트롤러
 */
@Service
@RequiredArgsConstructor
public class EmpMyInfoDclzServiceImpl implements EmpMyInfoDclzService {

	private final DclzMapper dao;
	
	@Override
	public List<DclzVO> retrieveDlczList(String empNo, PaginationInfo paging) {
		
		int totalRecord = dao.selectTotalRecord(empNo, paging);
		paging.setTotalRecord(totalRecord);
		
		List<DclzVO> dlczList = dao.selectList(empNo, paging);
		
		return dlczList;
	}

}
