package kr.or.ddit.cstmr.scrap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.ScrapVO;
import kr.or.ddit.mybatis.mappers.ScrapMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemScrapServiceImpl implements MemScrapService {
	
	private final ScrapMapper dao;

	@Override
	public List<ScrapVO> selectScrapSbrs(String cstNo) {
		List<ScrapVO> scrapList = dao.selectScrapSbrs(cstNo);
		if(scrapList == null) {
			throw new PKNotFoundException(String.format("해당하는 사용자 없음"));
		}
		return scrapList;
	}

	@Override
	public List<ScrapVO> selectScrapCar(String cstNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteScrap(ScrapVO deleteScrap) {
		return dao.deleteScrap(deleteScrap);
	}

}
