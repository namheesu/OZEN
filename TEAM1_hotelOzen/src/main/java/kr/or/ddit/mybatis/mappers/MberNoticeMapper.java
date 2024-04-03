package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.MberNoticeVO;

@Mapper
public interface MberNoticeMapper extends AbstractCommonMapper<MberNoticeVO, String>{
	
	public MberNoticeVO mberNoticeView(String mberNtNo);

	/**
	 * 고객 공지사항 조회수 증가 매소드
	 * @param mberNtNo
	 * @return
	 */
	int noticeCount(String mberNtNo);
	
}
