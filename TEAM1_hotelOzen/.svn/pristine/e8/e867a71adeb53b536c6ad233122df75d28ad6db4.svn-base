package kr.or.ddit.pdf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.fontbox.ttf.TrueTypeCollection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfTest3 {
	
	public static void main(String[] args) throws IOException {
		
		PDDocument document = new PDDocument();
		PDPage firstPage = new PDPage(PDRectangle.A4);
		document.addPage(firstPage);
		
		String name = "장재찬";
		String empDept = "HRM";
		
		Format d_format = new SimpleDateFormat("dd/MM/yyyy");
		Format t_format = new SimpleDateFormat("HH:mm");
		
		int pageWidth = (int) firstPage.getTrimBox().getWidth();
		int pageHeight = (int) firstPage.getTrimBox().getHeight();
		
		PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
		MyTextClass myTextClass = new MyTextClass(document, contentStream);
		
		
		//폰트들
		PDFont font = PDType1Font.HELVETICA;
		PDFont italicFont = PDType1Font.HELVETICA_OBLIQUE;
		
		TrueTypeCollection ttc = new TrueTypeCollection(new File("c:/windows/fonts/batang.ttc"));
		PDFont fontNanum = PDType0Font.load(document, ttc.getFontByName("Batang"), true); 
		
		PDImageXObject headImage = PDImageXObject.createFromFile("src/test/resources/kr/or/ddit/pdf/ozenlogo.png", document);
		contentStream.drawImage(headImage, 0, pageHeight-(pageHeight/2), 50, 50);
		
		String[] contactDetails = new String[] {"12345678", "01042114147"};
		myTextClass.addMultiLineText(contactDetails
				, 18, (int)(pageWidth - font.getStringWidth("12345678")/1000*15-10), pageHeight-25, fontNanum, 15, Color.BLACK);
		
		float titleTextWidth = myTextClass.getTextWidth("급여명세서", fontNanum, 16);
		myTextClass.addSingleLineText("급여명세서", (int)(pageWidth/2-(titleTextWidth)), pageHeight-110, fontNanum, 32, Color.BLACK);
		
		
		myTextClass.addSingleLineText("성명 : "+name, 25, pageHeight-250, fontNanum, 16, Color.BLACK);
		myTextClass.addSingleLineText("부서명 : "+empDept, 25, pageHeight-274, fontNanum, 16, Color.BLACK);
		
		String invoiceNo = "Invoice# 2536";
		float textWidth = myTextClass.getTextWidth(invoiceNo, font, 16);
		myTextClass.addSingleLineText(invoiceNo, (int)(pageWidth-25-textWidth), pageHeight-250, font, 16, Color.BLACK);
		
		float dateTextWidth = myTextClass.getTextWidth("지급일자 : "+d_format.format(new Date()), fontNanum, 16);
		myTextClass.addSingleLineText("지급일자 : "+d_format.format(new Date()), (int)(pageWidth-25-dateTextWidth), pageHeight-274, fontNanum, 16, Color.BLACK);
		
		String time = t_format.format(new Date());
		float timeTextWidth = myTextClass.getTextWidth("발급시간: "+time, fontNanum, 16);
		myTextClass.addSingleLineText("발급시간: "+time, (int)(pageWidth-25-timeTextWidth), pageHeight-298, fontNanum, 16, Color.BLACK);
		
		
		//급여 상세 내역을 보여주는 테이블
		MyTableClass myTable = new MyTableClass(document, contentStream);
		
		int[] cellWidths = {70,160,120,90,100};
		myTable.setTable(cellWidths, 30, 25, pageHeight-350);
		myTable.setTableFont(fontNanum, 16, Color.BLUE);
		
		Color tableHeaderColor = new Color(240, 93, 11); // r,g,b
		Color tableBodyColor = new Color(219,218,198);
		
		myTable.addCell("번호", tableHeaderColor);
		myTable.addCell("지급항목", tableHeaderColor);
		myTable.addCell("금액", tableHeaderColor);
		myTable.addCell("공제항목", tableHeaderColor);
		myTable.addCell("금액", tableHeaderColor);
		
		myTable.addCell("1", tableBodyColor);
		myTable.addCell("기본급", tableBodyColor);
		myTable.addCell("2,000,000 원", tableBodyColor);
		myTable.addCell("국민연금", tableBodyColor);
		myTable.addCell("80,000 원", tableBodyColor);
		
		myTable.addCell("2", tableBodyColor);
		myTable.addCell("야간근로수당", tableBodyColor);
		myTable.addCell("700,000 원", tableBodyColor);
		myTable.addCell("건강보험", tableBodyColor);
		myTable.addCell("13,000 원", tableBodyColor);
		
		myTable.addCell("3", tableBodyColor);
		myTable.addCell("", tableBodyColor);
		myTable.addCell("", tableBodyColor);
		myTable.addCell("장기요양보험", tableBodyColor);
		myTable.addCell("8,000 원", tableBodyColor);
		
		myTable.addCell("4", tableBodyColor);
		myTable.addCell("", tableBodyColor);
		myTable.addCell("", tableBodyColor);
		myTable.addCell("고용보험", tableBodyColor);
		myTable.addCell("10,000 원", tableBodyColor);
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<5; j++) {
				myTable.addCell("", tableBodyColor);				
			}
		}

		myTable.addCell("합계", tableBodyColor);
		myTable.addCell("지급합계", tableBodyColor);
		myTable.addCell("2,700,000 원", tableBodyColor);
		myTable.addCell("공제합계", tableBodyColor);
		myTable.addCell("111,000 원", tableBodyColor);
		
		myTable.addCell("", null);
		myTable.addCell("" , null);
		myTable.addCell("", null);
		myTable.addCell("실지급액", tableHeaderColor);
		myTable.addCell("2,589,000 원", tableHeaderColor);
		
		//Method of payment
		String[] paymentMethod = {"Method of payment we accept:"
				, "Cash, PhonePe, GPay, RuPay,Maestro,"
				, "Visa, MasterCard and American Express"};
		myTextClass.addMultiLineText(paymentMethod, 15, 25, 100
				, italicFont, 10, new Color(122,122,122));
		//authorised signatory
		contentStream.setStrokingColor(Color.BLACK);
		contentStream.setLineWidth(2);
		contentStream.moveTo(pageWidth-250, 150);
		contentStream.lineTo(pageWidth-25, 150);
		contentStream.stroke();
		String authoSign ="Authorised Sinnatory";
		float autoSignWidth = myTextClass.getTextWidth(authoSign, italicFont, 16);
		int xpos = pageWidth-250+pageWidth-25;
		myTextClass.addSingleLineText(authoSign, (int)(xpos-autoSignWidth)/2, 125, italicFont, 16, Color.BLACK);
		
		String bottomLine = "귀하의 노고에 감사드립니다.";
		float bottomLineWidth = myTextClass.getTextWidth(bottomLine, fontNanum, 20);
		myTextClass.addSingleLineText(bottomLine, (int)((pageWidth-bottomLineWidth)/2)
												, 50, fontNanum, 20, Color.DARK_GRAY);
		
		Color bottomRectColor = new Color(255,91,0);
		contentStream.setNonStrokingColor(bottomRectColor);
		contentStream.addRect(0, 0, pageWidth, 30);
		contentStream.fill();
		
		
		contentStream.close();
		document.save("d:/paytemp/pay.pdf");
		document.close();
		System.out.println("pdf created");
		
	}
	
	
	private static class MyTextClass {
		PDDocument document;
		PDPageContentStream contentStream;
		
		
		
		
		public MyTextClass(PDDocument document, PDPageContentStream contentStream) {
			this.document = document;
			this.contentStream = contentStream;
		}
		
		void addSingleLineText(String text, int xPosition, int yPosition, PDFont font, float fontSize, Color color) throws IOException {
			contentStream.beginText();
			contentStream.setFont(font, fontSize);
			contentStream.setNonStrokingColor(color);
			contentStream.newLineAtOffset(xPosition, yPosition);
			contentStream.showText(text);
			contentStream.endText();
			contentStream.moveTo(0,0);
		}
		
		void addMultiLineText(String[] textArray,float leading, int xPosition, int yPosition, PDFont font, float fontSize, Color color) throws IOException
		{
			contentStream.beginText(); //글쓰기 시작 
			contentStream.setFont(font, fontSize); // 폰트설정
			contentStream.setNonStrokingColor(color);
			contentStream.setLeading(leading); //줄간격
			contentStream.newLineAtOffset(xPosition, yPosition); // 글이 쓰여질 위치 지정
			
			for(String text : textArray) {
				contentStream.showText(text);  //글쓰기 시작
				contentStream.newLine();
			}
			contentStream.endText(); //글쓰기 종료
			contentStream.moveTo(0, 0); 
		}

		float getTextWidth(String text, PDFont font, float fontSize) throws IOException {
			return font.getStringWidth(text)/1000*fontSize;
		}
		
	}
	
	private static class MyTableClass {
		
		PDDocument document;
		PDPageContentStream contentStream;
		private int[] colWidths;
		private int cellHeight;
		private int yPosition;
		private int xPosition;
		private int colPosition = 0;
		private int xInitialPosition;
		private float fontSize;
		private PDFont font;
		private Color fontColor;
		
		public MyTableClass(PDDocument document, PDPageContentStream contentStream) {
			this.document = document;
			this.contentStream = contentStream;
		}
		
		void setTable(int[] colWidths, int cellHeight, int xPosition, int yPosition) {
			this.colWidths = colWidths;
			this.cellHeight = cellHeight;
			this.xPosition = xPosition;
			this.yPosition = yPosition;
			xInitialPosition = xPosition;
		}
		
		void setTableFont(PDFont font, float fontSize, Color fontColor) {
			this.font =font;
			this.fontSize = fontSize;
			this.fontColor = fontColor;
		}
		
		void addCell(String text, Color fillColor) throws IOException {
			contentStream.setStrokingColor(1f); 
			
			if (fillColor!=null) {
				contentStream.setNonStrokingColor(fillColor);				
			}
			
			contentStream.addRect(xPosition, yPosition, colWidths[colPosition], cellHeight);
			
			if(fillColor == null) {
				contentStream.stroke(); //선을 그린다.
				
			}else {
				contentStream.fillAndStroke();
			}
			
			contentStream.beginText(); //글쓰기 시작
			contentStream.setNonStrokingColor(fontColor);
			
			//숫자일 때, 우측 정렬하기 위함
			if(colPosition == 4 || colPosition == 2) { //2번 또는 4번 컬럼에서
				float fontWidth = font.getStringWidth(text)/1000 * fontSize; //글자길이
				contentStream.newLineAtOffset(xPosition+colWidths[colPosition]-20-fontWidth, yPosition+10);
			}else {
				contentStream.newLineAtOffset(xPosition+20, yPosition+10);
			}
			
			contentStream.showText(text);
			contentStream.endText();
			
			
			xPosition = xPosition + colWidths[colPosition];
			colPosition++;
			
			if(colPosition == colWidths.length) { //테이블 마지막 칼럼번호와 칼럼 수가 같으면, 즉 한 행의 끝에 도달하면
				colPosition = 0; //테이블의 첫번째 칼럼(0번째)으로
				xPosition = xInitialPosition; 
				yPosition -= cellHeight; // 가장 하단으로.. 
				
			}

		}
		
	}

}
