package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.HrmDclzVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class HrmDclzMapperTest extends AbstractRootContextTest{

	@Inject
	private HrmDclzMapper mapper;
	
	@Test
	void testInsert() {
		mapper.insert("E170001");
		
	}

	@Test
	void testUpdateGetOffWork() {
		fail("Not yet implemented");
	}

	@Test
	void testSelect() {
		HrmDclzVO dclz = mapper.select("E120008");
		assertNull(dclz);
		log.info("근태기록입니다. .......{}",dclz);
	}
}
