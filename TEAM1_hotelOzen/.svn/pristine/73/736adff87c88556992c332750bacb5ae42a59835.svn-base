package kr.or.ddit.mybatis.mappers;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpNoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmpNoticeMapperTest extends AbstractRootContextTest {

	@Inject
	private EmpNoticeMapper dao;
	
	@Test
	void testSelectList() {
		PaginationInfo paging = new PaginationInfo(3, 7);
		int totalPage= dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalPage);
		paging.setCurrentPage(1);
		List<EmpNoticeVO> list = dao.selectList(paging);
		log.info("페이지 {}", list);
	}

	@Test
	void testSelectTotalRecord() {
		PaginationInfo paging = new PaginationInfo(2, 3);
		int cnt = dao.selectTotalRecord(paging);
		log.info("{}", cnt);
	}

	@Test
	void testInsert() {
		EmpNoticeVO newData = new EmpNoticeVO();
		newData.setEmpNtClassification("일반");
		newData.setEmpNo("E230006");
		newData.setEmpNtNm("공지공지공지공지");
		newData.setEmpNtCn("아ㅣㄹㅇ닌리얼");
		int check = dao.insert(newData);
		log.info("{}", check);
	}

	@Test
	void testSelect() {
		EmpNoticeVO oneNotice = dao.select("ENT0001");
		log.info("{}", oneNotice);
	}

	@Test
	void testUpdate() {
		EmpNoticeVO target = new EmpNoticeVO();
		target.setEmpNtNo("ENT0001");
		target.setEmpNtNm("새해 복 많이 받으세요");
		target.setEmpNtCn("안녕하세요 호텔 오젠 임직원 여러분 2023 새해가 밝았습니다. 한 해 동안 우리 호텔을 위해 열심히 수고해주신 여러분들께 감사인사를 드립니다.");
		target.setEmpNtCnt(454545);
		int oneNotice = dao.update(target);
		
	}

	@Test
	void testDelete() {
		String del = "ENT0012";
		dao.delete(del);
		
	}

}
