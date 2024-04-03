package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.SearchCondition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DclzMapperTest extends AbstractRootContextTest{

	@Inject
	DclzMapper dao;
	
	@Test
	void test() {
		PaginationInfo paging = new PaginationInfo();
		SearchCondition simpleCondition = new SearchCondition();
		simpleCondition.setSearchWord("D");
		paging.setSimpleCondition(simpleCondition);
		int record = dao.selectTotalRecord("E120002", paging);
		log.info("{}", record);
		paging.setTotalRecord(record);
		paging.setCurrentPage(1);
		log.info("{}",dao.selectList("E120002",paging));
	}
}
