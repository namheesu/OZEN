package kr.or.ddit.emp.myinfo.cert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.global.vo.CertVO;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.mybatis.mappers.EmpMapper;
import kr.or.ddit.mybatis.mappers.CertMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpMyinfoCertServiceImpl implements EmpMyinfoCertService {
	
	private final EmpMapper empdao;
	private final CertMapper certdao;
	
	@Override
	public List<CertVO> retrieveCertList(String username) {
		List<CertVO> certList = certdao.selectCert(username);
		return certList;
	}

	@Override
	public List<CertVO> retrieveRecomCertList(String username) {
		EmpVO user = empdao.selectEmpDeptAndAnnual(username);
		List<CertVO> recomCertList = certdao.selectRecomCert(user);
		return recomCertList;
	}


}
