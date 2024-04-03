package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.EmpSchdlVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpSchdlMapperTest extends AbstractRootContextTest {
	
	@Inject
	EmpSchdlMapper dao;

	@Test
	void schdlListTest() {
		log.info("{}", dao.empSchdlList("E120006"));
	}
	
	@Test
	void schdlInsertTest() {
		EmpSchdlVO newSchdl = new EmpSchdlVO();
		newSchdl.setEmpNo("E180001");
		newSchdl.setSchdlTitle("연차다");
		newSchdl.setSchdlStart(LocalDate.parse("2024-03-05"));
	    newSchdl.setSchdlEnd(LocalDate.parse("2024-03-08"));
		newSchdl.setBgColor("#f6714f");
		
		int rowcnt = dao.insertEmpSchdl(newSchdl);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}
	
	@Test
	void schdlDeleteTest() {
		EmpSchdlVO deleteSchdl = new EmpSchdlVO();
		deleteSchdl.setEmpNo("E120001");
		deleteSchdl.setSchdlTitle("tttitle");
		
		int rowcnt = dao.deleteEmpSchdl(deleteSchdl);
		assertEquals(1, rowcnt);
		log.info("rowcnt {}", rowcnt);
	}

}
