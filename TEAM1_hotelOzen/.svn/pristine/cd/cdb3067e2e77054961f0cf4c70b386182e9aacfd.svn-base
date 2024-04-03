package kr.or.ddit.emp.pms.rsvt.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.RoomVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.mybatis.mappers.EmpRsvtAddMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsRsvtAddServiceImpl implements EmpPmsRsvtAddServcie{

	private final EmpRsvtAddMapper dao;
	
	@Override
	public Map<String, Object> retrieveRoomList(String roomTypeNm) {
		
		Map<String, Object> rsvtselect = new HashMap<>();
		
		List<RoomVO> rsvtroomList = dao.selectList(roomTypeNm); //객실타입에 맞는 객실 조회
		
		int rsvtYmdCnt = dao.selectRsvtCnt(roomTypeNm); //예약 객실수 조회
		
		rsvtselect.put("rsvtroomList", rsvtroomList);
		rsvtselect.put("rsvtYmdCnt", rsvtYmdCnt);
		
		return rsvtselect;
	}

	@Override
	public int retrieveCarYN(String carNo) {
		int carYN = dao.selectCarYN(carNo); //차량 유무 조회
		return carYN;
	}
	
	@Override
	public ServiceResult createChkin(ChkinVO newChkin) {
		
		Map<String, Object> chkin = new HashMap<>();
		
		ServiceResult result = null;
		
		CstmrVO cstmr = new CstmrVO();
		
		String cstNo = dao.selectCstmrNo(); //고객번호 생성
		cstmr.setCstNo(cstNo);
		cstmr.setCstNm(newChkin.getCstmr().getCstNm()); //[고객이름]
		cstmr.setCstHp(newChkin.getCstmr().getCstHp()); //[고객 휴대폰]
		
		chkin.put("cstNo", cstNo);
		
		int cstmrInsert = dao.insertCstmr(cstmr); //워크인 고객 insert
		
		String setleNo = dao.selectSetleNo(); //결제번호 생성
		chkin.put("setleNo", setleNo);
		
		Map<String, Object> setles = new HashMap<>();
		setles.put("setleNo", setleNo); 
		setles.put("cstNo", cstNo);
	    
		setles.put("setleAmnt",newChkin.getSetle().getSetleAmnt()); //[결제 가격]
		
		dao.insertSetle(setles); // 결제테이블 insert	
		
		String carKindNo = dao.selectCarNo(newChkin.getCar().getCarNm());
		chkin.put("carKindNo", carKindNo); //차종에 차량코드
		
		String chkinNo = dao.selectChkinNo(); // 체크인번호 생성
		chkin.put("chkinNo", chkinNo);
		
		LocalDateTime ciDtTest = LocalDateTime.parse(newChkin.getCiDt(), DateTimeFormatter.ISO_DATE_TIME);
		DateTimeFormatter dtformt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String ciDt = ciDtTest.format(dtformt);
		chkin.put("rmNo", newChkin.getRmNo());
		chkin.put("ciCarNo", newChkin.getCiCarNo());
		chkin.put("ciDt", ciDt);
		chkin.put("ciCowillYmd", newChkin.getCiCowillYmd().toString());
		chkin.put("ciTotalNmpr", newChkin.getCiTotalNmpr());
		chkin.put("ciAultCnt", newChkin.getCiAdultCnt());
		chkin.put("cichildCnt", newChkin.getCiChildCnt());
		
		log.info("#########{}",chkin);
		int chkinInsert = dao.insertChkin(chkin); //체크인 테이블 insert
		
		int chkoutInsert = dao.inserChkout(chkinNo); //체크아웃 테이블 insert
		log.info("######chkoutInsert:{}",chkoutInsert);
		
		
		if(chkinInsert != 1 || cstmrInsert != 1 || chkoutInsert != 1) {
			throw new RuntimeException();
		}else {
			result = ServiceResult.OK;
		}
		String rmNo = newChkin.getRmNo();
		int roomUpdate = dao.updateRoom(rmNo); //객실테이블 update
		
		int parkingUpdate = dao.updateParking(newChkin.getCiCarNo()); //주차테이블 update
		
		return result;
	}

}
