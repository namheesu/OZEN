package kr.or.ddit.emp.pms.parking.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ParkingAreaVO;
import kr.or.ddit.global.vo.ParkingVO;
import kr.or.ddit.mybatis.mappers.EmpParkingAreaMapper;
import kr.or.ddit.mybatis.mappers.EmpParkingMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpPmsParkingServiceImpl implements EmpPmsParkingService {

	private final EmpParkingMapper dao;
	
	private final EmpParkingAreaMapper areaDao;
	
	@Override
	public List<ParkingVO> retrieveParkingList(PaginationInfo paging) {
		
		int totalRecod = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecod);
		
		List<ParkingVO> parkingList = dao.selectList(paging);
		return parkingList;
	}

	@Override
	public List<ParkingAreaVO> retrieveParkingAreaList() {
		List<ParkingAreaVO> parkingAreaList = areaDao.selectList();
		return parkingAreaList;
	}

}
