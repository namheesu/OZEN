package kr.or.ddit.emp.hrm.pay.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.SalaryGiveVO;

public interface HrmPayService {
	public void createSalaryGive(SalaryGiveVO salary);
	public List<Map<String, Object>> createSalaryGiveAuto(PaginationInfo paging, Map<String, Object> data);
	public SalaryGiveVO retrieveSalaryGive(String slryGiveNo);
	public List<SalaryGiveVO> retrieveSalaryGiveList(PaginationInfo paging);
	public void removeSalaryGiveList();
	public void removeSalaryGive(String slryGiveNo);

}
