package kr.or.ddit.mybatis.mappers;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.FaqVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CstmrFAQMapperTest extends AbstractRootContextTest{

	@Inject
	private CstmrFAQMapper dao;
	
	@Test
	void test() {
		List<FaqVO> daoFAQ = dao.FAQList();
		log.info("faq {}", daoFAQ);
	}
}
