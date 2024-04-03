package kr.or.ddit.global.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.global.vo.MberVO;

public class MberVOWrapper extends User {
	
	private MberVO mberUser;
	
	public MberVOWrapper(MberVO mberUser) {
		super(mberUser.getMberId()
				, mberUser.getMberPw()
				, mberUser.getUserRoles().stream()
						  .map(SimpleGrantedAuthority::new)
						  .collect(Collectors.toList()));
		this.mberUser = mberUser;
	}
	public MberVO getMberUser() {
		return mberUser;
	}
}
