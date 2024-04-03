package kr.or.ddit.emp.pms.rsvt.service;

import java.util.List;

import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;

public interface EmpPmsQrRsvtService {
	
	/**
	 * QR코드 예약번호별 예약상세번호 조회
	 * @param rsvtNo
	 * @return
	 */
	public List<RsvtDetailsVO> retrieveRsvtDtlList(String rsvtNo);
	
	/**
	 * 예약상세번호 상세 조회
	 * @param rsvtDtlNo
	 * @return
	 */
	public RsvtDetailsVO retrieveRsvtDtl(String rsvtDtlNo);

}
