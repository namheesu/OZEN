package kr.or.ddit.mybatis.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.global.vo.RmserviceOrderVO;
import kr.or.ddit.global.vo.RmserviceVO;

@Mapper
public interface EmpRmServiceOrderMapper extends AbstractCommonMapper<RmserviceOrderVO, String> {

	//룸서비스주문 번호 생성
	public String rmSvcOderNo();
	
	//룸서비스 주문 insert
	public int rmSvcOrderInsert(Map<String, Object> rmSvcOrder);
	
	//가격 조회
	public RmserviceVO rmSvc(String rsCd);
	
	//룸서비스 상세 insert
	public int rmSvcDtlInsert(Map<String, Object> rmSvcDtl);
}
