package kr.or.ddit.emp.pos.refund.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.emp.pos.acnt.refund.service.EmpPosRefndService;
import kr.or.ddit.global.common.paging.PaginationInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpPosRefndServiceImplTest extends AbstractRootContextTest{

	@Inject
	private EmpPosRefndService service;
	
	
	@Test
	void test() {
		
//		assertNotNull(service.retrieveRefndList());
//		log.info("{}",service.retrieveRefndList());
	}

}
