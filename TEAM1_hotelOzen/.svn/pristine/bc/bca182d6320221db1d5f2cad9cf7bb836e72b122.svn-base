package kr.or.ddit.emp.pms.stay.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.mybatis.mappers.EmpStayChkinMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsStayChkinLisServiceImpl implements EmpPmsStayChkinListService{
	
	private final EmpStayChkinMapper dao;
	
	@Override
	public List<RsvtVO> retrieveChkinList(PaginationInfo paging) {
		
		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<RsvtVO> chkinList = dao.selectList(paging);
		return chkinList;
	}

	@Override
	public RsvtDetailsVO retrieveRsvt(String rsvtDtlNo) {
		RsvtDetailsVO rsvt = dao.select(rsvtDtlNo);
		if(rsvt == null) {
			throw new PKNotFoundException(String.format("%s에 해당하는 사용자 없음", rsvtDtlNo));
		}
		return rsvt;
	}

	@Override
	public ServiceResult createChkin(ChkinVO newChkin) {
		
		Map<String, Object> chkin = new HashMap<>();
		chkin.put("rsvtDtlNo", newChkin.getRsvtDtlNo());
		
		ServiceResult result = null;
		
		chkin.put("cstNo", newChkin.getCstmr().getCstNo()); //[고객번호]
		chkin.put("cstNm", newChkin.getCstmr().getCstNm()); //[고객이름]
		chkin.put("cstHp", newChkin.getCstmr().getCstHp()); //[고객 휴대폰] 
		log.info("######################11 chkin:{}", chkin);
		
		String carKindNo = dao.selectCarNo(newChkin.getCiCarKind());
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
		chkin.put("rsvtDtlNo", newChkin.getRsvtDtlNo());
		
		log.info("#########22 chkin:{}",chkin);
		
		int chkinInsert = 0;
		int parkingUpdate = 0;
		if(chkin.get("carKindNo") == null) {
			log.info("차가 음씀");
			chkinInsert = dao.inserChkoutNoCar(chkin); //차가 없는 고객 체크인 테이블 insert
		}else {
			log.info("차가 이씀");
			chkinInsert = dao.insertChkin(chkin); //체크인 테이블 insert			
			parkingUpdate = dao.updateParking(newChkin.getCiCarNo()); //주차테이블 update
			if (parkingUpdate != 1) {
				throw new RuntimeException();
				
			}
		}
		
		int chkoutInsert = dao.inserChkout(chkinNo); //체크아웃 테이블 insert
		
		
		String rmNo = newChkin.getRmNo();
		int roomUpdate = dao.updateRoom(rmNo); //객실테이블 update
		
		
		int RsvtUpdate = dao.updateRsvt(newChkin.getRsvtDtlNo()); //예약 상태 update
		
		if (chkinInsert != 1) {
			throw new RuntimeException();
		} else if (chkoutInsert != 1) {
			throw new RuntimeException();

		} else if (roomUpdate != 1) {
			throw new RuntimeException();

		} else if (RsvtUpdate != 1) {
			throw new RuntimeException();
			
		} else {
			result = ServiceResult.OK;
		}
		
		return result;
	}

}
