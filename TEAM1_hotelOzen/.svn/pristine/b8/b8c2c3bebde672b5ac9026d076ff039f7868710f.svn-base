package kr.or.ddit.emp.hrm.emply.service;

import java.io.File;
import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.HrmEmpVO;

public interface HrmEmpService {
	
	/**
	 * 직원 계정 생성 처리
	 * @param hrmEmp
	 * @return 
	 */
	public ServiceResult createHrmEmp(HrmEmpVO hrmEmp);
	
	
	/**
	 * 다수의 직원 계정 생성 처리
	 * @param file
	 * @return 등록된 직원 수
	 */
	public int createHrmEmpsUsingExcel(File file);
	
	
	/**
	 * 직원 사번 생성
	 * @return 
	 */
	public String createHrmEmpNo();
	/**
	 * 직원 정보 상세 조회
	 * @param empNo 조회할 직원의 primary key
	 * @return
	 */
	public HrmEmpVO retrieveHrmEmp(String empNo);
	/**
	 * 직원 목록 조회
	 * @return
	 */
	public List<HrmEmpVO> retrieveHrmEmpList();
	/**
	 * 출근 직원 목록 조회
	 * @return
	 */
	public List<HrmEmpVO> retrieveHrmEmpDclzList();
	/**
	 * 퇴사 직원 목록 조회
	 * @return
	 */
	public List<HrmEmpVO> retrieveHrmEmpRtrmList();
	/**
	 * 직원 정보 수정
	 * @param hrmEmp
	 * @return
	 */
	public ServiceResult modifyHrmEmp(HrmEmpVO hrmEmp);
	/**
	 * 직원 삭제(퇴사처리)
	 * @param empNo
	 * @return
	 */
	public ServiceResult removeHrmEmp(String empNo);
	

}
