package kr.or.ddit.emp.pbl.schdl.service;

import java.util.List;

import kr.or.ddit.global.vo.EmpSchdlVO;

public interface EmpSchdlService {
	
	/**
	 * 직원사번으로 등록된 일정 조회
	 * @param empNo
	 * @return
	 */
	public List<EmpSchdlVO> retrieveSchdlList(String empNo);
	
	/**
	 * 직원일정 추가 insert
	 * @param newSchdl
	 * @return
	 */
	public int insertEmpSchdl(EmpSchdlVO newSchdl);
	
	/**
	 * 일정 삭제
	 * @param deleteSchdl
	 * @return
	 */
	public int deleteEmpSchdl(EmpSchdlVO deleteSchdl);

}
