package kr.or.ddit.cstmr.intrcn.sbrsliar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.SbrsVO;
import kr.or.ddit.mybatis.mappers.MberSbrsLiarMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MberSbrsLiarServiceImpl implements MberSbrsLiarService {
	
	private final MberSbrsLiarMapper dao;

	@Override
	public List<SbrsVO> sbrsLiarList() {
		List<SbrsVO> sbrsLiarList = dao.sbrsLiarList();
		return sbrsLiarList;
	}

}
