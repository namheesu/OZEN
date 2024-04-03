package kr.or.ddit.emp.hrm.emply.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.HrmEmpVO;
import kr.or.ddit.mybatis.mappers.HrmEmpMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HrmEmpServiceImpl implements HrmEmpService {
	
	@Inject
	private HrmEmpMapper mapper;
	
	@Value("#{appInfo.empProfPath}")
	private Resource empProfPath;
	
	


	/**
	 * 단일 직원 계정 생성
	 */
	@Override
	public ServiceResult createHrmEmp(HrmEmpVO hrmEmp) {
//		LocalDate empBirth = (LocalDate)hrmEmp.getEmpBirth().format(DateTimeFormatter.ofPattern("YYYY/MM/DD"));
//		String empJncmpYmd = hrmEmp.getEmpJncmpYmd().format(DateTimeFormatter.ofPattern("YYYY/MM/DD"));
		int cnt = mapper.insert(hrmEmp);
		return cnt> 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	/**
	 * 직원 정보 상세 조회
	 */
	@Override
	public HrmEmpVO retrieveHrmEmp(String empNo) {
		
		return mapper.select(empNo);
	}

	/**
	 * 전체 직원 목록 조회
	 */
	@Override
	public List<HrmEmpVO> retrieveHrmEmpList() {
		return mapper.selectList();
	}

	@Override
	public ServiceResult modifyHrmEmp(HrmEmpVO hrmEmp) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 직원 퇴사자 처리, 직원 퇴사정보 칼럼을 변경하는 것이므로 UPDATE 쿼리 이용.
	 */
	@Override
	public ServiceResult removeHrmEmp(String empNo) {
		int cnt = mapper.delete(empNo);
		return cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	/**
	 *	현재 출근한 직원 목록 조회
	 */
	@Override
	public List<HrmEmpVO> retrieveHrmEmpDclzList() {
		return mapper.selectDclzList();
	}

	/**
	 * 퇴사 처리된 직원 목록 조회
	 */
	@Override
	public List<HrmEmpVO> retrieveHrmEmpRtrmList() {
		return mapper.selectRtrmList();
	}

	@Override
	public String createHrmEmpNo() {
		return mapper.selectNewEmpNo();
	}

	@Override
	public int createHrmEmpsUsingExcel(File file) {
		ArrayList<ArrayList<String>> list =null;
		try {
			 list = readFilter(file); //파일에서 각 셀들을 읽어서 Arraylist에 저장
		} catch (IOException e) {
			e.printStackTrace();
		}	
		int cnt = 0;
		ArrayList<HrmEmpVO> empList = group(list);
		log.info("empList {} 명 , {}", empList.size(),empList );
		
		for (HrmEmpVO emp : empList) {
			String newEmpNo = mapper.selectNewEmpNo();
			emp.setEmpNo(newEmpNo);
			emp.setEmpPw(newEmpNo);
			cnt += mapper.insert(emp);
		}
		return cnt;
	} 
	
	
	/**
	 * 업로드한 엑셀 파일에서 데이터를 읽어오는 메소드
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public ArrayList<ArrayList<String>> readFilter(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;		
		ArrayList<ArrayList<String>> filters = new ArrayList<ArrayList<String>>();		
		
		int sheetCn = workbook.getNumberOfSheets();	// 시트 수
		for(int sheetnum=0; sheetnum<sheetCn; sheetnum++) {	// 시트 수만큼 반복
			
			int sheetnum2=sheetnum+1;
			System.out.println("sheet = " + sheetnum2);
			
			XSSFSheet sheet = workbook.getSheetAt(sheetnum);	// 읽어올 시트 선택
			int rows = sheet.getPhysicalNumberOfRows();    // 행의 수
			XSSFRow row = null;
			
			for (rowindex = 0; rowindex < rows; rowindex++) {	// 행의 수만큼 반복

				row = sheet.getRow(rowindex);	// rowindex 에 해당하는 행을 읽는다
				ArrayList<String> filter = new ArrayList<String>();	// 한 행을 읽어서 저장할 변수 선언

				if (row != null) {
					int cells = 0;	// 셀의 수
					cells = row.getPhysicalNumberOfCells();    // 열의 수
					for (columnindex = 0; columnindex <= cells; columnindex++) {	// 열의 수만큼 반복
						XSSFCell cell_filter = row.getCell(columnindex);	// 셀값을 읽는다
						String value = "";
								// 셀이 빈값일경우를 위한 널체크
						if (cell_filter == null) {
							continue;
						} else {
									// 타입별로 내용 읽기
							switch (cell_filter.getCellType()) {
							case FORMULA:
								value = cell_filter.getCellFormula();
								break;
							case NUMERIC:
								value = cell_filter.getNumericCellValue() + "";
								break;
							case STRING:
								value = cell_filter.getStringCellValue() + "";
								break;
							case BLANK:
								value = cell_filter.getBooleanCellValue() + "";
								break;
							case ERROR:
								value = cell_filter.getErrorCellValue() + "";
								break;
							default:
								break;
							}
						}
						filter.add(value);	//읽은 셀들을 filter에 추가 (행)
					}
				}
				filters.add(filter); //filter(행)을 filters(열)에 추가
			}
		}
		fis.close();	//파일 읽기 종료
		return filters;	//리스트 반환
	}
	
	
	
	/**
	 * 엑셀에서 읽어온 데이터를 HrmEmpVO로 변환하는 메소드
	 * @param list
	 * @return
	 */
	public ArrayList<HrmEmpVO> group (ArrayList<ArrayList<String>> list) {
		
//		SimpleDateFormat y_format = new SimpleDateFormat("yyyy");
//		String year = y_format.format(new Date());
//		String month = null;
//		ArrayList<String> dateList = new ArrayList<String>();
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		ArrayList<HrmEmpVO> empList = new ArrayList<HrmEmpVO>();
		
		
		//String regExp = "\\d{4}/\\d{2}/\\d{2}";		
		for(int i=1; i<list.size(); i++) {
			HrmEmpVO emp = new HrmEmpVO();
			for(int j=0; j<list.get(i).size(); j++) {
				switch (j) {
					case 0:
						emp.setEmpNm(list.get(i).get(j));
					break;
					case 1:
						emp.setEmpDept(list.get(i).get(j));
						break;
					case 2:
						emp.setEmpTel(list.get(i).get(j));
						break;
					case 3:
						emp.setEmpHomeTel(list.get(i).get(j));
						break;
					case 4:
						emp.setEmpEml(list.get(i).get(j));
						break;
					case 5:
						emp.setEmpAddr(list.get(i).get(j));
						break;
					case 6:
						LocalDate jncmpYmd = LocalDate.parse(list.get(i).get(j),formatter);
						emp.setEmpJncmpYmd(jncmpYmd);
						break;
					case 7:
						emp.setEmpJbgd(list.get(i).get(j));
						break;
					case 8:
						LocalDate birth = LocalDate.parse(list.get(i).get(j), formatter);
						emp.setEmpBirth(birth);
						break;
					default:
						
				}
			}
			empList.add(emp);		
		}
		return empList;
	}	
	
	
	
}
