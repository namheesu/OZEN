package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.CarVO;
import kr.or.ddit.global.vo.ScrapVO;

@Mapper
public interface CarMapper extends AbstractCommonMapper<CarVO, String>{

	Map<String, String> selectCstmr(String cstNo);
	
	List<CarVO> selectCar(Map<String, Object> parameterMap);
	
	public int insertCarScrap(ScrapVO newScrap);
	
	public int deleteCarScrap(ScrapVO deleteScrap);
	
	/**
	 * 스크랩 되어있나 확인하는 메소드
	 * @param checkCar
	 * @return
	 */
	public int checkCarScrap(ScrapVO checkCar);

}
