package kr.or.ddit.global.preparer;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import kr.or.ddit.global.security.EmpVOWrapper;
import kr.or.ddit.global.security.MberVOWrapper;
import kr.or.ddit.global.vo.EmpVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.mybatis.mappers.CstmrMapper;
import kr.or.ddit.mybatis.mappers.EmpMapper;
import kr.or.ddit.mybatis.mappers.MberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Preparer("profilePreparer")
public class ProfilePreparer implements ViewPreparer {

	@Inject
	EmpMapper empDao;
	
	@Inject
	MberMapper mberDao;
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Collection<GrantedAuthority> authorities = null;
		if(authentication!=null) {
			authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
			
			log.info("권한 정보 : {}", authorities);
			
			if(authorities.stream().anyMatch(a->("ROLE_EMP").equals(a.getAuthority()))) {
				EmpVOWrapper principal = (EmpVOWrapper) authentication.getPrincipal();
				EmpVO realUser = principal.getEmpUser();
				
				log.info("콘솔 출력 확인>>>{}", realUser);
				EmpVO empUser = empDao.select(realUser.getEmpNo());
				empUser.setUserRoles(realUser.getUserRoles());
				log.info("콘솔 출력 확인>>>{}", empUser);
				Map<String, Object> requestScope = tilesContext.getContext(Request.REQUEST_SCOPE);
				
				requestScope.put("empUser", empUser);
				
			} else if(authorities.stream().anyMatch(a->a.getAuthority().equals("ROLE_USER"))) {
				
				MberVOWrapper principal = (MberVOWrapper) authentication.getPrincipal();
				MberVO realUser = principal.getMberUser();
				
				log.info("콘솔 출력 확인>>>{}", realUser);
				MberVO mberUser = mberDao.selectByMberId(realUser.getMberId());
				
				Map<String, Object> requestScope = tilesContext.getContext(Request.REQUEST_SCOPE);
				
				requestScope.put("mberUser", mberUser);
				
			}
		}
		
	}
}
