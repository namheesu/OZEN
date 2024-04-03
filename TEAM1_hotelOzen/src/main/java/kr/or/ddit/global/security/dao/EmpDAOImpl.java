package kr.or.ddit.global.security.dao;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import kr.or.ddit.global.security.EmpVOWrapper;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.mybatis.mappers.EmpMapper;

@Repository("empDetailService")
public class EmpDAOImpl implements UserDetailsService {
	
	@Inject
	private EmpMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmpVO emp = mapper.selectEmpByUserName(username);
		return new EmpVOWrapper(emp);
	}
	
	
}
