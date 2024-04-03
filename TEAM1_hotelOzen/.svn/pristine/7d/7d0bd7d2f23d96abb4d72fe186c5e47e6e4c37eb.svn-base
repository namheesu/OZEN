package kr.or.ddit.global.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.global.vo.EmpVO;

public class EmpVOWrapper extends User {
	
	private EmpVO empUser;

	public EmpVOWrapper(EmpVO empUser) {
		super(empUser.getEmpNo()
				, empUser.getEmpPw()
				, empUser.getUserRoles().stream()
						  .map(SimpleGrantedAuthority::new)
						  .collect(Collectors.toList()));
		this.empUser = empUser;
	}
	public EmpVO getEmpUser() {
		return empUser;
	}

}
