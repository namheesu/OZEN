package kr.or.ddit.cstmr.rsvt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RefndVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;
import kr.or.ddit.mybatis.mappers.CstmrRsvtRetrieveMapper;
import kr.or.ddit.mybatis.mappers.MberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional()
public class CstmrRsvtRetrieveServiceImpl implements CstmrRsvtRetrieveService{

	@Inject
	private CstmrRsvtRetrieveMapper dao;
	
	@Inject
	private MberMapper mdao;
	
	@Override
	public RsvtVO retrieveNberRsvt(CstmrVO cstmrVO) {
		
		return dao.selectNberRsvt(cstmrVO);
	}

	@Override
	public MberVO retrieveMber(String cstNo) {
		return mdao.select(cstNo);
	}

	@Override
	public List<RsvtDetailsVO> retrieveRsvtDetails(String rsvtNo) {
		return dao.selectRsvtDetailsList(rsvtNo);
	}

	@Override
	public List<RsvtVO> retrieveMberRsvt(String cstNo) {
		return dao.selectMberRsvtList(cstNo);
	}

	@Override
	public List<RsvtDetailsVO> retrieveEndRsvtDetails(String rsvtNo) {
		return dao.selectEndRsvtDetailsList(rsvtNo);
	}

	@Override
	public List<RsvtVO> retrieveMberEndRsvt(String cstNo) {
		return dao.selectMberEndRsvtList(cstNo);
	}

	@Override
	public List<RsvtDetailsVO> retrieveCancelRsvtDetails(String rsvtNo) {
		return dao.selectCancelRsvtDetailsList(rsvtNo);
	}

	@Override
	public List<RsvtVO> retrieveMberCancelRsvt(String cstNo) {
		return dao.selectMberCancelRsvtList(cstNo);
	}

	@Override
	public SetleVO retrieveSetle(String setelNo) {
		return dao.selectSetle(setelNo);
	}

	@Override
	public ServiceResult rsvtCancel(Map<String, Object> rsvtData) {
		ServiceResult result;
		RefndVO refndVO = new RefndVO();
		// 예약번호
	    String rsvtNo = rsvtData.get("rsvtNo").toString();
	    // 결제번호
	    String setleNo = rsvtData.get("setleNo").toString();
	    // 결제금액
	    int setleAmnt = Integer.parseInt(rsvtData.get("refndAmnt").toString());
	    // 체크인 예정일
	    LocalDate rsvtCheckinYmd = LocalDate.parse(rsvtData.get("rsvtCheckinYmd").toString());
	    // 현재일
	    LocalDate current = LocalDate.now();
	    // 현재일 - 체크인 예정일
	    int diff = rsvtCheckinYmd.compareTo(current);
	    // 환불 비율
	    String refndPlcyNo;
	    // 환불규정에 맞게 계산
	    if(diff>=3) { 
	    	// 3일 이상 100%
	    	refndPlcyNo = "RFND1";
	    }else if(diff>=1) {
	    	// 1일 이상 50%
	    	setleAmnt = (int) (setleAmnt * 0.5);
	    	refndPlcyNo = "RFND2";
	    }else {
	    	// 당일 0%
	    	setleAmnt = 0;
	    	refndPlcyNo = "RFND3";
	    }
	    
		// 예약 상태 취소로 변경
		int rsvtCancel = dao.rsvtCancel(rsvtNo);
		if(rsvtCancel != 1){
			throw new RuntimeException();
		}
		// 예약 상세 상태 취소로 변경
		int rsvtDetailsCancel = dao.updateRsvtDetails(rsvtNo);
		if(rsvtDetailsCancel < 1){
			throw new RuntimeException();
		}
		// 결제 취소로 상태 변경
		int updateSetle = dao.updateSetle(setleNo);
		if(updateSetle != 1){
			throw new RuntimeException();
		}

		// 환불번호 생성
		String refndNo = dao.selectNewRefndNo();
		refndVO.setRefndNo(refndNo);
		refndVO.setSetleNo(setleNo);
		refndVO.setRefndAmnt(setleAmnt);
		refndVO.setRefndPlcyNo(refndPlcyNo);
			
		// 환불정보 추가
		int insertRefnd = dao.insertRefnd(refndVO);
		if(insertRefnd != 1){
			throw new RuntimeException();
		}
		
		result = ServiceResult.OK;
		
		return result;
	}
	
	
}
