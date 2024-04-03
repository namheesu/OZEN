package kr.or.ddit.global.security.dao;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import kr.or.ddit.global.security.MberVOWrapper;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.mybatis.mappers.MberMapper;

@Repository("mberDetailService")
public class MberDAOImpl implements UserDetailsService {
	
	@Inject
	private MberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MberVO mber = mapper.selectMberByUserName(username);
		
		if(mber.isMberSecsnYn()) {
			mapper.cancleSecsn(username);
		}
		
		return new MberVOWrapper(mber);
	}

}
