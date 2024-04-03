package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.FaqVO;

@Mapper
public interface CstmrFAQMapper {
	
	public List<FaqVO> FAQList();
}
