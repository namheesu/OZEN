package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.RoomVO;

@Mapper
public interface EmpRoomMapper extends AbstractCommonMapper<RoomVO, String>{

	public int updateRoom(String roomNo);
	
	public int selectEmptyTotal();
	
	public int selectStayTotal();
	
	public int selectCleanTotal();
	
	public int selectBreakTotal();
}
