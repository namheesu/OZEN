package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CstmrMapperTest extends AbstractRootContextTest {

	@Inject
	CstmrMapper dao;
	
	@Test
	void test() {
		CstmrVO user = new CstmrVO();
		user.setCstNm("진실");
		user.setCstHp("010-3562-9875");
		log.info("{}", dao.checkUser(user));
		
		MberVO mber = new MberVO();
		mber.setMberId("mjosef2q@cnn.com");
		
		user.setMber(mber);
		
		log.info("{}", dao.checkUser(user));
	}
	
	@Test
	void test2() {
		CstmrVO user = new CstmrVO();
		user.setCstNm("진실");
		user.setCstHp("010-3562-9875");
		
		MberVO mber = new MberVO();
		mber.setMberId("mjosef2q@cnn.com");
		
		user.setMber(mber);
		
		
	}

}
