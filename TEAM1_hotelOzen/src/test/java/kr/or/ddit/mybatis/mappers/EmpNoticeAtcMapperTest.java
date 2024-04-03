package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.AtchmnflEmpNoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpNoticeAtcMapperTest extends AbstractRootContextTest {
	
	@Inject
	private EmpNoticeAtcMapper dao;

	@Test
	void testInsertAtc() {
		AtchmnflEmpNoticeVO vo = new AtchmnflEmpNoticeVO();
		vo.setAtcEmpFileNm("집에 가고 싶다");
		vo.setAtcEmpNtUuid("homehome");
		vo.setEmpNtNo("ENT0013");
		int cnt = dao.insertAtc(vo);
		log.info("{}", vo);
		assertEquals(1, cnt);
		
	}

	@Test
	void testSelectAtc() {
		AtchmnflEmpNoticeVO vo = dao.selectAtc(1);
		log.info("{}", vo);
	}

	@Test
	void testDeleteAtc() {
		int cnt = dao.deleteAtc(1);
		assertEquals(1, cnt);
	}

}
