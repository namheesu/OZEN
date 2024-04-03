package kr.or.ddit.cstmr.recom.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CstmrIntrcnRecomServiceImplTest extends AbstractRootContextTest{

	@Inject
	private CstmrIntrcnRecomCarService service;
	
	@Test
	void test() {
		String cstNo = "M1800001";
		
		log.info("{}",service.retrieveCar(cstNo));
	}

}
