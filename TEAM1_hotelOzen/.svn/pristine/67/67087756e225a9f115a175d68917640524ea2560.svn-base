package kr.or.ddit.mybatis.mappers;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.SbrsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MberSbrsLiarMapperTest extends AbstractRootContextTest{

	@Inject
	private MberSbrsLiarMapper dao;

	@Test
	void test() {
		List<SbrsVO> sbrsLiarList = dao.sbrsLiarList();
		log.info("sbrsLiarrrr {}", sbrsLiarList);
	}

}
