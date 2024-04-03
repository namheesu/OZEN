package kr.or.ddit.mybatis.mappers;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.MberNoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MberNoticeMapperTest extends AbstractRootContextTest{

	@Inject
	private MberNoticeMapper dao; 

	@Test
	void testList() {
		PaginationInfo paging = new PaginationInfo(10, 3);
		int totalPage = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalPage);
		paging.setCurrentPage(1);
		List<MberNoticeVO> memNotiList = dao.selectList(paging);
		log.info("pageing {}" , memNotiList);
	}
	
	@Test
	void testView() {
		MberNoticeVO mbernt = dao.mberNoticeView("NNT0011");
		log.info("mberNotice {}", mbernt);
	}
}
