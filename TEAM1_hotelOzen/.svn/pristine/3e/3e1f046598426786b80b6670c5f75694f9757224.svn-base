package kr.or.ddit.cstmr.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.ClickWrapVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RegistVO;
import kr.or.ddit.mybatis.mappers.ClickWrapMapper;
import kr.or.ddit.mybatis.mappers.CstmrMapper;
import kr.or.ddit.mybatis.mappers.MberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MberAuthServiceImpl implements MberAuthService {

	private final MberMapper dao;
	private final CstmrMapper cstDao;
	private final ClickWrapMapper termsDao;
	
	@Override
//	@Transactional(rollbackFor = Exception.class)
	public ServiceResult createNewMber(RegistVO newMber) {
		ServiceResult result = null;

		if (dao.findMberUser(newMber) != null) {
			
			result = ServiceResult.USERDUPLICATED;
			
		// 중복 통과	
		} else {
			String detailAddr = newMber.getMberDetailAddr();
			String addr = newMber.getMberAddr();
			newMber.setMberAddr(addr + detailAddr);
			newMber.setCstClsfcCd("M");
			
			String cstMail = newMber.getCstMail();
			String mailAddr = newMber.getMailAddr();

			newMber.setCstMail(cstMail.trim() +"@"+ mailAddr.trim());
			
			String cstNo = dao.selectNewCstNo();

			newMber.setCstNo(cstNo);

			int cstmrInsert = cstDao.insertCstmr(newMber);
			log.info("cstmrInsert : " + cstmrInsert);
			int mberInsert = dao.insertMber(newMber);
			log.info("mberInsert : " + mberInsert);
			
			if (cstmrInsert != 1 || mberInsert != 1) {
				throw new RuntimeException();
			} else {
				result = ServiceResult.OK;
			}
		}
		return result;
	}

	@Override
	public List<ClickWrapVO> retrieveTerms() {
		
		List<ClickWrapVO> termList = termsDao.selectList();
		
		return termList;
	}

	@Override
	public boolean idDuplicateCheck(String mberId) {
		boolean result = false;
		
		MberVO mber = dao.selectMberByUserName(mberId);
		
		if(mber==null) {
			result = true;
		}
		
		return result;
	}

	@Override
	public CstmrVO checkUser(CstmrVO cstmr) {
		
		CstmrVO user = cstDao.checkUser(cstmr);
		
		return user;
	}

	@Override
	public ServiceResult changePwd(CstmrVO cstmr) {
		ServiceResult result = null;
		
		String newPw = cstmr.getNewPw();
		
		MberVO mber = cstmr.getMber();
		mber.setMberPw(newPw);
		
		int changeResult = dao.changePwd(mber);
		
		if(changeResult == 1) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result; 
	}

	@Override
	public ServiceResult changeMyPwd(MberVO mber) {
		ServiceResult result = null;
		
		int changeResult = dao.updatePwd(mber);

		if(changeResult == 1) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result; 		
		
	}
	
	@Override
	public ServiceResult checkUserById(CstmrVO cstmr) {
		ServiceResult result = null;
		CstmrVO cst = cstDao.checkUser(cstmr);
		
		if(cst != null) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result;
	}

	@Override
	public String retrieveMberId(CstmrVO cstmr) {
		
		CstmrVO cst = cstDao.checkUser(cstmr);
		String mberId = null;
		
		if(cst!=null) {
			mberId = cst.getMber().getMberId();
		}
		
		return mberId;
	}

}
