package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpFxtrsMapperTest extends AbstractRootContextTest{

	@Inject
	private EmpFxtrsMapper dao;
	
	@Test
	void selectFxtrsList() {
		PaginationInfo paging = new PaginationInfo();
		
		Map<String, Object> detailCondition = new HashMap<String, Object>();
		detailCondition.put("searchWord", "배개");
		
		paging.setCurrentPage(1);
		paging.setDetailCondition(detailCondition);
		
		log.info("{}", dao.selectList(paging));
	}

}
