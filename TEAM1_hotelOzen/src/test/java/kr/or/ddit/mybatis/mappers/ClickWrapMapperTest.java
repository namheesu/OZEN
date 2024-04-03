package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;

class ClickWrapMapperTest extends AbstractRootContextTest {

	@Inject
	ClickWrapMapper dao;
	
	@Test
	void test() {
		dao.selectList();
	}

}
