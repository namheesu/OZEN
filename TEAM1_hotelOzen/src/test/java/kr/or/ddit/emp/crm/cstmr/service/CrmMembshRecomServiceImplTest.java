package kr.or.ddit.emp.crm.cstmr.service;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.mybatis.mappers.RecomMbrshMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CrmMembshRecomServiceImplTest extends AbstractRootContextTest {

	@Inject
	private CrmMembshRecomService service;
	
	@Inject
	private RecomMbrshMapper mapper;
	
	@Test
	void testGetRecomMbrsh() {
		//log.info("{}", service.getRecomMbrsh("M1800007"));
		//log.info("{}", service.getRecomMbrsh("M2400056"));
		log.info("{}",mapper.selectHistoryAndMembsh("M2400065"));
		log.info(" M2400056{}",mapper.selectHistoryAndMembsh("M2400056"));
		log.info(" M2400056{}",mapper.selectRandomRecom());
		
		
		
	}

}
