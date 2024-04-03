package kr.or.ddit.cstmr.myinfo.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RegistVO;

public interface CstmrMyInfoService {
	
	/**
	 * 마이페이지 정보 조회
	 * @param cstNo
	 * @return
	 */
	public MberVO retrieveUser(String cstNo);
	
	/**
	 * 개인정보 수정 메서드
	 * @param modMber
	 * @return
	 */
	public ServiceResult modify(RegistVO modMber);
	
	/**
	 * 회원 탈퇴 메서드
	 * @param cstNo
	 * @return
	 */
	public ServiceResult secsn(String cstNo);
	
	/**
	 * 스케줄링 진행 메서드
	 * @return
	 */
	public void privacyDelete();
	
}
