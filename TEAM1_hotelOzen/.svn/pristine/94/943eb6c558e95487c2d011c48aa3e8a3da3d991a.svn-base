package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.RsvtVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CstmrRsvtMapperTest extends AbstractRootContextTest{

	@Inject
	private CstmrRsvtMapper dao;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void selectAge() {
		String cstNo = "M2400019";
		log.info("{}", dao.select(cstNo));
	}
	
	@Test
	void selectRcRm() {
		String age = "4";
		String totalNmpr = "2";
		
		Map<String, Object> customerData = new HashMap<>();
        customerData.put("age", age);
        customerData.put("totalNmpr", totalNmpr);
        
		log.info("{}", dao.selectRcRm(customerData));
	}
	
	@Test
	void selectRmt() {
		String rmtype = "STT";
		log.info("{}",dao.selectRmt(rmtype));
	}
	
	@Test
	void selectRsvtRmt() {
		int nbrCnt = 2;
		LocalDate rsvtCheckinYmd = LocalDate.of(2024,3,13);
		LocalDate rsvtCheckoutYmd = LocalDate.of(2024,3,14);
		int rsvtRoomCnt = 2;
		RsvtVO rsvtData = new RsvtVO();
		rsvtData.setRsvtCheckinYmd(rsvtCheckinYmd);
		rsvtData.setRsvtCheckoutYmd(rsvtCheckoutYmd);
		rsvtData.setRsvtNberCnt(nbrCnt);
		rsvtData.setRsvtRoomCnt(rsvtRoomCnt);
		rsvtData.setRsvtMaxNberCnt(2);
		
		log.info("{}",dao.selectRsvtRmt(rsvtData));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
