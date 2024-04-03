
package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SellingVO;
import kr.or.ddit.global.vo.SetleVO;

@Mapper
public interface EmpPosSellingMapper extends AbstractCommonMapper<SellingVO, String> {

	/**
	 * 연도별 매출조회
	 * @param searchYear
	 * @return
	 */
	List<SellingVO> selectYearSetleList(String searchYear);
	
	/**
	 * 월별 매출조회
	 * @param searchDate
	 * @return
	 */
	List<SellingVO> selectMonthSetleList(String searchDate);
	
	/**
	 * 주간별 매출조회
	 * @param searchDate
	 * @return
	 */
	List<SellingVO> selectWeekSetleList(String searchDate);
	
	/**
	 * 주간별 예약건 수 조회
	 * @param searchDate
	 * @return
	 */
	List<RsvtVO> selectWeekRsvtCount(String searchDate);
	
}
