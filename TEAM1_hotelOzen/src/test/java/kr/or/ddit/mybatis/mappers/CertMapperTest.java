package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.CertVO;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CertMapperTest extends AbstractRootContextTest {

	@Inject
	private CertMapper dao;
	
	@Test
	void testSelectRecomCert() {
		EmpVO user = new EmpVO();
		
		user.setEmpDept("CRM");
		user.setEmpAnnual(2);
		
		log.info("{}", dao.selectRecomCert(user));
	}
	
	@Test
	void testSelectCert() {
		List<CertVO> certList = dao.selectCert("E130004");
		log.info("{}", certList);
	}
}
