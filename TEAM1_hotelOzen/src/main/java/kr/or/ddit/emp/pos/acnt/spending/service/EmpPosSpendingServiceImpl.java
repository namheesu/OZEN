package kr.or.ddit.emp.pos.acnt.spending.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.SpendingVO;
import kr.or.ddit.mybatis.mappers.EmpPosSpendingMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpPosSpendingServiceImpl implements EmpPosSpendingService {
	
	@Inject
	public EmpPosSpendingMapper dao;
	
	@Override
	public List<SpendingVO> retrieveYearSalary(String searchYear) {
		return dao.selectYearSalarySpendingList(searchYear);
	}

	@Override
	public List<SpendingVO> retrieveMonthSalary(String searchYear) {
		return dao.selectMonthSalarySpendingList(searchYear);
	}

	@Override
	public List<SpendingVO> retrieveYearFxtrs(String searchYear) {
		return dao.selectYearFxtrsSpendingList(searchYear);
	}

	@Override
	public List<SpendingVO> retrieveMonthFxtrs(String searchYear) {
		return dao.selectMonthFxtrsSpendingList(searchYear);
	}

	@Override
	public List<SpendingVO> retrieveYearMain(String searchYear) {
		return dao.selectYearMainSpendingList(searchYear);
	}

	@Override
	public List<SpendingVO> retrieveMonthMain(String searchYear) {
		return dao.selectMonthMainSpendingList(searchYear);
	}

}
