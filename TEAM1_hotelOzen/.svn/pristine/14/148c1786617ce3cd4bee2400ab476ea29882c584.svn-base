package kr.or.ddit.emp.hrm.dclz.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.HrmDclzVO;
import kr.or.ddit.global.vo.HrmEmpVO;
import kr.or.ddit.mybatis.mappers.HrmDclzMapper;
import kr.or.ddit.mybatis.mappers.HrmEmpMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HrmDclzTimeServiceImpl implements HrmDclzTimeService {
	
	@Inject
	private HrmEmpMapper mapper;
	
	@Inject
	private HrmDclzMapper dclzMapper;

	/**
	 * 현재 출근한 직원 목록 조회
	 */
	@Override
	public List<HrmEmpVO> retrieveHrmEmpDclzList() {
		
		return mapper.selectDclzList();
	}

	@Override
	public String dateFormat() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		
		log.info("Date:" + date.format(today));
		log.info("Time:" + time.format(today));
		return date.format(today);
	}

	@Override
	public void createHrmEmpDclz(String empNo) {
		dclzMapper.insert(empNo);
		
	}

	@Override
	public void modifyHrmEmpDclzGetOffWork(String empNo) {
		dclzMapper.updateGetOffWork(empNo);
		
	}

	@Override
	public HrmDclzVO retrieveHrmEmpInfo(String empNo) {
		HrmDclzVO dclz = dclzMapper.select(empNo);
		if(dclz != null) { 
			LocalDateTime inTime = dclz.getDclzBgnDt();
			LocalDateTime outTime = dclz.getDclzEndDt();
			if (inTime != null) dclz.setInTime(date2String(inTime));
			if (outTime != null)	dclz.setOutTime(date2String(outTime));
			
		}
		return dclz;
	}
	
	public String date2String(LocalDateTime time) {
		return time.format(DateTimeFormatter.ofPattern("HH : mm"));
	}

}
