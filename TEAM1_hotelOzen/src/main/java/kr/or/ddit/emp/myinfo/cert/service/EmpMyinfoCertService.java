package kr.or.ddit.emp.myinfo.cert.service;

import java.util.List;

import kr.or.ddit.global.vo.CertVO;

public interface EmpMyinfoCertService {

	public List<CertVO> retrieveCertList(String username);
	
	public List<CertVO> retrieveRecomCertList(String username);
}
