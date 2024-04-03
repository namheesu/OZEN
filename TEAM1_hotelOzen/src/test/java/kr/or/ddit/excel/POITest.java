package kr.or.ddit.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * POI 참고 사이트
 * https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/
 * https://mvnrepository.com/artifact/org.apache.poi/poi
 * https://poi.apache.org/components/spreadsheet/quick-guide.html#NewWorkbook
 * 
 *
 */
public class POITest {
	
	public static void main(String[] args) throws FileNotFoundException,IOException {
		Workbook wb = new XSSFWorkbook();
		
		//New Workbook
//		try (OutputStream fileOut = new FileOutputStream("d:/temp/workbook.xlsx")) {
//	    wb.write(fileOut);
//	}
		
//		//new sheet
//		Sheet sheet1 = wb.createSheet("new sheet");
//		Sheet sheet2 = wb.createSheet("second sheet");
//		// Note that sheet name is Excel must not exceed 31 characters
//		// and must not contain any of the any of the following characters:
//		// 0x0000
//		// 0x0003
//		// colon (:)
//		// backslash (\)
//		// asterisk (*)
//		// question mark (?)
//		// forward slash (/)
//		// opening square bracket ([)
//		// closing square bracket (])
//		// You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
//		// for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
//		String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
//		Sheet sheet3 = wb.createSheet(safeName);
//		try (OutputStream fileOut = new FileOutputStream("d:/temp/workbook.xlsx")) {
//		    wb.write(fileOut);
//		}
	

		
		
		//Creating Cells
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");
		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow(0);
		// Create a cell and put a value in it.
		Cell cell = row.createCell(0);
		cell.setCellValue(1);
		// Or do it on one line.
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(
		     createHelper.createRichTextString("This is a string"));
		row.createCell(3).setCellValue(true);
		
		
		
		//sheet.createRow(3).createCell(3).setCellValue("아파치 포이포이포이"); //D4 저장
		
		
		// Write the output to a file
		try (OutputStream fileOut = new FileOutputStream("d:/temp/workbook1552511.xlsx")) {
		    wb.write(fileOut);
		}
	}
	
	
	    

}
