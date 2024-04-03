package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkoutVO;
import kr.or.ddit.global.vo.RmserviceOrderVO;

@Mapper
public interface EmpStayListMapper {

	public int selectTotalRecord(PaginationInfo paging);
	
	public List<ChkoutVO> selectList(PaginationInfo paging);
	
	public List<ChkoutVO> selectStay(String chkinNo);
	
	public List<RmserviceOrderVO> selectRms(String chkinNo);
}
