package kr.or.ddit.emp.pbl.dclz.service;

import java.time.LocalDate;
import java.util.List;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.WorkSchdlVO;

/**
 * 근무일정표 관리 Business Logic Layer
 *
 */
public interface WorkSchdlService {
	/**
	 * 근무일정 상세 조회
	 * @param pkmap
	 * @return
	 */
	public WorkSchdlVO retrieveWorkSchdl(String empNo, LocalDate pkmap);
	/**
	 * 근무일정표
	 * @param paging
	 * @return
	 */
	public List<WorkSchdlVO> retrieveWorkSchdlList(PaginationInfo paging);
	/**
	 * 근무일정표 신규등록, 등록시 PK 생성 절차 필요
	 * @param workSchdl
	 */
	public void createWorkSchdl(WorkSchdlVO workSchdl); 
	/**
	 * 근무일정표 정보 수정
	 * @param workSchdl
	 */
	public void modifyWorkSchdl(WorkSchdlVO workSchdl);
	
	/**
	 * 특정 달의 근무일정표 삭제
	 */
	public void removeWorkSchdl(String target1, String target2);
	

}
