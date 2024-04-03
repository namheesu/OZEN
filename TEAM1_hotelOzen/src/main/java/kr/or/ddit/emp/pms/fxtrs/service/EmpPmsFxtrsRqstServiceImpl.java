package kr.or.ddit.emp.pms.fxtrs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpAlramVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.FxtrsPrchsSttstVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import kr.or.ddit.global.vo.FxtrsVO;
import kr.or.ddit.mybatis.mappers.EmpFxtrsRqstMapper;
import kr.or.ddit.mybatis.mappers.EmpSanctnMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpPmsFxtrsRqstServiceImpl implements EmpPmsFxtrsRqstService {

	private final EmpFxtrsRqstMapper dao;
	
	private final EmpSanctnMapper sandao;
	
	@Override
	public Map<String, Object> retrieveFxtrsRqstList(PaginationInfo paging) {
		
		Map<String, Object> fxtrsRqsttMap = new HashMap<>();
		
		int totalRecord = dao.selectTotalRecord(paging);
		fxtrsRqsttMap.put("totalRecord", totalRecord);
		paging.setTotalRecord(totalRecord);
		
		int ListRecord = dao.selectTotal();
		fxtrsRqsttMap.put("ListRecord", ListRecord);
		
		int rqstRecord = dao.selectrqstTotal();
		fxtrsRqsttMap.put("rqstRecord", rqstRecord);
		
		int payRecord = dao.payTotal();
		fxtrsRqsttMap.put("payRecord", payRecord);
		
		int payClearRecord = dao.payClearTotal();
		fxtrsRqsttMap.put("payClearRecord", payClearRecord);
		
		int returnRecord = dao.returnTotal();
		fxtrsRqsttMap.put("returnRecord", returnRecord);
		
		List<FxtrsRqstVO> rqstList = dao.selectList(paging);
		for(int i = 0; i < rqstList.size(); i ++) {
			String empNo = rqstList.get(i).getEmpNo(); //요쳥자
			String empRqNo = rqstList.get(i).getEmpRqNo(); //요쳥결재자
			String empPurchsNo = rqstList.get(i).getEmpPurchsNo(); //구매결재자
			if (empNo != null || empRqNo != null || empPurchsNo != null){
	            FxtrsRqstVO rqstVO = rqstList.get(i);
	            if (empNo != null) {
	                FxtrsRqstVO empNm = dao.selectEmpName(empNo);
	                rqstVO.setEmpNm(empNm.getEmpNm());
	            }
	            if (empRqNo != null) {
	                FxtrsRqstVO empRqNm = dao.selectEmpName(empRqNo);
	                rqstVO.setEmpRqNm(empRqNm.getEmpNm());
	            }
	            if (empPurchsNo != null) {
	                FxtrsRqstVO empPurchsNm = dao.selectEmpName(empPurchsNo);
	                rqstVO.setEmpPurchsNm(empPurchsNm.getEmpNm());
	            }
	        }
		}
		fxtrsRqsttMap.put("rqstList", rqstList);
		return fxtrsRqsttMap;
	}

	@Override
	public String retrieveRqstNo() {
		String rqstNo = dao.selectRqstNo();
		return rqstNo;
	}
	
	@Override
	public EmpVO retrieveRqstEmp() {
		EmpVO fxRqstEmp = dao.selectRqstEmp();
		return fxRqstEmp;
	}

	@Override
	public FxtrsVO retrieveFxtrs(String fxCd) {
		FxtrsVO fxtrs = dao.selectFxtrs(fxCd);
		return fxtrs;
	}

	@Override
	public ServiceResult createFxtrsRqst(Map<String, Object> fxData) {
		ServiceResult result = null;
		
		int fxtrsRqstInsert = dao.insertFxtrsRqst(fxData); //비품 사용 insert
		
		if (fxtrsRqstInsert != 1) {
			throw new RuntimeException();
		} else {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public ServiceResult createFxtrsRqstDtl(Map<String, Object> fxData) {
		ServiceResult result = null;
		
		int fxtrsRqstDtlInsert = dao.insertFxtrsRqstDtl(fxData); //비품 사용 insert
		
		if (fxtrsRqstDtlInsert != 1) {
			throw new RuntimeException();
		} else {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public Map<String, Object> retrieveFxtrsRqst(String fxtrsRqstNo) {
		Map<String, Object> fxtrs = new HashMap<>();
		
		FxtrsRqstVO fxtrsRqst = dao.selectFxtrsRqst(fxtrsRqstNo);
		fxtrs.put("fxtrsRqst", fxtrsRqst);
		
		String empRqNo = fxtrsRqst.getEmpRqNo();
		String empRqNm = dao.selectEmpRqNm(empRqNo);
		
		String empPurNo = fxtrsRqst.getEmpPurchsNo();
		String empPurNm = dao.selectEmpRqNm(empPurNo);
		
		fxtrs.put("empRqNm", empRqNm);
		fxtrs.put("empPurNm", empPurNm);
		
		return fxtrs;
	}

	@Override
	public ServiceResult updateFxtrsApproval(String fxRqstNo) {
		ServiceResult result = null;
		
		Map<String, Object> updateData = new HashMap<>();
		updateData.put("fxRqstNo", fxRqstNo);
		
		String rqstPurchs = dao.selectRqstPurchs();
		updateData.put("rqstPurchs", rqstPurchs);
		log.info("rqstPurchs",rqstPurchs);
		
		int approvalUpdate = dao.updateFxtrsApproval(updateData);
		
		if (approvalUpdate != 1) {
			throw new RuntimeException();
		} else {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public ServiceResult updateFxtrsRecusal(String fxRqstNo) {
		ServiceResult result = null;
		
		int recusalUpdate = dao.updateFxtrsRecusal(fxRqstNo);
		
		if (recusalUpdate != 1) {
			throw new RuntimeException();
		} else {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public int createEmpAlram(EmpAlramVO empAlram) {
		return dao.insertFxtrsAlram(empAlram);
	}

	@Override
	public ServiceResult updateFxtrsPurOk(FxtrsRqstVO fxtrsRqstVO) {
		ServiceResult result = null;
		
		// 비품요청 상태 변경
		int purUpdate = dao.updateFxtrsPur(fxtrsRqstVO);
		
		if(purUpdate != 1) {
			throw new RuntimeException();
		}
		
		// 요청상세 조회
		FxtrsRqstVO fxtrsRqstList = dao.selectFxtrsRqst(fxtrsRqstVO.getRqstNo());
		
		List<FxtrsPrchsSttstVO> fxtrsPrchsSttsVO = new ArrayList<>();
		int fxtrsCnt = 0;
		FxtrsVO fxtrsVO = new FxtrsVO();
		// 요청상세 목록
		for(int i = 0; i < fxtrsRqstList.getFxtrsRqstDtl().size(); i++){
			FxtrsPrchsSttstVO fxtrsPrchsSttstVO = new FxtrsPrchsSttstVO();
		    fxtrsPrchsSttsVO.add(fxtrsPrchsSttstVO);
			fxtrsPrchsSttsVO.get(i).setFxCd(fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxtrs().getFxCd());
			fxtrsPrchsSttsVO.get(i).setEmpNo(fxtrsRqstList.getEmpNo());
			fxtrsPrchsSttsVO.get(i).setPrchsFxNm(fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxtrs().getFxNm());
			fxtrsPrchsSttsVO.get(i).setPrchsFxCnt(fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxRqstCnt());
			fxtrsPrchsSttsVO.get(i).setPrchsAmnt(fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxRqstTotalamnt());
			fxtrsPrchsSttsVO.get(i).setRqstNo(fxtrsRqstList.getRqstNo());
			
			
			// 구매 단위
			int cnt = fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxtrs().getFxUnit();
			// 현재 수량
			fxtrsCnt = sandao.selectFxtrsCnt(fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxtrs().getFxCd());
			// 현재 수량 + 요청 수량
			fxtrsCnt += fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxRqstCnt() + (fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxRqstCnt()*cnt);
			fxtrsVO.setFxCd(fxtrsRqstList.getFxtrsRqstDtl().get(i).getFxtrs().getFxCd());
			fxtrsVO.setFxPresCnt(fxtrsCnt);
			sandao.updateFxtrsCnt(fxtrsVO);
		}
		
		// 구매예정 테이블 insert
		int fxprchsInsert = sandao.insertFxtrsPrchsSttst(fxtrsPrchsSttsVO);
		
		if( fxprchsInsert < fxtrsPrchsSttsVO.size()) {
			throw new RuntimeException();
		}
		result = ServiceResult.OK;
		
		return result;
	}
	
	@Override
	public ServiceResult updateFxtrsPurDec(FxtrsRqstVO fxtrsRqstVO) {
		ServiceResult result = null;
		
		// 비품요청 상태 변경
		int purUpdate = dao.updateFxtrsPur(fxtrsRqstVO);
		
		if(purUpdate != 1) {
			throw new RuntimeException();
		}
		result = ServiceResult.OK;
		
		return result;
	}



}
