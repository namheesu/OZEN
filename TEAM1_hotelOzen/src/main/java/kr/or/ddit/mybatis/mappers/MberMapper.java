package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.MileageVO;
import kr.or.ddit.global.vo.RegistVO;

@Mapper
public interface MberMapper{

	public MberVO select(String cstNo);
	
	public List<MberVO> selectList();
	
	public MberVO selectByMberId(String mberId);
	
	public MberVO selectMberByUserName(String username);
	
	public String selectNewCstNo();

	public int insertMber(RegistVO newMber);
	
	public MberVO findMberUser(RegistVO mber);
	
	public int updateCst(RegistVO mber);
	
	public int updateMber(RegistVO mber);
	
	public int changePwd(MberVO mber);

	public int updatePwd(MberVO mber);
	
	public MberVO selectSubscriber(String cstNo);
	
	public MberVO selectMypage(String cstNo);
	
	public MberVO selectCouponCnt(String cstNo);
	
	public List<MileageVO> selectMileageList(String cstNo);
	
	public int secsnUpdate(String cstNo);
	
	public int deletePrivacy();
	
	public int deletePrivacyCst();
	
	public int cancleSecsn(String username);
	
}
