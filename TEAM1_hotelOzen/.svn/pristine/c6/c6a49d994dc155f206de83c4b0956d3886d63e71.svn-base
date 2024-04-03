package kr.or.ddit.emp.hrm.dclz.service;

import java.util.List;

import kr.or.ddit.global.vo.HrmDclzVO;
import kr.or.ddit.global.vo.HrmEmpVO;

public interface HrmDclzTimeService {
	/**
	 * 출근직원 목록 조회
	 * @return 출근직원 리스트
	 */
	public List<HrmEmpVO> retrieveHrmEmpDclzList();
	
	/**
	 * 날짜 포맷
	 * @return
	 */
	public String dateFormat();
	
	/**
	 * 근태기록 생성: 출근 정보 등록
	 * @param empNo
	 * 
	 */
	public void createHrmEmpDclz(String empNo);
	
	/** 
	 * 근태기록 변경:퇴근 정보 등록 메서드
	 */
	public void modifyHrmEmpDclzGetOffWork(String empNo);
	
	/**
	 * 한 명의 직원의 오늘의 근태 기록 정보 조회
	 * @return
	 */
	public HrmDclzVO retrieveHrmEmpInfo(String empNo);

}
