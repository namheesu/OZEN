package kr.or.ddit.emp.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.mybatis.mappers.EmpMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpAuthServiceImpl implements EmpAuthService {

	private final EmpMapper dao;
	
	@Override
	public ServiceResult checkUser(EmpVO emp) {
		ServiceResult result = null;
		
		EmpVO foundEmp = dao.findEmpUser(emp);
		
		if(foundEmp != null) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public String findEmpNo(EmpVO emp) {
		return dao.findEmpUser(emp).getEmpNo();
	}

	@Override
	public ServiceResult changePwd(EmpVO emp) {
		ServiceResult result = null;
		
		int changeResult = dao.changePwd(emp);
		if(changeResult == 1) {
			result = ServiceResult.OK;

		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public List<EmpVO> loginList() {
		return dao.loginEmpVOs();
	}
	
}
