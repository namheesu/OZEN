package kr.or.ddit.cstmr.recom.service;

import java.util.List;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.CarVO;
import kr.or.ddit.global.vo.ScrapVO;

public interface CstmrIntrcnRecomCarService {

	/**
	 * 렌트카 추천 차량 조회
	 * @param parameterMap
	 * @return 존재하지 않을 경우, {@link PKNotFoundException} 발생 
	 */
	public List<CarVO> retrieveCar(String cstNo);
	
	public int insertCarScrap(ScrapVO newScrap);
	
	public int deleteCarScrap(ScrapVO deleteScrap);
	
	public int checkCarScrap(ScrapVO checkCar);

}
