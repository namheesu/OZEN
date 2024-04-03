package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.SbrsVO;
import kr.or.ddit.global.vo.ScrapVO;

@Mapper
public interface SbrsMapper{
	public List<SbrsVO> selectRecomSbrs(Map<String, Object> cstmrMap);
	
	public Map<String, String> selectSbrs(String cstNo);
	
	public int insertSbrsScrap(ScrapVO newScrap);
	
	public int deleteSbrsScrap(ScrapVO deleteScrap);
	
	/**
	 * 스크랩 되어있는지 확인하는 메소드
	 * @param checkScrap
	 * @return
	 */
	public int checkSbrsScrap(ScrapVO checkSbrs);
	

}
