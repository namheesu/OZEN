package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpRsvtMapperTest extends AbstractRootContextTest{

	@Inject
	private EmpRsvtMapper dao;
	
	@Test
	void selectList() {
		PaginationInfo paging = new PaginationInfo();
		
		paging.setCurrentPage(1);
		
		log.info("{}", dao.selectList(paging));
	}

	@Test
	void total() {
		PaginationInfo paging = new PaginationInfo();
				
		paging.setCurrentPage(1);
		
		log.info("{}", paging);
		log.info("{}", dao.selectTotalRecord(paging));
	}
	
	@Test
	void selectRsvt() {
		
		String rsvtNo = "RSV24020055";
		
		log.info("{}", dao.select(rsvtNo));
	}
	
	@Test
	void updateSe() {
		String rsvtNo = "RSV24020055";
		
		log.info("{}", dao.updateCXL(rsvtNo));
	}
}
