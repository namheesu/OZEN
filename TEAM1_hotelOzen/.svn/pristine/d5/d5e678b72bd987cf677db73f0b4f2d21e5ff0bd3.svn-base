package kr.or.ddit.mybatis.mappers;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.SbrsVO;
import kr.or.ddit.global.vo.ScrapVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SbrsMapperTest extends AbstractRootContextTest {

	@Inject
	SbrsMapper dao;
	
	@Test
	void test2() {
		log.info("{}",dao.selectSbrs("22222"));
	}
	
	@Test
	void test() {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("mbti", "E");
		parameterMap.put("age", "40-50");
		parameterMap.put("season", "spring");
		List<SbrsVO> vo = dao.selectRecomSbrs(parameterMap);
		log.info("VO {}",vo);
	}
	
	@Test
	void insertTest() {
		ScrapVO newScrap = new ScrapVO();
		newScrap.setCstNo("M1800001");
		newScrap.setScrapNo("SB015");
		
		int rowcnt = dao.insertSbrsScrap(newScrap);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}

	@Test
	void deleteTest() {
		ScrapVO deleteScrap = new ScrapVO();
		deleteScrap.setCstNo("M2300002");
		deleteScrap.setScrapNo("SB003");
		
		int rowcnt = dao.deleteSbrsScrap(deleteScrap);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}
	
	@Test
	void checkTest() {
		ScrapVO checkScrap = new ScrapVO();
		checkScrap.setCstNo("M1800001");
		checkScrap.setScrapNo("SB015");
		
		int rowcnt = dao.checkSbrsScrap(checkScrap);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}

}
