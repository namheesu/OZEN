package kr.or.ddit.emp.pbl.oprtnstts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import kr.or.ddit.mybatis.mappers.EmpFxtrsRqstMapper;
import kr.or.ddit.mybatis.mappers.OprtnSttsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpOprtnsttsServiceImpl implements EmpOprtnsttsService {

	private final OprtnSttsMapper dao;
	
	private final EmpFxtrsRqstMapper fxDao;
	
	@Override
	public List<FxtrsRqstVO> fxtrsStatusList(String empNo , PaginationInfo paging) {
		int totalRecord = dao.fxtrsSelectTotalRecord(paging, empNo);
		paging.setTotalRecord(totalRecord);
		
		List<FxtrsRqstVO> fxtrsList = dao.fxtrsSelectList(paging, empNo);
		log.info("fxtrsListServiceeeee {}",fxtrsList);
		return fxtrsList;
	}

	@Override
	public List<AnnualVO> annualStatusList(String empNo, PaginationInfo paging) {
		int totalRecord = dao.annSelectTotalRecord(paging, empNo);
		paging.setTotalRecord(totalRecord);
		
		List<AnnualVO> annualList = dao.annSelectList(paging, empNo);
		log.info("annualListServiceeee {}", annualList);
		return annualList;
	}

	@Override
	public Map<String, Object> retrieveFxtrsRqst(String fxtrsRqstNo) {
		Map<String, Object> fxtrs = new HashMap<>();
		
		FxtrsRqstVO fxtrsRqst = dao.selectFxtrsRqst(fxtrsRqstNo);
		fxtrs.put("fxtrsRqst", fxtrsRqst);
		
		String empRqNo = fxtrsRqst.getEmpRqNo();
		String empRqNm = fxDao.selectEmpRqNm(empRqNo);
		fxtrs.put("empRqNm", empRqNm);
		
		return fxtrs;
	}
	

}
