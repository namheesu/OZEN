package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RegistVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MberMapperTest extends AbstractRootContextTest {

	@Inject
	private MberMapper dao;
	
	@Test
	public void selectTest() {
		log.info("{}", dao);
		MberVO vo = dao.select("M2400001");
		assertNotNull(vo);
	}

	@Test
	public void selectTotalRecordTest() {
		log.info("{}", dao.selectList());
		
	}
	
	@Test
	public void selectusernameTest() {
		dao.selectMberByUserName("sujin06@hanmail.net");
	}
	
	@Test
	public void insertTest() {
		String newCstNo = dao.selectNewCstNo();
		log.info("{}", newCstNo);
		
		RegistVO newMber = new RegistVO();
		
		newMber.setCstNo(newCstNo);
		newMber.setCstNm(newCstNo);
		newMber.setCstHp(newCstNo);
		newMber.setMberId(newCstNo);
		newMber.setMberPw(newCstNo);
		newMber.setMberAddr(newCstNo);
		
//		dao.insertCstmr(newMber);
		dao.insertMber(newMber);
	}
	
	@Test
	public void selectByNameAndHp() {
		RegistVO newMber = new RegistVO();
		newMber.setCstNm("김춘자");
		newMber.setCstHp("010-4377-3580");
		
		dao.findMberUser(newMber);
	}
}
