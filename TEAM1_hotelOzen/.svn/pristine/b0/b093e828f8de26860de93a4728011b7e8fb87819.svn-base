package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;

/**
 * 업무현황 Mapper (비품, 연차, 휴가 결재상태를 한번에 나타내줌 /// 비품은 하우스키핑부와 재무부만 존재)
 */
@Mapper
public interface OprtnSttsMapper extends AbstractCommonMapper<FxtrsRqstVO, String>{

	
	/**
	 * 비품에 대한 업무현황 메소드 (하우스키핑부, 재무부만 포함)
	 * @param empNo
	 * @return
	 */
	public List<FxtrsRqstVO> fxtrsSelectList(@Param("paging") PaginationInfo paging, @Param("empNo") String empNo);
	
	public int fxtrsSelectTotalRecord(@Param("paging") PaginationInfo paging, @Param("empNo") String empNo);
	
	/**
	 * 비품요청서 상세조회
	 * @param fxtrsRqstNo
	 * @return
	 */
	public FxtrsRqstVO selectFxtrsRqst(String fxtrsRqstNo);
	
	
	//--------------------------------------------------------------------	
	
	/**
	 * 연차에 대한 업무현황 메소드 
	 * @param empNo
	 * @return
	 */
	public List<AnnualVO> annSelectList(@Param("paging") PaginationInfo paging, @Param("empNo") String empNo);
	
	public int annSelectTotalRecord(@Param("paging") PaginationInfo paging, @Param("empNo") String empNo);
	
	

	
}
