package kr.or.ddit.pdf;



import java.io.FileNotFoundException;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class ItextPdfTest {
	public static void main(String[] args) throws FileNotFoundException {
		String path= "d:/paytemp/pay.pdf";
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		Document document = new Document(pdfDocument);
		document.add(new Paragraph("2024_02_SALARY").setBold());
		
		// Font
        
		
		float threecol = 190f;
		float twocol = 285f;
		float twocol150 = twocol+150f;
		float twocolumnWidth[] = {twocol150,twocol};
		float fullwidth[] = {threecol};
		
		
		Table table = new Table(twocolumnWidth);
		table.addCell(new Cell().add(new Paragraph("payment")));
		Table nestedTable = new Table(new float[]{twocol150/2, twocol150/2});
		nestedTable.addCell(new Cell().add(new Paragraph("EmpNo.")).setBorder(Border.NO_BORDER));
		nestedTable.addCell(new Cell().add(new Paragraph("E230012")).setBorder(Border.NO_BORDER));
		nestedTable.addCell(new Cell().add(new Paragraph("Give Date")).setBorder(Border.NO_BORDER));
		nestedTable.addCell(new Cell().add(new Paragraph("2024/02/00")).setBorder(Border.NO_BORDER));
		
//		table.addCell(new Cell().add(new Paragraph("2nd")));
		table.addCell(nestedTable);
		
		
		Color color = WebColors.getRGBColor("red"); 
		
		
		DeviceRgb rgb =new DeviceRgb(0,255,0);
		Border gb = new SolidBorder(1f/2f);
		gb.setColor(color);
		
		document.add(table);
		
		document.close();
		
		System.out.println("pdf출력중.....");
		
		
		
		
	}

}
