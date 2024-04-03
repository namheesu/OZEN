package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.RegistVO;

@Mapper
public interface CstmrMapper extends AbstractCommonMapper<CstmrVO, String>{

	public int insertCstmr(RegistVO newMber);
	
	public int updateCstmer(RegistVO mber);
	
	public CstmrVO checkUser(CstmrVO user);
	
}
