package kr.or.ddit.mybatis.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.DclzVO;

@Mapper
public interface DclzMapper {
	
	public int selectTotalRecord(@Param("empNo") String empNo, @Param("paging") PaginationInfo paging);

	public List<DclzVO> selectList(@Param("empNo") String empNo, @Param("paging") PaginationInfo paging);
}
