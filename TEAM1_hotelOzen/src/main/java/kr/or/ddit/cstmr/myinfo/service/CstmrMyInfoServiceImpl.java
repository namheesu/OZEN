package kr.or.ddit.cstmr.myinfo.service;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RegistVO;
import kr.or.ddit.mybatis.mappers.MberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CstmrMyInfoServiceImpl implements CstmrMyInfoService {

	@Inject
	private final MberMapper dao;
	
	@Inject
	private TransactionTemplate transactionTemplate;
	
	@Override
	public MberVO retrieveUser(String cstNo) {

		MberVO mber = dao.selectMypage(cstNo);
		
		MberVO couponList = dao.selectCouponCnt(cstNo);
		
		mber.setTotalCoupon(couponList.getTotalCoupon());
		mber.setAvailCoupon(couponList.getAvailCoupon());
		mber.setUnAvailCoupon(couponList.getUnAvailCoupon());
		mber.setUsedCoupon(couponList.getUsedCoupon());
		
		return mber;
	}

	@Override
	public ServiceResult modify(RegistVO modMber) {
		return transactionTemplate.execute(status -> {
			try {
				modMber.setMberAddr(modMber.getMberAddr() + modMber.getMberDetailAddr());
				modMber.setCstMail(modMber.getCstMail() + "@" + modMber.getMailAddr());
				
				int cstResult = dao.updateCst(modMber);
				int mberResult = dao.updateMber(modMber);
				if(cstResult == 1 && mberResult == 1) {
					return ServiceResult.OK;
				}else {
                    status.setRollbackOnly(); // 롤백
                    return ServiceResult.FAIL;						
				}
            } catch (Exception e) {
                status.setRollbackOnly(); // 롤백
                return ServiceResult.FAIL;
            }
        });
	}

	@Override
	public ServiceResult secsn(String cstNo) {
		return transactionTemplate.execute(status -> {
			try {
				int secsnResult = dao.secsnUpdate(cstNo);
				if(secsnResult == 1) {
					return ServiceResult.OK;
				}else {
					status.setRollbackOnly(); // 롤백
					return ServiceResult.FAIL;
					
				}
			} catch (Exception e) {
	        	status.setRollbackOnly(); // 롤백
	        	return ServiceResult.FAIL;
			}	
		});
	}

	@Override
	@Scheduled(cron = "0 0 4 1 * *")
	public void privacyDelete() {
		dao.deletePrivacy();
		dao.deletePrivacyCst();
	}

}
