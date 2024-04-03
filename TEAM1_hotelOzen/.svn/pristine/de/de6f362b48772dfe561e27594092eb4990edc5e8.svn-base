package kr.or.ddit.emp.pms.rsvt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.mybatis.mappers.EmpRsvtMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsRsvtListServiceImpl implements EmpPmsRsvtListService {

	private final EmpRsvtMapper dao;
	
	@Override
	public List<RsvtVO> retrieveRsvtList(PaginationInfo paging) {
		
		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<RsvtVO> rsvtList = dao.selectList(paging);
		return rsvtList;
	}

	@Override
	public RsvtVO retrieveRsvt(String rsvtNo) {
		RsvtVO rsvt = dao.select(rsvtNo);
		if(rsvt == null) {
			throw new PKNotFoundException(String.format("%s에 해당하는 사용자 없음", rsvtNo));
		}
		return rsvt;
	}

	@Override
	public boolean modifyRsvt(String rsvtNo) {
		return dao.updateCXL(rsvtNo) > 0;
	}



	
}
