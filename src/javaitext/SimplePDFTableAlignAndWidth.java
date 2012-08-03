package JavaiText;

import java.awt.Color;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.*;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.net.MalformedURLException;

public class SimplePDFTableAlignAndWidth {
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
        public SimplePDFTableAlignAndWidth() throws Exception{
		
	Document document = new Document(PageSize.A4,50,50,50,50);
	//PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Neha\\Documents\\NetBeansProjects\\JavaiText\\src\\javaitext\\AddBigTable.pdf"));
       
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Neha\\Documents\\NetBeansProjects\\JavaiText\\src\\javaitext\\AddBigTable.pdf"));
            writer.setBoxSize("art", new Rectangle(100, 100, 559, 788));
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);
            document.open();
            addImage(document);
            document.setMarginMirroring(true);    
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
       cell = new PdfPCell(new Paragraph("Service Charges",whiteFont)); // 2nd section
	cell.setRowspan(1);
	cell.setColspan(7);
	cell.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
	//cell.setPaddingLeft(10.0f);
	cell.setGrayFill(0.5f);
	cell.setBorder(0);
	table.addCell(cell);
	table.setSpacingBefore(10);
        String[] headerStrings3 = new String[] { "UserID", "", "Description", "", "", "", "Cost" };
	for (String header : headerStrings3) {
	     PdfPCell headerCell3 = new PdfPCell(new Paragraph(header,smallFont));
	     headerCell3.setBorder(Rectangle.BOTTOM);
             headerCell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	     headerCell3.setBorderWidth(1);
	     table.addCell(headerCell3);
	     table.setSpacingAfter(10f);

	}  
        document.add(Chunk.NEWLINE);
        
       for(int r = 0; r<4 ;r++) {
		cell = new PdfPCell(new Paragraph("User ID",smallFont));
		cell.setBorder(0);
                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Description",smallFont));
                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
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
               ;
                table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Cost",smallFont));
                cell.setBorder(0);  
                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                
		table.addCell(cell);    
	}
       
       document.add(Chunk.NEWLINE);
        
        String[] headerStrings4 = new String[] { "", "", "", "", "", "Total", "Cost" };
            for (String header : headerStrings4) {
	     PdfPCell headerCell4 = new PdfPCell(new Paragraph(header,smallFont));
           
	     headerCell4.setBorder(Rectangle.TOP);
	     headerCell4.setBorderWidth(1);
             headerCell4.setHorizontalAlignment((Element.ALIGN_JUSTIFIED));
	     table.addCell(headerCell4);
	     table.setSpacingAfter(10f);
	    
	}
        // Itemisation Table
        cell = new PdfPCell(new Paragraph("Call Itemisation",whiteFont)); // 2nd section
	cell.setRowspan(1);
	cell.setColspan(7);
	cell.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
	//cell.setPaddingLeft(10.0f);
	cell.setGrayFill(0.5f);
	cell.setBorder(0);
	table.addCell(cell);
	table.setSpacingBefore(10);

	String[] headerStrings = new String[] { "UserID", "CallDate", "CallTime", "Duration", "Telephone Number", "Time Band", "Cost" };
	for (String header : headerStrings) {
	     PdfPCell headerCell = new PdfPCell(new Paragraph(header,smallFont));
	     headerCell.setBorder(Rectangle.BOTTOM);
	     headerCell.setBorderWidth(1);
	     table.addCell(headerCell);
	     table.setSpacingAfter(10f);
	     //table.addCell(new Phrase(Chunk.NEWLINE)); 
	} 
	document.add(Chunk.NEWLINE);
        
	//ResultSet r = s.executeQuery(" SELECT UserID,CallDate,CallTime,Duration,Telephone Number,Time Band,Cost FROM LARGE_TABLE);
	//while(r.next())
	 for(int r = 0; r<10 ;r++) {
		long row = r;
		//PdfPCell cell = new PdfPCell(new Paragraph(String.valueOf(row)));
		cell = new PdfPCell(new Paragraph("User Id",smallFont));
		//cell.setHorizontalAlignment(100);
		cell.setBorder(0);
		table.addCell(cell);
		//cell = new PdfPCell(new Paragraph("UserID"));
		//cell.setBorder(0);
		//table.addCell(cell);
		cell = new PdfPCell(new Paragraph("CallDate",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("CallTime",smallFont));
		cell.setBorder(0);
                table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Duration",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Telephone Number",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Time",smallFont));
		cell.setBorder(0);
                table.addCell(cell);
		cell = new PdfPCell(new Paragraph("Cost",smallFont));
		cell.setBorder(0);
		table.addCell(cell);
		//table.addCell(cell);
		//table.addCell(cell);
	}

	document.add(table);
	document.close();
	
	}

	public static void main(String[] args) {	
		try{
                    
                    SimplePDFTableAlignAndWidth pdfTable 
				= new SimplePDFTableAlignAndWidth();
		}catch(Exception e){
			System.out.println(e);
		}
	}
       
        
         
    /** Inner class to add a header and a footer. */
    static class HeaderFooter extends PdfPageEventHelper {

        public void onEndPage (PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");
            switch(writer.getPageNumber() % 2) {
                case 0:
                    ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, new Phrase("even header"),
                        rect.getRight(), rect.getTop(), 0);
                    break;
                case 1:
                    ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_CENTER, new Phrase("Invoice Number :"),
                      rect.getRight(), rect.getTop(), 0);
                    break;
            }
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page %d", writer.getPageNumber())),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
        }
    }
    public static void addImage(Document document) throws BadElementException,
            MalformedURLException, IOException, DocumentException{
        Image image1 = Image.getInstance(String.format(RESOURCE,"logo"));
	image1.scaleAbsolute(50,50);
        document.add(image1);
    }
}
