package kr.or.ddit.emp.pbl.dclz.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.HrmAnnualVO;
import kr.or.ddit.mybatis.mappers.HrmYrycMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class YrycServiceImpl implements YrycService {
	
	@Inject
	private HrmYrycMapper mapper;
	

	@Override
	public HrmAnnualVO retrieveAnnual(String anlLeaUseNo) {
		HrmAnnualVO annual = mapper.select(anlLeaUseNo);
		if(annual == null)
			throw new PKNotFoundException(String.format("%s 연차 정보 없음.", anlLeaUseNo));
		return annual;
	}

	@Override
	public List<HrmAnnualVO> retrieveAnnualList(PaginationInfo paging) {
		int totalRecord= mapper.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return mapper.selectList(paging);
	}

	@Override
	public void createAnnual(HrmAnnualVO annual) {
		annual.setAnlLeaUseNo(mapper.selectAnlLeaUseNo());
		mapper.insert(annual);
	}

	@Override
	public void modifyAnnualOfSender(HrmAnnualVO annual) {
		mapper.updateOfSender(annual);
	}

	@Override
	public void modifyAnnualOfReceiver(HrmAnnualVO annual) {
		mapper.updateOfReceiver(annual);
	}
	
	@Override
	public void removeAnnual(String anlLeaUseNo) {
		mapper.delete(anlLeaUseNo);
	}

	@Override
	public HrmAnnualVO retrieveReceiver(String empNo) {
		return mapper.selectAnlReciverEmpNo(empNo);
	}

}
