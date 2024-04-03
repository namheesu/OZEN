package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpRsvtAddMapperTest extends AbstractRootContextTest{

	@Inject
	private EmpRsvtAddMapper dao;
	
	@Test
	void testSelectList() {
		String rmType = "STD";
		log.info("{}",dao.selectList(rmType));
	}
	
	@Test
	void testRsvtChkinYmd() {
		String rmType = "STD";
		log.info("{}", dao.selectRsvtCnt(rmType));
	}
	
	@Test
	void testCarYN() {
		String carNo = "64가8520";
		log.info("{}", dao.selectCarYN(carNo));
	}
	
}
