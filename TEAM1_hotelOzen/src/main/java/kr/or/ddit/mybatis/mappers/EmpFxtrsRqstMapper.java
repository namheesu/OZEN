package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpAlramVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.FxtrsRqstVO;
import kr.or.ddit.global.vo.FxtrsVO;

@Mapper
public interface EmpFxtrsRqstMapper{
	
	/**
	 * 요청서 목록 조회
	 * @param paging 
	 * @return
	 */
	public List<FxtrsRqstVO> selectList(PaginationInfo paging);
	
	/**
	 * 사번을 이름으로 바꾸는 쿼리
	 * @param empNo
	 * @return
	 */
	public FxtrsRqstVO selectEmpName(String empNo); 
	
	public int selectTotal();
	
	public int selectrqstTotal();
	
	public int payTotal();
	
	public int payClearTotal();
	
	public int returnTotal();
	
	public int selectTotalRecord(PaginationInfo paging);
	
	// 비품요청서 일련번호 생성
	public String selectRqstNo();
	
	// 요청서 승인 결재자
	public EmpVO selectRqstEmp();
	
	// 비품 상세 조회
	public FxtrsVO selectFxtrs(String fxCd);
	
	// 비품 요청 insert
	public int insertFxtrsRqst(Map<String, Object> fxData);
	
	// 비품 요청 상세 insert
	public int insertFxtrsRqstDtl(Map<String, Object> fxData);
	
	//비품 요청서 상세 조회
	public FxtrsRqstVO selectFxtrsRqst(String fxtrsRqstNo);
	
	// 요청결재자 사번으로 이름 조회
	public String selectEmpRqNm(String empRqNo);
	
	// 비품 요청서 승인
	public int updateFxtrsApproval(Map<String, Object> fxRqstNo);
	
	// 재무부 부장 이름
	public String selectRqstPurchs();
	
	// 비품 요청서 거부
	public int updateFxtrsRecusal(String updateData);
	
	// 비품 요청시 알림 insert
	public int insertFxtrsAlram(EmpAlramVO empAlram);
	
	// 비품 구매요청 상태변경
	public int updateFxtrsPur(FxtrsRqstVO fxtrsRqstVO);
	
	public Map<String, Integer> selectRqst(String empNo);
}
