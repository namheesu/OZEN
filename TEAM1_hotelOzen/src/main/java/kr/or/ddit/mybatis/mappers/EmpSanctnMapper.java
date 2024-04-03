package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.FxtrsPrchsSttstVO;
import kr.or.ddit.global.vo.FxtrsVO;

@Mapper
public interface EmpSanctnMapper extends AbstractCommonMapper<FxtrsPrchsSttstVO, String>{

	/**
	 * 비품 구매예정 insert
	 * @param fxtrsPrchsSttstVO
	 * @return
	 */
	public int insertFxtrsPrchsSttst(List<FxtrsPrchsSttstVO>  fxtrsPrchsSttstVO);
	
	
	/**
	 * 비품 예정 목록 구매상태 변경
	 * @param fxtrsPrchsSttstVO
	 * @return
	 */
	public int updateFxtrsPrchsSe(FxtrsPrchsSttstVO fxtrsPrchsSttstVO);
	
	
	/**
	 * 승인된 비품 수량 수정
	 * @param fxtrsVO
	 * @return
	 */
	public int updateFxtrsCnt(FxtrsVO fxtrsVO);
	
	
	/**
	 * 비품 수 조회
	 * @param fxtrsCd
	 * @return
	 */
	public int selectFxtrsCnt(String fxtrsCd);
}
