package kr.or.ddit.cstmr.intrcn.sbrsliar.service;

import java.util.List;

import kr.or.ddit.global.vo.SbrsVO;

public interface MberSbrsLiarService {

	/**
	 * 고객 부대시설 조회
	 * @return
	 */
	public List<SbrsVO> sbrsLiarList();
}
