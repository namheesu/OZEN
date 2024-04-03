package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.ParkingVO;

@Mapper
public interface EmpParkingMapper extends AbstractCommonMapper<ParkingVO, String>{

}
