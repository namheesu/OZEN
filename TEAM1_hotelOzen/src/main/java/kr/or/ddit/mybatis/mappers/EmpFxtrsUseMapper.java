package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.FxtrsClsCdVO;
import kr.or.ddit.global.vo.FxtrsUseVO;
import kr.or.ddit.global.vo.FxtrsVO;
import kr.or.ddit.global.vo.RoomVO;

@Mapper
public interface EmpFxtrsUseMapper extends AbstractCommonMapper<FxtrsUseVO, String>{

	// 비품 상세 조회1
	public FxtrsUseVO selectFxtrsUse(String fxuseNo);
	
	// 비품 상세 조회2
	public List<FxtrsUseVO> selectFxtrsUseDtl(String fxuseNo);
	
	//비품 사용 일련번호 생성
	public String selectFxUseNo();
	
	//비품분류명 조회
	public List<FxtrsClsCdVO> selectFxCd();
	
	//비품 분류별 비품명 조회
	public List<FxtrsVO> selectFxNm(String fxCd);
	
	// 층별 객실호수 & 객실종류 조회
	public List<RoomVO> selectRmFloor(String floor);
	
	// 비품 사용 insert
	public int insertFxtrsUse(Map<String, Object> fxData);
	
	// 비품분류 코드 조회
	public String selectFxClsCd(String fxclsNm);
	
	// 비품 사용 상세 insert
	public int insertFxtrsUseDtl(Map<String, Object> fxData);
	
	// 비품별 현재수량 조회
	public String selectFxPresCnt(String fxCd);
	
	// 비품 수량 변경
	public int updateFxPresCnt(Map<String, Object> fxData);
	
}
