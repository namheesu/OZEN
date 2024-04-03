package kr.or.ddit.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfTest {
	public static void main(String[] args) throws IOException {
		
		PDDocument document = new PDDocument();
		PDPage firstPage = new PDPage();
		document.addPage(firstPage);
		
		PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
		contentStream.setLeading(16.0F);
		
		
		contentStream.newLineAtOffset(25, firstPage.getTrimBox().getHeight()-25);
		String text1 = "This is first line";
		String text2 = "This is Second line";
		String text3 = "This is Third line";
		
		contentStream.showText(text1);
		contentStream.newLine();
		contentStream.showText(text2);
		contentStream.newLine();
		contentStream.showText(text3);
		contentStream.newLine();
		
		contentStream.endText();
		contentStream.close();
		
		
		document.save("d:/paytemp/pay.pdf");
		document.close();
		System.out.println("PDF Created");
		
		
	}

}
