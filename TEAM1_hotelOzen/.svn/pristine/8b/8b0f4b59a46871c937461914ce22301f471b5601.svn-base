package kr.or.ddit.emp.myinfo.recom.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.emp.myinfo.cert.service.EmpMyinfoCertService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpMyinfoRecomServiceImplTest extends AbstractRootContextTest {

	@Inject
	private EmpMyinfoCertService service;
	
	@Test
	void testRetrieveRecomCertList() {
		log.info("{}", service.retrieveRecomCertList("E230020"));
	}
}
