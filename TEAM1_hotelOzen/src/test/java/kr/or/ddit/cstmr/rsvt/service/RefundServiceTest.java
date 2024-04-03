package kr.or.ddit.cstmr.rsvt.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;

class RefundServiceTest extends AbstractRootContextTest{

	@Inject
	private RefundService service;
	
	@Test
	void test() throws IOException {
		String token = service.getToken("2321751576818553", "blhkWoYeaswfXI5HHqu7apes10sIdWTwsUk8cqZgQJcf3aQnZ4eKtFCz5fc20VZ50J2eqnUBIwsLljqI");
		service.refundRequest(token, "nobody_1710937235742", "예약취소");
	}

}
