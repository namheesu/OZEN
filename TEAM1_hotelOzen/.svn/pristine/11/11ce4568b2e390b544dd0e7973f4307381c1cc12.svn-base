package kr.or.ddit.emp.pos.acnt.selling.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SellingVO;
import kr.or.ddit.global.vo.SetleVO;
import kr.or.ddit.mybatis.mappers.EmpPosSellingMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpPosSellingServiceImpl implements EmpPosSellingService{
	
	@Inject
	private EmpPosSellingMapper dao;

	@Override
	public List<SellingVO> retrieveYearSetle(String searchYear) {
		return dao.selectYearSetleList(searchYear);
	}
	
	@Override
	public List<SellingVO> retrieveMonthSetle(String searchDate) {
		return dao.selectMonthSetleList(searchDate);
	}
	
	@Override
	public List<SellingVO> retrieveWeekSetle(String searchDate) {
		return dao.selectWeekSetleList(searchDate);
	}

	@Override
	public List<RsvtVO> retrieveWeekRsvt(String searchDate) {
		return dao.selectWeekRsvtCount(searchDate);
	}
}
