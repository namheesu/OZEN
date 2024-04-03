package kr.or.ddit.emp.pbl.schdl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.EmpSchdlVO;
import kr.or.ddit.mybatis.mappers.EmpSchdlMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpSchdlServiceImpl implements EmpSchdlService {
	
	private final EmpSchdlMapper dao;

	@Override
	public List<EmpSchdlVO> retrieveSchdlList(String empNo) {
		List<EmpSchdlVO> schdlList = dao.empSchdlList(empNo);
		if(schdlList == null) {
			throw new PKNotFoundException(String.format("해당하는 사용자 없음"));
		}
		return schdlList;
	}

	@Override
	public int insertEmpSchdl(EmpSchdlVO newSchdl) {
		return dao.insertEmpSchdl(newSchdl);
	}

	@Override
	public int deleteEmpSchdl(EmpSchdlVO deleteSchdl) {
		return dao.deleteEmpSchdl(deleteSchdl);
	}

}
