package kr.or.ddit.cstmr.recom.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.SbrsVO;
import kr.or.ddit.global.vo.ScrapVO;

public interface CstmrRecomSbrsService {

	/**
	 * 부대시설 추천 조회
	 * @param parameterMap
	 * @return 존재하지 않을 경우, {@link PKNotFoundException} 발생 
	 */
	public List<SbrsVO> retrieveSbrs(String cstNo);

	public int insertSbrsScrap(ScrapVO newScrap);
	
	public int deleteSbrsScrap(ScrapVO deleteScrap);
	
	public Map<String, String> selectSbrs(String cstNo);
	
	/**
	 * 부대시설 스크랩 되었는지 확인하는 메소드
	 * @param checkSbrs
	 * @return
	 */
	public int checkSbrsScrap(ScrapVO checkSbrs);
	
}
