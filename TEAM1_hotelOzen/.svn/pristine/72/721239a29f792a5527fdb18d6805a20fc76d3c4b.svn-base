package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpMapperTest extends AbstractRootContextTest {
	
	@Inject
	private EmpMapper dao;
	
	@Test
	void testSelect() {
		EmpVO vo = dao.select("E240001");
		log.info("{}", vo);
	}

	@Test
	void testSelectTotalRecord() {
		
		log.info("{}", dao.selectList());
		
	}
	@Test
	void testSelectbyuserName() {
		
		log.info("{}", dao.selectEmpByUserName("E240001"));
		
	}

	@Test
	void testSelectDeptAndAnnual() {
		
		log.info("{}", dao.selectEmpDeptAndAnnual("E240001"));
		
	}
	
	@Test
	void testChangePwd() {
		EmpVO empVo = new EmpVO();
		empVo.setEmpNo("E240001");
		empVo.setEmpPw("1234");
		log.info("{}", dao.changePwd(empVo));
	}
	
	@Test
	void testFindUser() {
		EmpVO empVo = new EmpVO();
		empVo.setEmpNo("E240001");
		
		empVo.setEmpNm("김주은");
		empVo.setEmpTel("010-1111-1111");
		log.info("{}", dao.findEmpUser(empVo));
		
	}
	
	@Test
	void testUpdateTest() {
		EmpVO empVo = new EmpVO();
		empVo.setEmpNo("E240001");
		
		empVo.setEmpNm("김주은");
		empVo.setEmpAddr("010-1111-1111");
		empVo.setEmpTel("010-1111-1111");
		empVo.setEmpEml("010-1111-1111");
		empVo.setEmpHomeTel("010-1111-1111");
		empVo.setEmpProflNm("010-1111-1111");
		
		dao.update(empVo);
	}
	
	@Test
	void loginEmpsTest() {
		dao.loginEmpVOs();
	}
}
