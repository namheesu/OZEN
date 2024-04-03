package kr.or.ddit.emp.crm.cstmr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.mybatis.mappers.MberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpCRMCstmrServiceImpl implements EmpCRMCstmrService {

	private final MberMapper dao;
	
	@Override
	public ServiceResult createMember(MberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MberVO retrieveMember(String cstNo) {
		MberVO member = dao.select(cstNo);
		if(member == null) {
			throw new PKNotFoundException(String.format("%s에 해당하는 사용자 없음", cstNo));
		}
		
		return member;
	}

	@Override
	public List<MberVO> retrieveMemberList() {
		
		List<MberVO> memList = dao.selectList();
		
		return memList;
	}

	@Override
	public ServiceResult ModifyMember(MberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MberVO inputData) {
		return null;
	}

}
