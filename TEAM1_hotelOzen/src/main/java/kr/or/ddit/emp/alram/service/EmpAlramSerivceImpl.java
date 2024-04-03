package kr.or.ddit.emp.alram.service;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.EmpAlramVO;
import kr.or.ddit.mybatis.mappers.EmpAlramMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpAlramSerivceImpl implements EmpAlramService {

	private final EmpAlramMapper dao;
	
	@Override
	public EmpAlramVO retrieveAlram(String empRqNo) {
		EmpAlramVO alramVO = dao.selectAlram(empRqNo);
		return alramVO;
	}

}
