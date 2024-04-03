package kr.or.ddit.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.MbrshBnfVO;
import kr.or.ddit.global.vo.MbrshGrdVO;
import kr.or.ddit.global.vo.MbrshSetleVO;

@Mapper
public interface MbrshMapper {
	public List<MbrshGrdVO> selectDetail(String grd);

	public List<MbrshGrdVO> selectList();

	public List<MbrshGrdVO> selectBenefit(String grd);
	
	public MbrshGrdVO selectOne(String grd);
	
	public List<MbrshBnfVO> selectCouponList(String grd);

	public List<MbrshGrdVO> selectMbrshList();
	
	public List<MbrshSetleVO> selectUserMbershList(String cstNo);
	
	public Map<String, String> selectMbrshCountList();
}
