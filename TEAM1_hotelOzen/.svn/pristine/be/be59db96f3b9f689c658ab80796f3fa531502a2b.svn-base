package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.RsvtDetailsVO;
import kr.or.ddit.global.vo.RsvtVO;

@Mapper
public interface EmpStayChkinMapper{

	public int selectTotalRecord(PaginationInfo paging);
	
	/**
	 * 체크인 에정 목록 리스트 조회
	 * @param paging
	 * @return
	 */
	public List<RsvtVO> selectList(PaginationInfo paging);
	
	/**
	 * 체크인 예정 상세 조회
	 * @param rsvtNo
	 * @return
	 */
	public RsvtDetailsVO select(String rsvtDtlNo);
	
	//차량 코드 조회
	public String selectCarNo(String carNm);
	
	//체크인 번호 생성
	public String selectChkinNo();
	
	//체크인 테이블 insert
	public int insertChkin(Map<String, Object> chkin);
	
	//차가 없는 고객 체크아웃 insert문
	public int inserChkoutNoCar(Map<String, Object> chkin);
	
	//체크아웃 insert문
	public int inserChkout(String chkinNo);
	
	//객실상태 변경
	public int updateRoom(String roomNo);
	
	//차량 가격, 투숙여부 변경
	public int updateParking(String carNo);
	
	//예약 상태 변경
	public int updateRsvt(String rsvtDtlNo);
}
