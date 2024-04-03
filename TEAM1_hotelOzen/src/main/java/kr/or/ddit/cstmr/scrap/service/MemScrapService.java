package kr.or.ddit.cstmr.scrap.service;

import java.util.List;

import kr.or.ddit.global.vo.ScrapVO;

public interface MemScrapService {

	/**
	 * 스크랩 된 부대시설 조회
	 * @param cstNo
	 * @return
	 */
	public List<ScrapVO> selectScrapSbrs(String cstNo);
	
	/**
	 * 스크랩 된 렌터카 조회
	 * @param cstNo
	 * @return
	 */
	public List<ScrapVO> selectScrapCar(String cstNo);
	
	
	public int deleteScrap(ScrapVO deleteScrap);
}
