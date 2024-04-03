package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.ScrapVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ScrapMapperTest extends AbstractRootContextTest {
	
	@Inject
	ScrapMapper dao;

	@Test
	void sbrstest() {
		log.info("{}", dao.selectScrapSbrs("M2300002"));
	}

	@Test
	void cartest() {
		log.info("{}", dao.selectScrapCar("M2300003"));
	}
	
	@Test
	void scrapDelete() {
		ScrapVO deleteScrap = new ScrapVO();
		deleteScrap.setCstNo("M1800001");
		deleteScrap.setScrapNo("CAR06");
		
		int rowcnt = dao.deleteScrap(deleteScrap);
		assertEquals(1, rowcnt);
		log.info("rowcntttt {}", rowcnt);
	}
}
