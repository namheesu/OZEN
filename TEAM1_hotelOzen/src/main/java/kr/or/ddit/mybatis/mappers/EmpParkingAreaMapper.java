package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.ParkingAreaVO;

@Mapper
public interface EmpParkingAreaMapper {
	
	public List<ParkingAreaVO> selectList();
}
