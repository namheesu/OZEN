package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.EmpNoticeVO;

@Mapper
public interface EmpNoticeMapper extends AbstractCommonMapper<EmpNoticeVO, String> {
	
//	public List<EmpNoticeVO> selectList(PaginationInfo paging);
//	public int selectTotalRecord(PaginationInfo paging);
	public String selectNewEmpNtNo(); // 이거 xml 파일에 selectKey넣으면 필요 없으므로 수정하기
	public int updateCnt(String empNtNo); //조회수 증가

}
