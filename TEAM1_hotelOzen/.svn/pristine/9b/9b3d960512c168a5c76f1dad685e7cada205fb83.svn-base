package kr.or.ddit.cstmr.recom.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.CarVO;
import kr.or.ddit.global.vo.ScrapVO;
import kr.or.ddit.mybatis.mappers.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CstmrIntrcnRecomServiceImpl implements CstmrIntrcnRecomCarService{

	private final CarMapper dao;
	
	
	@Override
	public List<CarVO> retrieveCar(String cstNo) {
		
		Map<String, Object> parameterMap = new HashMap<>();
		
		Map<String, String> cstmrMap = dao.selectCstmr(cstNo);
		log.info("{}",cstmrMap);

		String cstGen = cstmrMap.get("cstGen");
		String cstAge = String.valueOf(cstmrMap.get("cstAge"));
//		log.info("cstAge:{}",cstAge);
//		log.info("cstGen:{}",cstGen);
		parameterMap.put("cstAge",cstAge);
		parameterMap.put("cstGen", cstGen);
		
		List<CarVO> recomCar = dao.selectCar(parameterMap);
		log.info("{}",recomCar);
		if(recomCar == null) {
			throw new PKNotFoundException(String.format("해당하는 사용자 없음"));
		}
		return recomCar;
	}


	@Override
	public int insertCarScrap(ScrapVO newScrap) {
		return dao.insertCarScrap(newScrap);
	}


	@Override
	public int deleteCarScrap(ScrapVO deleteScrap) {
		return dao.deleteCarScrap(deleteScrap);
	}


	@Override
	public int checkCarScrap(ScrapVO checkCar) {
		return dao.checkCarScrap(checkCar);
	}
}
