package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.ScrapVO;

@Mapper
public interface ScrapMapper {
	
	/**
	 * 고객번호로 부대시설 ?스크랩 조회 => 부대시설과 렌터카를 나눠야 하나?
	 * @param cstNo
	 * @return
	 */
	public List<ScrapVO> selectScrapSbrs(String cstNo);

	/**
	 * 고객번호로 렌터카 ?스크랩 조회 => 부대시설과 렌터카를 나눠야 하나?
	 * @param cstNo
	 * @return
	 */
	public List<ScrapVO> selectScrapCar(String cstNo);
	
	/**
	 * 스크랩 삭제
	 * @param scrap
	 * @return
	 */
	public int deleteScrap(ScrapVO scrap);
}
