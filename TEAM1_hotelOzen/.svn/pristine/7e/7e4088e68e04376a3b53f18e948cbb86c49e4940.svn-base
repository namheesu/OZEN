package kr.or.ddit.cstmr.intrcn.mbrsh.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.MbrshGrdVO;

public interface CstmrMbrshService {
	/**
	 * 한가지 색의 멤버십 목록 조회(BBLUE, LBLUE, DBLUE)
	 */
	public List<MbrshGrdVO> retrieveMbrsh(String mbrshCd);
	/**
	 * 모든 멤버십 목록 조회
	 */
	public List<MbrshGrdVO> retrieveMbrshList();
	/**
	 * 가입할 멤버십 하나에 대한 정보 조회
	 */	
	public MbrshGrdVO retrieveOneMbrsh(String grd);
	/**
	 * 멤버십 가입자에 대한 정보 조회
	 */	
	public MberVO retrieveSubscriber(String cstNo);

    /**
     * 멤버십 가입 구현
     */	
	public ServiceResult createMbrshInfo(Map<String, Object> mbrshData);
	/**
	 * 멤버십 종류 조회
	 */	
	public List<MbrshGrdVO> retrieveAllMbrshList();
	
}
