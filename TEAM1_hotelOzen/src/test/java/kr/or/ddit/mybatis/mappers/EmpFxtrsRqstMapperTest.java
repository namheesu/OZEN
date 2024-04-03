package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpAlramVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpFxtrsRqstMapperTest extends AbstractRootContextTest{

	@Inject
	private EmpFxtrsRqstMapper dao;
	
	@Test
	void testSelectList() {
		PaginationInfo paging = new PaginationInfo();
		
		paging.setCurrentPage(1);
		
		log.info("{}", dao.selectList(paging));
	}

	@Test
	void testSelectEmpName() {
		String empNo = "E150001";
		log.info("{}", dao.selectEmpName(empNo));
	}
	
	
	@Test
	void testAlram() {
		EmpAlramVO empAlram = new EmpAlramVO();
		empAlram.setRqstNo("FXRQ2403005");
		empAlram.setEmpNo("E230014");
		
		int rowcnt = dao.insertFxtrsAlram(empAlram);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
		
	}

}
