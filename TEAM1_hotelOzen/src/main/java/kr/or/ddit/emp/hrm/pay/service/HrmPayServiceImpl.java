package kr.or.ddit.emp.hrm.pay.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.SalaryGiveVO;
import kr.or.ddit.mybatis.mappers.HrmPayMapper;

@Service
public class HrmPayServiceImpl implements HrmPayService {
	
	@Inject
	private HrmPayMapper mapper;

	@Override
	public void createSalaryGive(SalaryGiveVO salary) {
		// TODO Auto-generated method stub

	}

	@Override
	public SalaryGiveVO retrieveSalaryGive(String slryGiveNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalaryGiveVO> retrieveSalaryGiveList(PaginationInfo paging) {
		int totalRecord = mapper.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return mapper.selectList(paging);
	}

	@Override
	public void removeSalaryGiveList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSalaryGive(String slryGiveNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> createSalaryGiveAuto(PaginationInfo paging, Map<String, Object> data) {
//		String y1 = "2024/";
//		String m1 = "02";
//		String d1 = "/01";
//		String y2 = "2024/";
//		String m2 = "03";
//		String d2 = "/01";
//		
////		data = new HashMap<String, String>();
//		data.put("y1", y1);
//		data.put("m1", m1);
//		data.put("d1", d1);
//		data.put("y2", y2);
//		data.put("m2", m2);
//		data.put("d2", d2);
		int totalRecord = mapper.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		data.put("paging", paging);
		return mapper.selectAutoSalaryCalInQuery(data);
		
	}

}
