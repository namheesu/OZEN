package kr.or.ddit.mybatis.mappers;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpAlramMapperTest extends AbstractRootContextTest{

	@Inject
	EmpAlramMapper dao;
	
	@Test
	void empRqNoSelect() {
		log.info("{}", dao.selectAlram("E120002"));
	}

}
