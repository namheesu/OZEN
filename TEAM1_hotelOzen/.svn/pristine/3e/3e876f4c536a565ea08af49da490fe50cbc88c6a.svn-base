package kr.or.ddit.emp.crm.cstmr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RecomMbrshVO;
import kr.or.ddit.mybatis.mappers.RecomMbrshMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CrmMembshRecomServiceImpl implements CrmMembshRecomService{
	
	private final RecomMbrshMapper dao;

	@Override
	public MberVO retrieveMember(String memId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MberVO> retrieveMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecomMbrshVO getRecomMbrsh(String cstNo) {
		RecomMbrshVO vo = dao.select(cstNo);  
		if(vo == null) {
			vo = dao.selectHistoryAndMembsh(cstNo); //회원 고객인데, 가입 시기에 따라 추천 멤버십 테이블에 정보가 없는 경우
			if (vo == null) {
				vo = dao.selectRandomRecom(); //멤버십 추천 테이블에 동일한 호텔이용 내역이 없는 경우, 랜덤 멤버십 추천
			}
		}
		return vo;
	}
	
}
