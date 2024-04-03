package kr.or.ddit.emp.pms.fxtrs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.FxtrsClsCdVO;
import kr.or.ddit.global.vo.FxtrsUseVO;
import kr.or.ddit.global.vo.FxtrsVO;
import kr.or.ddit.global.vo.RoomVO;
import kr.or.ddit.mybatis.mappers.EmpFxtrsUseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsFxtrsUseServiceImpl implements EmpPmsFxtrsUseService {

	private final EmpFxtrsUseMapper dao;
	
	@Override
	public List<FxtrsUseVO> retrieveFxtrsUseList(PaginationInfo paging) {
		
		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<FxtrsUseVO> fxtrsUseDtL = dao.selectList(paging);
		log.info("###fxtrsUseDtL:{}",fxtrsUseDtL);
		return fxtrsUseDtL;
		
	}

	@Override
	public String retrieveFxUseNo() {
		String fsUseNo = dao.selectFxUseNo();
		return fsUseNo;
	}
	
	@Override
	public List<FxtrsClsCdVO> retrieveFxtrsCd() {
		List<FxtrsClsCdVO> fxtrsCd = dao.selectFxCd();
		return fxtrsCd;
	}
	
	@Override
	public List<FxtrsVO> retrieveFxtrsNmList(String fxtrsCd) {
		List<FxtrsVO> fxtrsNmList = dao.selectFxNm(fxtrsCd);
		return fxtrsNmList;
	}
	
	@Override
	public List<RoomVO> retrievefloorList(String floor) {
		List<RoomVO> rmFloorList = dao.selectRmFloor(floor);
		return rmFloorList;
	}

	@Override
	public ServiceResult createFxtrsUse(Map<String, Object> fxData) {
		log.info("########fxData{}",fxData);
		
		ServiceResult result = null;
		
		int fxtrsUseInsert = dao.insertFxtrsUse(fxData); //비품 사용 insert
		
		if (fxtrsUseInsert != 1) {
			throw new RuntimeException();
		} else {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public ServiceResult createFxtrsUseDtl(Map<String, Object> fxData) {
		ServiceResult result = null;
		
		String fxclsNm = (String) fxData.get("fxclsNm");
		log.info("########################fxclsNm:{}",fxclsNm);
		
		String fxclsCd = dao.selectFxClsCd(fxclsNm);
		log.info("##########################fxclsCd:{}",fxclsCd);
		fxData.put("fxclsCd", fxclsCd);
		
		int fxtrsUseDtlInsert = dao.insertFxtrsUseDtl(fxData); //비품상세 insert
		
		String fxCd = (String) fxData.get("fxCd");
		String fxPresCnt = dao.selectFxPresCnt(fxCd);
		log.info("######fxPresCnt:{}",fxPresCnt);
		
		String fxudCnt = (String) fxData.get("fxudCnt");
		
		int updateCnt = Integer.parseInt(fxPresCnt) - Integer.parseInt(fxudCnt);
		fxData.put("updateCnt", updateCnt);
		
		int fxtrsUpdate = dao.updateFxPresCnt(fxData); //비품 수량 변경 update
		
		if (fxtrsUseDtlInsert != 1) {
			throw new RuntimeException();
		}else if(fxtrsUpdate != 1) {
			throw new RuntimeException();
		}else {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public Map<String, Object> retrieveFxtrs(String fxuseNo) {
		Map<String, Object> fxtrsList = new HashMap<>();
		FxtrsUseVO fxtrs = dao.selectFxtrsUse(fxuseNo);
		fxtrsList.put("fxtrs", fxtrs);
		
		List<FxtrsUseVO> fxtrsDtl = dao.selectFxtrsUseDtl(fxuseNo);
		fxtrsList.put("fxtrsDtl", fxtrsDtl);
		
		return fxtrsList;
	}

}
