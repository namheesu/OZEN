package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RefndVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RefndMapperTest extends AbstractRootContextTest {

	@Inject
	private EmpRefndMapper dao;
	
	@Test
	void test() {
		RefndVO vo = dao.select("REF2402001");
		log.info("{}",vo);
	}
	@Test
	void testSelectTotalRecord() {
		
		log.info("{}", dao.selectList());
		
	}
}
