package kr.or.ddit.mybatis.mappers;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class OprtnSttsMapperTest extends AbstractRootContextTest{
	
	@Inject
	private OprtnSttsMapper dao;

	@Test
	void fxtrsTest() {
		PaginationInfo paging = new PaginationInfo(1, 3);
		int totalPage = dao.fxtrsSelectTotalRecord(paging,"E120002");
		paging.setTotalRecord(totalPage);
		paging.setCurrentPage(1);
		List<FxtrsRqstVO> fxtrsList = dao.fxtrsSelectList(paging, "E120002");
		log.info("pagingggFx {}" , fxtrsList);
	}
	
	@Test
	void annualTest() {
		PaginationInfo paging = new PaginationInfo(1,3);
		int totalPage = dao.annSelectTotalRecord(paging, "E120002");
		paging.setTotalRecord(totalPage);
		paging.setCurrentPage(1);
		List<AnnualVO> annualList = dao.annSelectList(paging, "E120002");
		log.info("annualListttt {}", annualList);
	}

}
