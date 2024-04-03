package kr.or.ddit.emp.pms.rsvt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.mybatis.mappers.EmpQrRsvtMapper;
import kr.or.ddit.mybatis.mappers.EmpStayChkinMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsQrRsvtServiceImpl implements EmpPmsQrRsvtService{

	private final EmpQrRsvtMapper dao;
	
	private final EmpStayChkinMapper chkindao;
	
	@Override
	public List<RsvtDetailsVO> retrieveRsvtDtlList(String rsvtNo) {
		List<RsvtDetailsVO> rsvtDtlList = dao.selectRsvtDtlList(rsvtNo);
		return rsvtDtlList;
	}

	@Override
	public RsvtDetailsVO retrieveRsvtDtl(String rsvtDtlNo) {
		RsvtDetailsVO rsvt = chkindao.select(rsvtDtlNo);		
		return rsvt;
	}
	
}
