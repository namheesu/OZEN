package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.AtchmnflEmpNoticeVO;

@Mapper
public interface EmpNoticeAtcMapper {
	public int insertAtc(AtchmnflEmpNoticeVO att);
	public AtchmnflEmpNoticeVO selectAtc(int attNo);
	public int deleteAtc(int attNo);
}
