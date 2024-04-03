package kr.or.ddit.mybatis.mappers;

import java.time.LocalDate;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.WorkSchdlVO;

@Mapper
public interface HrmWorkSchdlMapper extends AbstractCommonMapper<WorkSchdlVO, Map<String, Object>>{
		public WorkSchdlVO select(String empNo, LocalDate workDate);
		public void delete(String target1, String target2);
}
