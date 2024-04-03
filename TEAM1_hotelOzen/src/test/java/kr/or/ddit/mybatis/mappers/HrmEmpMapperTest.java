package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.HrmEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class HrmEmpMapperTest extends AbstractRootContextTest{
	
	@Inject
	private HrmEmpMapper dao;

	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testSelect() {
		HrmEmpVO empTarget = dao.select("E230005");
		log.info("찾는emp: {}", empTarget);
	}
	
	@Test
	void testSelectNewEmpNo() {
		String newEmpNo = dao.selectNewEmpNo();
		log.info("찾는emp: {}", newEmpNo);
	}


	@Test
	void testSelectList() throws IOException {
		log.info("전체 : {}", dao.selectList());
		log.info("근태 : {}", dao.selectDclzList());
		log.info("퇴사자: {}", dao.selectRtrmList());
		List<HrmEmpVO> list = dao.selectList();
		
//		    try(InputStream is = HrmEmpMapperTest.class.getResourceAsStream("template2024.xlsx")) {
		
		    try(InputStream is = HrmEmpMapperTest.class.getResourceAsStream("d:/temp/111.xlsx")) {
		        try (OutputStream os = new FileOutputStream("d:/temp/template2024_2.xlsx")) {
		            Context context = new Context();
		            context.putVar("list", list);
		            JxlsHelper.getInstance().processTemplate(is, os, context);
		        }
		    }
		
		
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		int cnt = dao.delete("E230005"); 
		assertEquals(1, cnt);
	}

}
