package kr.or.ddit.emp.pos.sanctn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.FxtrsPrchsSttstVO;
import kr.or.ddit.mybatis.mappers.EmpSanctnMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpPosSanctnServiceImpl implements EmpPosSanctnService{
	
	private final EmpSanctnMapper dao;
	
	@Override
	public List<FxtrsPrchsSttstVO> retrieveSanctnList(PaginationInfo paging) {
		
		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<FxtrsPrchsSttstVO> fxtrsList = dao.selectList(paging);
	
		return fxtrsList;
	}

}
