package kr.or.ddit.emp.myinfo.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.EmpVO;

public interface EmpMyInfoService {
	
	public ServiceResult modifyInfo(EmpVO empVO);
	
	public ServiceResult removeProfl(String empNo);
}
