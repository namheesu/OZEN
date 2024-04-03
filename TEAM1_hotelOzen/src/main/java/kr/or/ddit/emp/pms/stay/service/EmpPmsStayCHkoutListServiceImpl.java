package kr.or.ddit.emp.pms.stay.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkoutVO;
import kr.or.ddit.mybatis.mappers.EmpStayChkoutMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsStayCHkoutListServiceImpl implements EmpPmsStayChkoutListService {

	private final EmpStayChkoutMapper dao;

	@Override
	public List<ChkoutVO> retreieveChkoutList(PaginationInfo paging) {

		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);

		List<ChkoutVO> chkoutList = dao.selectList(paging);
		return chkoutList;
	}

	@Override
	public Map<String, Object> retreieveChkout(String chkinNo) {

		Map<String, Object> chkoutView = new HashMap<>();

		ChkoutVO chkout = dao.select(chkinNo);
		chkoutView.put("chkout", chkout);

		List<ChkoutVO> chkoutRms = dao.selectRms(chkinNo);
		chkoutView.put("chkoutRms", chkoutRms);

		return chkoutView;
	}

	@Override
	public ServiceResult modifyChkout(String chkinNo) {

		ServiceResult result = null;

		Map<String, Object> setle = new HashMap<>();
		setle.put("chkinNo", chkinNo);

		String cstNo = dao.selectCstmrNo(chkinNo); // 고객번호
		setle.put("cstNo", cstNo);

		int setleAmnt = dao.selectRmsAmnt(chkinNo); // 결제금액
		setle.put("setleAmnt", setleAmnt);

		if (Integer.parseInt(setle.get("setleAmnt").toString()) != 0) {
			String setleNo = dao.selectSetleNo(); // 결제일련번호
			setle.put("setleNo", setleNo);
			
			int setleInsert = dao.insertSetle(setle); // 결제 테이블 insert			
		}

		int chkoutUpdate = dao.updateChkout(setle); // 체크아웃테이블 update

		String rsvtDtlNo = dao.selectRsvtDTL(chkinNo); // 예약상세 번호
		log.info("{}", rsvtDtlNo);
		setle.put("rsvtDtlNo", rsvtDtlNo);
		
		if(setle.get("rsvtDtlNo") == null) {
			int rsvtDtlUpdate = dao.updatersvtDtl(setle);			
		}

		String rmNo = dao.selectRmNo(chkinNo);
		setle.put("rmNo", rmNo);

		int roomUpdate = dao.updateRoom(setle);

		if (chkoutUpdate != 1) {
			throw new RuntimeException();

		} else if (roomUpdate != 1) {
			throw new RuntimeException();

		} else {
			result = ServiceResult.OK;
		}

		return result;
	}

}
