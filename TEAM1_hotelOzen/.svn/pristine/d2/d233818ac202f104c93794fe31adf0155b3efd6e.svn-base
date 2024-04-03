package kr.or.ddit.emp.myinfo.service;

import javax.security.sasl.AuthenticationException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.security.EmpVOWrapper;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.mybatis.mappers.EmpMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpMyInfoServiceImpl implements EmpMyInfoService {

	private final EmpMapper dao;
	
	@Override
	public ServiceResult modifyInfo(EmpVO empVO) {
		ServiceResult result = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		EmpVOWrapper principal = (EmpVOWrapper) authentication.getPrincipal();
		EmpVO empUser = principal.getEmpUser();
		
		try{
			if(!empUser.getEmpNo().contains(empVO.getEmpNo())) {
				throw new AuthenticationException(empVO.getEmpNo());
			}else {
				result = dao.update(empVO) > 0? ServiceResult.OK : ServiceResult.FAIL;				
			}
		}catch (AuthenticationException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		
		return result;
	}

	@Override
	public ServiceResult removeProfl(String empNo) {
		ServiceResult result = null;
		
		int daoresult = dao.deleteProfl(empNo);
		
		if(daoresult == 1) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result;
	}

}
