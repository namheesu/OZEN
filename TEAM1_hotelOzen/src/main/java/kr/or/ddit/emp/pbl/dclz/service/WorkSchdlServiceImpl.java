package kr.or.ddit.emp.pbl.dclz.service;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.WorkSchdlVO;
import kr.or.ddit.mybatis.mappers.HrmWorkSchdlMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkSchdlServiceImpl implements WorkSchdlService {

	@Inject
	private HrmWorkSchdlMapper mapper;

	@Override
	public WorkSchdlVO retrieveWorkSchdl(String empNo, LocalDate workDate) {
		WorkSchdlVO vo = mapper.select(empNo, workDate);
		if(vo == null) 
			throw new PKNotFoundException(String.format("사번 :%s 날짜 : %s 해당 근무기록 없음.",empNo, workDate.toString()));
		return null;
	}

	@Override
	public List<WorkSchdlVO> retrieveWorkSchdlList(PaginationInfo paging) {
		int totalRecord = mapper.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return mapper.selectList(paging);
	}

	@Override
	public void createWorkSchdl(WorkSchdlVO workSchdl) {
		mapper.insert(workSchdl);
		
	}

	@Override
	public void modifyWorkSchdl(WorkSchdlVO workSchdl) {
		mapper.update(workSchdl);
		
	}

	@Override
	public void removeWorkSchdl(String target1, String target2) {
		mapper.delete(target1, target2);
		
	}
	
}
