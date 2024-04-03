package kr.or.ddit.cstmr.comm.faq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.FaqVO;
import kr.or.ddit.mybatis.mappers.CstmrFAQMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CstmrFAQServiceImpl implements CstmrFAQService {

	private final CstmrFAQMapper dao;
	
	@Override
	public List<FaqVO> selectFAQList() {
		List<FaqVO> faqList = dao.FAQList();
		return faqList;
	}
}
