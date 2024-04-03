package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.SalaryGiveVO;

@Mapper
public interface HrmPayMapper extends  AbstractCommonMapper<SalaryGiveVO, String>{
	public List<Map<String, Object>> selectAutoSalaryCalInQuery(
											Map<String, Object> data);
	
	

}
