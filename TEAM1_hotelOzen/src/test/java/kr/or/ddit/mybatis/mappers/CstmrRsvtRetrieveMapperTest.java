package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.RsvtVO;

class CstmrRsvtRetrieveMapperTest extends AbstractRootContextTest{

	@Inject
	 private CstmrRsvtRetrieveMapper dao;
	
	@Test
	void test() {
		String rsvtNo = "RSV24020064";
		String cstHp = "010-4352-5674";
		
		Map<String,Object> rsvt = new HashMap<>();
		rsvt.put("cstHp", cstHp);
		rsvt.put("rsvtNo", rsvtNo);
//		dao.selectNberRsvtList(rsvt);
	}

}
