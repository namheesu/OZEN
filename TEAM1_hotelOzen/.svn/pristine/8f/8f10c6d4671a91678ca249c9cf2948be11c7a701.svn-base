package kr.or.ddit.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Excel2DBTest {
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		Excel2DBTest test = new Excel2DBTest();
		String Location = "D:/hotelworkschdl/hotelozen2403.xlsx";		// 파일의 위치 및 이름	
		ArrayList<ArrayList<String>> list =null;
		try {
			 list = test.readFilter(Location); //파일에서 각 셀들을 읽어서 Arraylist에 저장
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.print("엑셀에서 읽어온 내용들....");
		System.out.println(list);
		
		test.group(list);

	}
	
	public ArrayList<ArrayList<String>> readFilter(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);

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
	
	public void group (ArrayList<ArrayList<String>> list) {
		
		SimpleDateFormat y_format = new SimpleDateFormat("yyyy");
		String year = y_format.format(new Date());
		String month = null;
		ArrayList<String> dateList = new ArrayList<String>();
		
		ArrayList<String> monthArrayList = list.get(0);
		ArrayList<String> dateArrayList = list.get(1);
		
		if(monthArrayList.get(0).equals("월")) {
			month = monthArrayList.get(2);
			month = month.replaceAll("\\.0$","");
			int monthLength = month.replaceAll("\\.0$","").length();
			if(monthLength<=1) month = "0"+ month;
			System.out.println("포맷 후의 월:" + month);
		}
		
		for(int i = 0; i<dateArrayList.size(); i++) {
			System.out.println("여기에는 이것이 들었습니다. :"+dateArrayList.get(i));
			
			if(dateArrayList.get(i).contains(".0")) {
				System.out.println(dateArrayList.get(i) +"숫자로 변환가능");
				String date = dateArrayList.get(i);
				date = date.replaceAll("\\.0$","");
				int dateLength = date.replaceAll("\\.0$","").length();
				if(dateLength<=1) date = "0"+ date;
				System.out.println("포맷 후의 월:" + date);
				String workdate = year+"/"+month+"/"+date;
				dateList.add(workdate);
			}else {
				continue;
			}
		}
		
		System.out.println("dateList"+ dateList);
		
		for(int i = 2; i<list.size(); i++) {
			ArrayList<String> wsInfo = list.get(i);
			String empNo = wsInfo.get(0);
			String empNm = wsInfo.get(1);
			for(int j = 2; j<wsInfo.size(); j++) {
				if(!wsInfo.get(j).contains("D")
						&& !wsInfo.get(j).contains("E")
						&& !wsInfo.get(j).contains("N")
						&& !wsInfo.get(j).contains("O")) break;
				log.info("사번 :{}, 이름: {}, 날짜: {}, 근무타입: {}",empNo, empNm, dateList.get(j-2),wsInfo.get(j));
				
			}
		}
		
//		for(ArrayList<String> sList : list) {
//				if(sList.get(0).equals("월")) {
//					month = sList.get(2);
//					month = month.replaceAll("[.0]","");
//					int monthLength = month.replaceAll("[.0]","").length();
//					if(monthLength<=1) month = "0"+ month;
//					System.out.println("포맷 후의 월:" + month);
//					continue;
//				}
//					
//				for(String s :sList) {
//					System.out.println(s);
//				}
//		}
		
		
	}
	
		
	

}
