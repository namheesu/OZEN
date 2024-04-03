package kr.or.ddit.emp.hrm.empnotice.service;

import java.util.List;

import kr.or.ddit.emp.hrm.empnotice.exception.EmpNoticeException;
import kr.or.ddit.emp.hrm.empnotice.exception.WriterAuthenticationException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AtchmnflEmpNoticeVO;
import kr.or.ddit.global.vo.EmpNoticeVO;

/**
 * 직원 공지 관리 인터페이스
 * @author 박지원
 *
 */
public interface HrmEmpNoticeSevice {
	
	/**
	 * 새 직원 공지 작성
	 * @param empNt
	 * @return newEmpNtNo
	 */
	public String createEmpNotice(EmpNoticeVO empNt);
	/**
	 * 직원 공지 조회
	 * @param empNtNo
	 * @return
	 * @throws EmpNoticeException
	 */
	public EmpNoticeVO retrieveEmpNotice(String empNtNo) throws EmpNoticeException;
	
	/**
	 * 직원 공지 목록 조회
	 * @param paging
	 * @return
	 */
	public List<EmpNoticeVO> retrieveEmpNoticeList(PaginationInfo paging);
	
	/**
	 * 작성자 인증
	 * @param target
	 * @return
	 * @throws WriterAuthenticationException
	 */
	public EmpNoticeVO writerAutenticate(EmpNoticeVO target) throws WriterAuthenticationException;
	
	/**
	 * 직원 공지 수정
	 * @param empNt
	 */
	public void modifyEmpNotice(EmpNoticeVO empNt);
	/**
	 * 직원 공지 삭제
	 * @param empNt
	 */
	public void removeEmpNotice(EmpNoticeVO empNt);
	
	/**
	 * 첨부파일 다운로드
	 * @param attNo
	 * @return
	 */
	public AtchmnflEmpNoticeVO downloadAtch(int attNo);
	
	
	/**
	 * 첨부파일 삭제
	 * @param attNo
	 */
	public void removeAtch(int attNo);
	
	
	
	
	

}
