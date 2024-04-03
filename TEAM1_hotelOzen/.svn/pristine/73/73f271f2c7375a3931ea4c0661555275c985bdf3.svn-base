package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.CarVO;
import kr.or.ddit.global.vo.ScrapVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CarMapperTest extends AbstractRootContextTest{

	@Inject
	private CarMapper dao;
	
	@Test
	void test() {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("cstAge",40);
		parameterMap.put("cstGen","M");
		List<CarVO> vo = dao.selectCar(parameterMap);
		log.info("{}",vo);
	}
	
	@Test
	void insertCarTest() {
		ScrapVO newScrap = new ScrapVO();
		newScrap.setCstNo("M1800001");
		newScrap.setScrapNo("SB015");
		
		int rowcnt = dao.insertCarScrap(newScrap);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}
	
	@Test
	void deleteCarTest() {
		ScrapVO deleteScrap = new ScrapVO();
		deleteScrap.setCstNo("M2300002");
		deleteScrap.setScrapNo("SB003");
		
		int rowcnt = dao.deleteCarScrap(deleteScrap);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}
}
