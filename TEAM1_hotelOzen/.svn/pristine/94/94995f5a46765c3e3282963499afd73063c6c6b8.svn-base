package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.map.HashedMap;
import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.SalaryGiveVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class HrmPayMapperTest extends  AbstractRootContextTest {
	
	@Inject
	private HrmPayMapper mapper;

	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testSelect() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectList() {
		List<SalaryGiveVO> list = mapper.selectList();
		log.info("급여 지급 목록 : {}",list);
	}

	@Test
	void testSelectTotalRecord() {
		PaginationInfo paging = new PaginationInfo();
		int cnt = mapper.selectTotalRecord(paging);
		log.info("급여 지급 사원 수 : {}",cnt);
		
	}

	@Test
	void testSelectListPaginationInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSelectAutoSalaryCalInQuery() {
		
		PaginationInfo paging = new PaginationInfo();
		
		String y1 = "2024/";
		String m1 = "02";
		String d1 = "/01";
		String y2 = "2024/";
		String m2 = "03";
		String d2 = "/01";
		
		Map<String, Object> data= new HashMap<String, Object>();
		data.put("y1", y1);
		data.put("m1", m1);
		data.put("d1", d1);
		data.put("y2", y2);
		data.put("m2", m2);
		data.put("d2", d2);
		data.put("paging", paging);
		List<Map<String, Object>> somthing = mapper.selectAutoSalaryCalInQuery(data);
		log.info("급여 계산 결과 : {}", somthing);
		
	}


}
