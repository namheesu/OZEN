package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.AnnualVO;
import kr.or.ddit.global.vo.HrmAnnualVO;
@Mapper
public interface HrmYrycMapper extends AbstractCommonMapper<HrmAnnualVO, String>{
	
	public String selectAnlLeaUseNo();
	public HrmAnnualVO selectAnlReciverEmpNo(String empNo);
	public int updateOfSender(HrmAnnualVO annual);
	public int updateOfReceiver(HrmAnnualVO annual);
	public int insert(HrmAnnualVO annual);
	
}
