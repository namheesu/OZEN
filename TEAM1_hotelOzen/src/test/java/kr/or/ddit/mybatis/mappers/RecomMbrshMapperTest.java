package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.RecomMbrshVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RecomMbrshMapperTest extends AbstractRootContextTest{

	@Inject
	private RecomMbrshMapper dao;
	
	@Test
	void testSelect() {
		RecomMbrshVO vo = dao.select("M1800004");
		assertNotNull(vo);
		log.info("이것은 어떤 회원에 대한 추천 멤버십 3개가 담긴 것. {}", vo);
	}

}
