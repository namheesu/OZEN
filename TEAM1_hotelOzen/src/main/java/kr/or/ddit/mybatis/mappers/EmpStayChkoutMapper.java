package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.ChkoutVO;

@Mapper
public interface EmpStayChkoutMapper{

	public int selectTotalRecord(PaginationInfo paging);
	
	public List<ChkoutVO> selectList(PaginationInfo paging);
	
	public ChkoutVO select(String chkinNo);
	
	public List<ChkoutVO> selectRms(String chkinNo);
	
	//객실 조회
	public String selectRmNo(String chkinNo);
	
	//예약 상세 조회
	public String selectRsvtDTL(String chkinNo);
	
	//고객번호 조회
	public String selectCstmrNo(String chkinNo);
	
	//룸서비스 결제금액
	public int selectRmsAmnt(String chkinNo);
	
	//결제 일련번호 생성
	public String selectSetleNo();
	
	//결제 테이블 insert
	public int insertSetle(Map<String, Object> setles);
	
	//체크아웃 테이블 update
	public int updateChkout(Map<String, Object> setles);
	
	//예약상세 테이블 update
	public int updatersvtDtl(Map<String, Object> setles);
	
	//객실 테이블 update
	public int updateRoom(Map<String, Object> setles);
	
}
