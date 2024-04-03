package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.SpendingVO;

@Mapper
public interface EmpPosSpendingMapper extends AbstractCommonMapper<SpendingVO, String>{

	/**
	 * 연도별 인건비 지출조회
	 * @param searchYear
	 * @return
	 */
	List<SpendingVO> selectYearSalarySpendingList(String searchYear);
	
	/**
	 * 월별 인건비 지출조회
	 * @param searchDate
	 * @return
	 */
	List<SpendingVO> selectMonthSalarySpendingList(String searchDate);
	
	/**
	 * 연도별 비품 지출조회
	 * @param searchYear
	 * @return
	 */
	List<SpendingVO> selectYearFxtrsSpendingList(String searchYear);
	
	/**
	 * 월별 비품 지출조회
	 * @param searchDate
	 * @return
	 */
	List<SpendingVO> selectMonthFxtrsSpendingList(String searchDate);
	
	/**
	 * 연도별 유지비 지출조회
	 * @param searchDate
	 * @return
	 */
	List<SpendingVO> selectYearMainSpendingList(String searchYear);
	
	/**
	 * 월별 유지비 지출조회
	 * @param searchDate
	 * @return
	 */
	List<SpendingVO> selectMonthMainSpendingList(String searchDate);
	

}
