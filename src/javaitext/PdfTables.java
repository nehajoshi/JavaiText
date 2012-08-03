/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaitext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author Neha
 */
public class PdfTables {
    
    public static final String RESOURCE = "C:/Users/Neha/Documents/NetBeansProjects/JavaiText/src/javaitext/%s.jpg";
	 private static int noBorder = Rectangle.NO_BORDER;
	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	            Font.BOLD);
	    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
	            Font.NORMAL);
	    private static Font redFont = new Font(Font.FontFamily.COURIER, 28,
	            Font.BOLD, BaseColor.RED);
	    private static Font blueFont = new Font(Font.FontFamily.COURIER, 28 ,Font.BOLD, BaseColor.BLUE);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	            Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    private static Font whiteFont = new Font(Font.FontFamily.TIMES_ROMAN, 11,
	            Font.BOLD,BaseColor.WHITE);
       
            public PdfTables() throws Exception{

            
	Document document = new Document(PageSize.A4,50,50,50,50);
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Neha\\Documents\\NetBeansProjects\\JavaiText\\src\\javaitext\\PDFTablesTest.pdf"));
        document.open();
        createTable1(document);
        createTable2(document);
        createTable3(document);
        
        
        PdfPTable table1 = new PdfPTable(7);
         table1.setWidthPercentage(100f);
            table1.setHorizontalAlignment(100);
	table1.setSpacingBefore(5);
	table1.setHeaderRows(1);      
        PdfPCell cell1;
        cell1= new PdfPCell(new Paragraph("Call Report",whiteFont));
        cell1.setColspan(1);
        cell1.setGrayFill(0.5f);
        cell1.setBorder(0);
        cell1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        table1.addCell(cell1);
        cell1 = new PdfPCell(new Phrase("The Paper Company Limited",whiteFont));
        cell1.setColspan(6);
        cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell1.setTop(1);
        cell1.setPaddingLeft(10.0f);
	cell1.setGrayFill(0.5f);
	cell1.setBorder(0);
	table1.addCell(cell1);
	table1.setSpacingBefore(10);
	document.add(table1);
        document.add(Chunk.NEWLINE);
        
    
        String[] headerStrings3 = new String[] { "Destination", "", "", "", "", "No. of Calls", "Cost" };
	for (String header : headerStrings3) {
	     PdfPCell headerCell1 = new PdfPCell(new Paragraph(header,smallFont));
	     headerCell1.setBorder(Rectangle.BOTTOM);
	     headerCell1.setBorderWidth(1);
             headerCell1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	     table1.addCell(headerCell1);
	     table1.setSpacingAfter(10f);    
	}
        
        document.add(Chunk.NEWLINE);
        document.add(table1);
        
        
        document.close();
    }   
    
    public static void main(String[] args) {	
		try{
                    
                    PdfTables pdfTable 
				= new PdfTables();
		}catch(Exception e){
			System.out.println(e);
		}
	}
    
    public static void createTable1(Document document) throws DocumentException{
        PdfPTable table = new PdfPTable(7); // table with 7 columns
            table.setWidthPercentage(100f);
            table.setHorizontalAlignment(100);
	table.setSpacingBefore(5);
	table.setHeaderRows(1);      
        PdfPCell cell;
        cell= new PdfPCell(new Paragraph("Call Report",whiteFont));
        cell.setColspan(1);
        cell.setGrayFill(0.5f);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("The Paper Company Limited",whiteFont));
        cell.setColspan(6);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setTop(1);
        cell.setPaddingLeft(10.0f);
	cell.setGrayFill(0.5f);
	cell.setBorder(0);
	table.addCell(cell);
	table.setSpacingBefore(10);
	document.add(table);
        document.add(Chunk.NEWLINE);
        
    
        String[] headerStrings1 = new String[] { "Destination", "", "", "", "", "No. of Calls", "Cost" };
	for (String header : headerStrings1) {
	     PdfPCell headerCell1 = new PdfPCell(new Paragraph(header,smallFont));
	     headerCell1.setBorder(Rectangle.BOTTOM);
	     headerCell1.setBorderWidth(1);
             headerCell1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	     table.addCell(headerCell1);
	     table.setSpacingAfter(10f);    
	}
        
        document.add(Chunk.NEWLINE);
        
         for(int r = 0; r<4 ;r++) {
		cell = new PdfPCell(new Paragraph("Destination",smallFont));
		cell.setBorder(0);
                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("",smallFont));
		cell.setBorder(0);
                table.addCell(cell);
		cell = new PdfPCell(new Paragraph("",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Calls",smallFont));
		cell.setBorder(0);
                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Cost",smallFont));
                cell.setBorder(0);  
                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);    
	}
           document.add(Chunk.NEWLINE);
           
           String[] headerStrings2 = new String[] { "Total", "", "", "", "", "No. of Calls", "Cost" };
            for (String header : headerStrings2) {
	     PdfPCell headerCell2 = new PdfPCell(new Paragraph(header,smallFont));
           
	     headerCell2.setBorder(Rectangle.TOP);
	     headerCell2.setBorderWidth(1);
             headerCell2.setHorizontalAlignment((Element.ALIGN_JUSTIFIED));
	     table.addCell(headerCell2);
	     table.setSpacingAfter(10f);
	    
	}
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        cell = new PdfPCell(new Paragraph(new Phrase(new Chunk(""))));
        cell.setRowspan(1);
        cell.setPaddingBottom(1);
        cell.setBorder(0);
        cell.setColspan(7);
        table.addCell(cell);
        
        document.add(table);
        document.add(Chunk.NEWLINE);
    }
    
    public static void createTable2(Document document){
        
    }
    
    public static void createTable3(Document document){
        
    }
}
