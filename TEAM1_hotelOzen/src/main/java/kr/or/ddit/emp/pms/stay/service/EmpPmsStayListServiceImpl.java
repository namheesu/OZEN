package kr.or.ddit.emp.pms.stay.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkoutVO;
import kr.or.ddit.global.vo.RmserviceOrderVO;
import kr.or.ddit.mybatis.mappers.EmpStayListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsStayListServiceImpl implements EmpPmsStayListService {

	private final EmpStayListMapper dao;
	
	@Override
	public List<ChkoutVO> retreieveStayList(PaginationInfo paging) {

		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<ChkoutVO> stayList = dao.selectList(paging);
		
		return stayList;
	}

	
	@Override
	public Map<String, Object> retreieveStay(String chkinNo) {
		
		Map<String, Object> staydata = new HashMap<>();
		
		List<ChkoutVO> stay = dao.selectStay(chkinNo);
		staydata.put("stay", stay);
		log.info("##################################stay{}", stay);
		
		List<RmserviceOrderVO> rsvtDtl =  dao.selectRms(chkinNo);
		log.info("##################################rsvtDtl{}", rsvtDtl);
		if (rsvtDtl.size() > 0) {
		    for (RmserviceOrderVO order : rsvtDtl) {
		    	staydata.put("order", order);
		    }
		}
		log.info("##################################staydata{}", staydata);

		
		return staydata;
	}

}
