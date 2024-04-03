
package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.EmpVO;

@Mapper
public interface EmpMapper extends AbstractCommonMapper<EmpVO, String>{
	
	public int changePwd(EmpVO empVO);
	
	public EmpVO selectEmpByUserName(String username);
	
	public EmpVO selectEmpDeptAndAnnual(String username);
	
	public EmpVO findEmpUser(EmpVO empVO);
	
	public int deleteProfl(String empNo);
	
	public List<EmpVO> loginEmpVOs();
	
	
}
