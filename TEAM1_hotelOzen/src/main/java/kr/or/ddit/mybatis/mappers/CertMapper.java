package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.CertVO;
import kr.or.ddit.global.vo.EmpVO;

@Mapper
public interface CertMapper {
	public List<CertVO> selectCert(String empNo);
	public List<CertVO> selectRecomCert(EmpVO user);
}
