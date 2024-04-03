package kr.or.ddit.emp.hrm.dclz.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class HrmDclzTimeServiceImplTest {

	@Test
	void testDate2StringTime() {
		LocalDateTime now = LocalDateTime.now();
		String nnn =now.toString();
		String nnnnnn = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		log.info("{}",nnn );
		log.info("{}",nnnnnn );
	}
}
