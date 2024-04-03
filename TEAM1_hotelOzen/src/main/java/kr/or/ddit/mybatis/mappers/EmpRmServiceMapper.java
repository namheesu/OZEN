package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.RmserviceVO;

@Mapper
public interface EmpRmServiceMapper {
	
	public List<RmserviceVO> selectRmsList();
}
