package kr.or.ddit.cstmr.rsvt.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.RoomTypeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CstmrRsvtServiceImplTest extends AbstractRootContextTest{

	@Inject
	private CstmrRsvtService service;
	
	@Test
	void test() {
		 String rsvtCheckinYmd = "20240208";
		 String rsvtCheckoutYmd = "20240210";
		 int nbrCnt = 2;
		 int rsvtRoomCnt = 1;
		Map<String, Object> rsvtRmtMap = new HashMap<>();
		rsvtRmtMap.put("rsvtCheckinYmd", rsvtCheckinYmd);
		rsvtRmtMap.put("rsvtCheckoutYmd", rsvtCheckoutYmd);
		rsvtRmtMap.put("nbrCnt", nbrCnt);
		rsvtRmtMap.put("rsvtRoomCnt", rsvtRoomCnt);
//		List<RoomTypeVO> rsvtRmtList = service.retrieveRsvtRmt(rsvtRmtMap);
//		log.info("{}",rsvtRmtList);
	
		
	}

}
