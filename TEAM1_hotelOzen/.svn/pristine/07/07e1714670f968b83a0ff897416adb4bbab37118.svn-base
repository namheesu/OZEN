package kr.or.ddit.cstmr.recom.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.SbrsVO;
import kr.or.ddit.global.vo.ScrapVO;
import kr.or.ddit.mybatis.mappers.SbrsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CstmrRecomSbrsServiceImpl  implements CstmrRecomSbrsService{

	private final SbrsMapper dao;
	
	@Override
	public List<SbrsVO> retrieveSbrs(String cstNo) {
		Map<String, Object> parameterMap = new HashMap<>();

		Map<String, String> sbrsMap = dao.selectSbrs(cstNo);
		log.info("{}",sbrsMap);
		
		String mbti = sbrsMap.get("mbti");
		String season = sbrsMap.get("season");
		String age = sbrsMap.get("age");
		
		parameterMap.put("mbti", mbti);
		parameterMap.put("season", season);
		parameterMap.put("age", age);
		
		List<SbrsVO> recomSbrs = dao.selectRecomSbrs(parameterMap);
		log.info("{}", recomSbrs);
		if(recomSbrs == null) {
			throw new PKNotFoundException(String.format("해당하는 사용자 없음"));
		}
		return recomSbrs;
 		
	}

	@Override
	public int insertSbrsScrap(ScrapVO newScrap) {
		return dao.insertSbrsScrap(newScrap);
	}

	@Override
	public int deleteSbrsScrap(ScrapVO deleteScrap) {
		return dao.deleteSbrsScrap(deleteScrap);
	}

	@Override
	public int checkSbrsScrap(ScrapVO checkSbrs) {
		// 1이면 스크랩되어있는 항목
		return dao.checkSbrsScrap(checkSbrs);
		
	}

	@Override
	public Map<String, String> selectSbrs(String cstNo) {
		return dao.selectSbrs(cstNo);
	}

}
