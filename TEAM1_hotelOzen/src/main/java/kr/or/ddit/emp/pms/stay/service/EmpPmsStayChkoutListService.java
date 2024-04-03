package kr.or.ddit.emp.pms.stay.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkoutVO;

public interface EmpPmsStayChkoutListService {

	public List<ChkoutVO> retreieveChkoutList(PaginationInfo paging);
	
	public Map<String, Object> retreieveChkout(String chkinNo);
	
	public ServiceResult modifyChkout(String chkinNo);
}
