package kr.or.ddit.cstmr.rsvt.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;

class CstmrRsvtRetrieveServiceImplTest extends AbstractRootContextTest{

	@Inject
	private CstmrRsvtRetrieveService service;
	
	@Test
	void test() {
		String rsvtNo = "RSV24020064";
		String cstHp = "010-4352-5674";
		
		Map<String,Object> rsvt = new HashMap<>();
		rsvt.put("cstHp", cstHp);
		rsvt.put("rsvtNo", rsvtNo);
//		service.retrieveNberRsvt(rsvt);
	}

}
