package kr.or.ddit.pdf;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PdfFileCreateTest {
	
	public static void main(String[] args) {
		Format file_name_format = new SimpleDateFormat("yyyyMMdd");
		String pay_file_name= file_name_format.format(new Date());
		
		//폴더 경로
		String path = String.format("d:/paytemp/%s",pay_file_name);
		
		// 객체 생성
		File folder = new File(path);
		
		// 해당 경로에 폴더가 없으면 생성 
		if ( !folder.exists() ) { 
			try { 
				System.out.println("폴더생성여부 : " + folder.mkdirs());
			} catch	(Exception e) { 
				e.getStackTrace(); 
			}
		}
	
	}

}
