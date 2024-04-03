package kr.or.ddit.global.vo;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="attNo")
@NoArgsConstructor
public class AtchmnflEmpNoticeVO implements Serializable{
	
	@ToString.Exclude
	@JsonIgnore
	private transient MultipartFile empNtFile;
	
	public AtchmnflEmpNoticeVO(MultipartFile empNtFile) {
		super();
		this.empNtFile = empNtFile;
		atcEmpFileNm= empNtFile.getOriginalFilename();
		atcEmpNtUuid= UUID.randomUUID().toString();
		
	}
	
	private String empNtNo;
	private String atcEmpNtUuid;
	private String atcEmpFileNm;
	private Integer attNo;

}
