package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.CarVO;
import kr.or.ddit.global.vo.ChkinVO;
import kr.or.ddit.global.vo.ChkoutVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.RoomVO;

@Mapper
public interface EmpRsvtAddMapper{

	//roomType 객실 조회
	public List<RoomVO> selectList(String rmType);
	
	//예약 객실수 조회
	public int selectRsvtCnt(String rmType);
	
	//차량 유무 조회
	public int selectCarYN(String carNo);

	//차량 코드 조회
	public String selectCarNo(String carNm);
	
	//결제 일련번호 생성
	public String selectSetleNo();
	
	//결제 테이블 insert
	public int insertSetle(Map<String, Object> setles);
	
	//고객번호 생성
	public String selectCstmrNo();
	
	//고객 테이블 insert
	public int insertCstmr(CstmrVO cstmr);
	
	//가격 타입 변환
	public String selectAmnt(String amnt);
	
	//체크인 번호 생성
	public String selectChkinNo();
	
	//체크인 테이블 insert
	public int insertChkin(Map<String, Object> chkin);
	
	//체크아웃 insert문
	public int inserChkout(String chkinNo);
	
	//객실상태 변경
	public int updateRoom(String roomNo);
	
	//차량 가격, 투숙여부 변경
	public int updateParking(String carNo);
	
}
