package kr.or.ddit.emp.hrm.empnotice.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.UncheckedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.emp.hrm.empnotice.exception.EmpNoticeException;
import kr.or.ddit.emp.hrm.empnotice.exception.WriterAuthenticationException;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.vo.AtchmnflEmpNoticeVO;
import kr.or.ddit.global.vo.EmpNoticeVO;
import kr.or.ddit.mybatis.mappers.EmpNoticeAtcMapper;
import kr.or.ddit.mybatis.mappers.EmpNoticeMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HrmEmpNoticeServiceImpl implements HrmEmpNoticeSevice {
	
	@Inject
	private EmpNoticeMapper mapper;
	
	@Inject
	private EmpNoticeAtcMapper atcMapper;
	
	@Value("#{appInfo.empNtPath}")
	private Resource empNtPath;
	
	
	private void processEmpNtFiles(EmpNoticeVO empNt) {
		MultipartFile[] empNtFiles = empNt.getEmpNtFiles();
		if(empNtFiles == null) return;
		for(MultipartFile single : empNtFiles) {
			if(single.isEmpty()) continue;
			//파일 메타 데이터 저장
			AtchmnflEmpNoticeVO atc = new AtchmnflEmpNoticeVO(single);
			atc.setEmpNtNo(empNt.getEmpNtNo());
			atcMapper.insertAtc(atc);
			
			//파일 이진데이터 저장
			String atcEmpNtUuid = atc.getAtcEmpNtUuid();
			log.info("이진데이터 +++++++++++++++++++++++++++++++++++++++++>>>>>>>>:{}", atcEmpNtUuid);
			try {
				File empNtFile = empNtPath.createRelative(atcEmpNtUuid).getFile();
				FileUtils.copyInputStreamToFile(single.getInputStream(), empNtFile);
				
			}catch(IOException e) {
				throw new UncheckedException(e);
			}
		}
	}
	
	@Override
	public String createEmpNotice(EmpNoticeVO empNt) {
		String newEmpNtNo = mapper.selectNewEmpNtNo();
		empNt.setEmpNtNo(newEmpNtNo);
		mapper.insert(empNt);
		processEmpNtFiles(empNt);
		return newEmpNtNo;
		

	}

	@Override
	public EmpNoticeVO retrieveEmpNotice(String empNtNo) throws EmpNoticeException {
		EmpNoticeVO target = mapper.select(empNtNo);
		if(target ==null) throw new EmpNoticeException(String.format("코드 %s번 글 없음.",empNtNo));
		mapper.updateCnt(target.getEmpNtNo());
		target = mapper.select(target.getEmpNtNo());
		return target;
	}

	@Override
	public List<EmpNoticeVO> retrieveEmpNoticeList(PaginationInfo paging) {
		int totalRecord = mapper.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return mapper.selectList(paging);
	}

	@Override
	public EmpNoticeVO writerAutenticate(EmpNoticeVO target) throws WriterAuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyEmpNotice(EmpNoticeVO empNt) {
		 mapper.update(empNt);
		 processEmpNtFiles(empNt);
	}

	@Override
	public void removeEmpNotice(EmpNoticeVO empNt) {
		EmpNoticeVO saved = mapper.select(empNt.getEmpNtNo()); 
//		log.info("첨부파일 리스트: {}", saved.getAtchList().size());
//		log.info("첨부파일 리스트: {}", saved.getAtchList().get(0).getAttNo());
		if (saved.getAtchList().size() > 0 && saved.getAtchList().get(0).getAttNo() != null) //첨부파일이 없는 경우에도 AtchmnflEmpNoticeVO 하나가 생성됨.
			saved.getAtchList().forEach(a->removeAtch(a.getAttNo()));
		mapper.delete(empNt.getEmpNtNo());
	}

	@Override
	public AtchmnflEmpNoticeVO downloadAtch(int attNo) {
		AtchmnflEmpNoticeVO atc = atcMapper.selectAtc(attNo);
		if(atc==null) 
			throw new EmpNoticeException("파일 없음.");
		return atc;
	}
	
	public void deleteBinary(AtchmnflEmpNoticeVO atc) {
		Resource savedBinary;
		try {
			savedBinary = empNtPath.createRelative(atc.getAtcEmpNtUuid());
			if(savedBinary.exists())
				FileUtils.deleteQuietly(savedBinary.getFile());
			
		}catch(IOException e) {
			throw new UncheckedException(e);
		}
	}

	@Override
	public void removeAtch(int attNo) {
		AtchmnflEmpNoticeVO saved = atcMapper.selectAtc(attNo);
		atcMapper.deleteAtc(attNo);
		
	}

}
