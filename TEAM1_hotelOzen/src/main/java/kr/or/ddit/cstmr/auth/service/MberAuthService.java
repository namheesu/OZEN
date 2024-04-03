package kr.or.ddit.cstmr.auth.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.ClickWrapVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RegistVO;

public interface MberAuthService {
	
	public ServiceResult createNewMber(RegistVO newMber);
	
	public List<ClickWrapVO> retrieveTerms();
	
	public boolean idDuplicateCheck(String mberId);
	
	public CstmrVO checkUser(CstmrVO cstmr);
	
	public ServiceResult changePwd(CstmrVO cstmr);
	
	public ServiceResult changeMyPwd(MberVO mber);
	
	public ServiceResult checkUserById(CstmrVO cstmr);
	
	public String retrieveMberId(CstmrVO cstmr);
}
