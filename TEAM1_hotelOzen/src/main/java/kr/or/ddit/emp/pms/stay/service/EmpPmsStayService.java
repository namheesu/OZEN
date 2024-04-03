package kr.or.ddit.emp.pms.stay.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkoutVO;

public interface EmpPmsStayService {

	public List<ChkoutVO> retreieveStayList(PaginationInfo paging);
	
	public Map<String, Object> retreieveStay(String chkinNo);
}
