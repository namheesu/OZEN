package kr.or.ddit.cstmr.intrcn.mbrsh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.security.SecureRandom;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.CouponVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.MbrshBnfVO;
import kr.or.ddit.global.vo.MbrshGrdVO;
import kr.or.ddit.global.vo.MbrshSetleVO;
import kr.or.ddit.global.vo.SetleVO;
import kr.or.ddit.mybatis.mappers.MberMapper;
import kr.or.ddit.mybatis.mappers.MbrshMapper;
import kr.or.ddit.mybatis.mappers.MbrshSetleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CstmrMbrshServiceImpl implements CstmrMbrshService {

	private final MbrshMapper dao;
	private final MberMapper mberDao;
	private final MbrshSetleMapper setleDao; 
	
	@Inject
	private TransactionTemplate transactionTemplate;

	/**
	 * 한가지 색의 멤버십 목록 조회(BBLUE, LBLUE, DBLUE)
	 */
	@Override
	public List<MbrshGrdVO> retrieveMbrsh(String mbrshCd) {
		
		return dao.selectBenefit(mbrshCd);
	}

	/**
	 * 모든 멤버십 목록 조회
	 */
	@Override
	public List<MbrshGrdVO> retrieveMbrshList() {

		return dao.selectList();
	}

	/**
	 * 가입할 멤버십 하나에 대한 정보 조회
	 */
	@Override
	public MbrshGrdVO retrieveOneMbrsh(String grd) {
		
		return dao.selectOne(grd);
	}

	/**
	 * 멤버십 가입자에 대한 정보 조회
	 */
	@Override
	public MberVO retrieveSubscriber(String cstNo) {
		MberVO mber = mberDao.selectSubscriber(cstNo);
		return mber;
	}


    /**
     * 멤버십 가입 구현
     */
    @Override
    public ServiceResult createMbrshInfo(Map<String, Object> mbrshData) {
    	return transactionTemplate.execute(status -> {
            try {
                SetleVO setleVo = (SetleVO) mbrshData.get("setleVo");
                MbrshSetleVO mbrshSetleVO = (MbrshSetleVO) mbrshData.get("mbrshSetleVO");
                
                String mbsNo = setleDao.selectMbsNo();
                String setleNo = setleDao.selectMbsSetleNo();
                
                setleVo.setSetleNo(setleNo);
                mbrshSetleVO.setMbsNo(mbsNo);
                mbrshSetleVO.setMbsSetleNo(setleNo);
                
                int setleResult = setleDao.insertToSetle(setleVo);
                int mbrSetleResult = setleDao.insertToMbsSetle(mbrshSetleVO);
                
                String cstNo = setleVo.getCstNo();
                int mileage = setleVo.getSetleAmnt() / 100;
                
                int insertMileageResult = setleDao.insertMileage(cstNo, mileage);
                
                String mbsGrdCd = mbrshSetleVO.getMbsGrdCd();
                
                List<MbrshBnfVO> bnfList = dao.selectCouponList(mbsGrdCd);
                List<CouponVO> couponList = new ArrayList<>();
                bnfList.forEach(b->{
                	CouponVO coupon = new CouponVO();
                	coupon.setCpnNo(generateCouponCode());
                	coupon.setCpnkNo(b.getCpnkNo());
                	coupon.setCstNo(cstNo);
                	couponList.add(coupon);
                });
                
                int insertCoupon = setleDao.insertCoupon(couponList);
                
                if (setleResult == 1 && mbrSetleResult == 1 && insertMileageResult == 1 && insertCoupon > 0) {
                    return ServiceResult.OK;
                } else {
                    status.setRollbackOnly(); // 롤백
                    return ServiceResult.FAIL;
                }
            } catch (Exception e) {
                status.setRollbackOnly(); // 롤백
                return ServiceResult.FAIL;
            }
        });
    }
    
    /**
     * 쿠폰 발급 번호 생성 메서드
     * @return
     */
    static public String generateCouponCode(){
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        StringBuilder sb = new StringBuilder();
        
        SecureRandom random = new SecureRandom();
        
        int codeLength = 12;
        
        for (int i = 0; i < codeLength; i++) {
            int randomIndex = random.nextInt(charset.length());
            sb.append(charset.charAt(randomIndex));
        }
        
        return sb.toString();    	
    }

	/**
	 * 멤버십 종류 조회
	 */
	@Override
	public List<MbrshGrdVO> retrieveAllMbrshList() {

		return dao.selectMbrshList();
	}
	
}
