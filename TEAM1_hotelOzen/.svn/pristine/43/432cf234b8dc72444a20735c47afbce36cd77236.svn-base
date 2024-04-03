package kr.or.ddit.emp.pms.roomsvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RmSvcOrderVO;
import kr.or.ddit.global.vo.RmserviceOrderVO;
import kr.or.ddit.global.vo.RmserviceVO;
import kr.or.ddit.mybatis.mappers.EmpRmServiceMapper;
import kr.or.ddit.mybatis.mappers.EmpRmServiceOrderMapper;
import kr.or.ddit.mybatis.mappers.EmpRmServiceRqstMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpPmsRmServiceListServiceImpl implements EmpPmsRmServiceListService {

	@Inject
	private EmpRmServiceOrderMapper ordao;
	
	@Inject
	private EmpRmServiceRqstMapper rqdao;
	
	@Inject
	private EmpRmServiceMapper dao;
	
	@Override
	public List<RmserviceOrderVO> retieveRmServiceOrderList(PaginationInfo paging) {
		
		int totalRecod = ordao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<RmserviceOrderVO> rmSOrderList = ordao.selectList(paging);
		return rmSOrderList;
	}

	@Override
	public List<RmserviceOrderVO> retieveRmServiceRqstList(PaginationInfo paging) {
		
		int totalRecod = rqdao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<RmserviceOrderVO> rmSRqstList = rqdao.selectList(paging);
		
		return rmSRqstList;
	}

	@Override
	public List<RmserviceVO> retieveRmServiceList() {
		
		List<RmserviceVO> rmSvcList = dao.selectRmsList();
		
		return rmSvcList;
	}

	@Override
	public ServiceResult createRmSvcList(List<RmSvcOrderVO> orders) {
		
		log.info("########################orders:{}", orders);
		
		ServiceResult result = null;
		
		Map<String, Object> rmSvcOrder = new HashMap<>();
		int sum = 0;
		
		rmSvcOrder.put("chkinNo", orders.get(0).getChkinNo());
		
		String rmSvcOrderNo = ordao.rmSvcOderNo();
		rmSvcOrder.put("rmSvcOrderNo", rmSvcOrderNo);
		
		log.info("################rmSvcOrder:{}",rmSvcOrder);
		
		for (int i = 0; i < orders.size(); i++) {
			RmserviceVO rmSvcSelect = ordao.rmSvc(orders.get(i).getRsCd()); //가격
			int rsAmnt = rmSvcSelect.getRsAmnt();
			sum = sum + rsAmnt;
		}
		log.info("###################sum:{}", sum);
		rmSvcOrder.put("rsodSetleAmnt", sum);
		
		int rmSvcOrderInsert = ordao.rmSvcOrderInsert(rmSvcOrder); //룸서비스 주문 insert
		
		Map<String, Object> rmSvcDtl = new HashMap<>();
		
		int rmSvcDtlInsert = 0;
		
		for (int i = 0; i < orders.size(); i++) {
			RmserviceVO rmSvcSelect = ordao.rmSvc(orders.get(i).getRsCd());
			String rsCd = orders.get(i).getRsCd();
			int rsdDtlCnt = orders.get(i).getRsdDtlCnt();
			int rsAmnt = rmSvcSelect.getRsAmnt();
			
			rmSvcDtl.put("rmSvcOrderNo", rmSvcOrderNo);
			rmSvcDtl.put("rsCd", rsCd);
			rmSvcDtl.put("rsdDtlCnt", rsdDtlCnt);
			rmSvcDtl.put("rsAmnt", rsAmnt);
			
			rmSvcDtlInsert = ordao.rmSvcDtlInsert(rmSvcDtl); // 룸서비스 상세 insert
		}
		
		if(rmSvcOrderInsert != 1 || rmSvcDtlInsert != 1) {
			throw new RuntimeException();
		}else {
			result = ServiceResult.OK;
		}
		
		return null;
	}

}
