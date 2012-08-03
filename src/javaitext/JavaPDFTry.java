package javaitext;

import java.awt.Color;
import java.io.*;
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
import com.itextpdf.*;
import com.itextpdf.text.*;
//import com.itextpdf.text.factories.*;
public class JavaPDFTry {
	 /** The resulting PDF file. */
	private static int noBorder = Rectangle.NO_BORDER;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 11,
            Font.NORMAL);
    private static Font whiteFont = new Font(Font.FontFamily.HELVETICA,14,Font.NORMAL,BaseColor.WHITE.brighter());
    private static Font redFont = new Font(Font.FontFamily.COURIER, 22,
            Font.BOLD, BaseColor.RED.brighter());
    private static Font blueFont = new Font(Font.FontFamily.COURIER, 22 ,Font.BOLD, BaseColor.BLUE.darker());
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

	    public static void main(String[] args) throws DocumentException, IOException {
	    	//DatabaseConnection connection = new HsqldbConnection("filmfestival");
	        Document document = new Document();
                
	        try {
	            PdfWriter writer
                    = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Neha\\Downloads\\pdfFactory\\pdfFactory\\src\\pdffactory\\HelloWorld.pdf"));
                     writer.setBoxSize("art", new Rectangle(500, 500, 559, 788));
                    HeaderFooter event = new HeaderFooter();
                     writer.setPageEvent(event);
                        document.open();
	            document.setPageSize(PageSize.A4);
		    document.setMargins(10f, 36f, 36f, 36f);
		    document.setMarginMirroring(true);

                        Chunk c = new Chunk("-");
                        c.setUnderline(BaseColor.BLACK, 0.0f, 0.3f, 10.0f, 0.0f, PdfContentByte.LINE_CAP_BUTT);
                      document.add(c);
                      document.add(Chunk.NEWLINE);
                                          for(int i=0;i<10;i++){
                    try {
                        document.add(getTable(i));
                    } catch (IOException ex) {
                        Logger.getLogger(JavaPDFTry.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                     document.close();
                        
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	    }

		private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	public static PdfPTable createTable() {
    	// a table with three columns
             PdfPTable table = new PdfPTable(1); // 3 columns. 
             table.setWidthPercentage(100f);
             table.getDefaultCell().setUseAscender(true);
            table.getDefaultCell().setUseDescender(true);
               PdfPCell cell = new PdfPCell (new Paragraph ("Cell Report",whiteFont));
            
           PdfPCell cell1 = new PdfPCell (new Paragraph("The Paper Company Limited",whiteFont));
            //cell.setColspan (1);
            cell.setHorizontalAlignment (Element.ALIGN_LEFT);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding (0.0f);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setUseBorderPadding(true);
            table.addCell (cell);
            //cell1.setColspan (1);
            cell1.setHorizontalAlignment (Element.ALIGN_RIGHT);
            cell1.setBackgroundColor(BaseColor.DARK_GRAY);
            cell1.setPadding (0.0f);
            table.completeRow();
            
            cell1.setBorder(Rectangle.NO_BORDER);
            cell1.setUseBorderPadding(true);
            table.addCell (cell1);
            
            

 
            
          //  table.addCell(cell3);
            
        return table;
    }	
        
    public static PdfPTable createTable1() {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        Phrase p = new Phrase("The Paper Company Limited",whiteFont); 
        Phrase pp = new Phrase("Call Report",whiteFont);
        PdfPCell cell = new PdfPCell(p);
        PdfPCell cell1 = new PdfPCell(pp);
        cell.setHorizontalAlignment (Element.ALIGN_RIGHT);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setBorder(Rectangle.NO_BORDER);
        cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        cell1.setBackgroundColor(BaseColor.GRAY);
        cell1.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell1);
        table.addCell(cell);
            
        return table;
    }	
    private static void addTitlePage(Document document)
            throws DocumentException {
       PdfPTable table = new PdfPTable(2);
       //table.setWidthPercentage(50);
       table.setHorizontalAlignment(100);
       table.setHeaderRows(3);
        // the cell object
        PdfPCell cell;
 
        // now we add a cell with rowspan 2
       cell = new PdfPCell();
       // cell.setRowspan(1);
       cell.setColspan(3);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        table.addCell("row 3; cell 1");
        table.addCell("row 3; cell 2");
        document.add(table);
//        PdfPTable table = new PdfPTable(3);
//        table.setWidthPercentage(80);
//        PdfPCell cell;
//        
//        
//        cell = new PdfPCell(new Phrase("Invoice Number : 111111",smallFont));
//        cell.setBorder(noBorder);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(cell);
//        
//        
//        cell = new PdfPCell(new Phrase(""));
//        cell.setBorder(noBorder);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Phrase("Resilient Networks PLC 27 Shaftesbury Avenue London W1D 7EQ",smallFont));
//        cell.setBorder(noBorder);
//        table.addCell(cell);
//        
//        PdfPTable table1 = new PdfPTable(1);
//        PdfPCell cell1;
//        cell1 = new PdfPCell(new Phrase("Date (And Tax Point): 31-07-2011",smallFont));
//        cell1.setBorder(noBorder);
//        table1.addCell(cell1);
//        // now we add a cell with rowspan 2
//        cell1 = new PdfPCell(new Phrase("Billing Period (Ending) : 31-07-2011",smallFont));
//        cell1.setBorder(noBorder);
//        table1.addCell(cell1);
//        table.setWidthPercentage(100);
//        table.setHorizontalAlignment(50);
//        table1.setWidthPercentage(100);
//        table1.setHorizontalAlignment(50);
//        
//        document.add(table);
//        document.add(table1);
        
        // Start a new page
        //document.newPage();
    }

	      /** Inner class to add a header and a footer. */
    static class HeaderFooter extends PdfPageEventHelper {

        @Override
        public void onStartPage (PdfWriter writer, Document document) {
           Rectangle rect = writer.getBoxSize("art");
            
            try {
                  Paragraph paragraph;
		        paragraph = new Paragraph();
		        paragraph.add(new Chunk("smart", redFont));
		        paragraph.add(new Chunk("numbers", blueFont));
		        document.add(paragraph);

                      //  addEmptyLine(paragraph,1);
                        document.add(Chunk.NEWLINE);
                        //document.add(createTable());
                       // document.add(createTable1());
                         //document.add(Chunk.NEWLINE);
                    addTitlePage(document);
                    document.add(Chunk.NEWLINE);
                    document.add(createTable1());

            } catch (DocumentException ex) {
               ex.printStackTrace();
            }
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page %d", writer.getPageNumber())),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
        }
    }
    
   private static PdfPTable getTable(int day)
        throws DocumentException, IOException {
    	// Create a table with 7 columns
        PdfPTable table = new PdfPTable(new float[] { 2, 1, 2, 5, 1, 3, 2 });
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        // Add the first header row
        Font f = new Font();
        f.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase("Hello",f));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(7);
        table.addCell(cell);
        // Add the second header row twice
        table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        for (int i = 0; i < 2; i++) {
            table.addCell("Location");
            table.addCell("Time");
            table.addCell("Run Length");
            table.addCell("Title");
            table.addCell("Year");
            table.addCell("Directors");
            table.addCell("Countries");
        }
        table.getDefaultCell().setBackgroundColor(BaseColor.GRAY);
        // There are three special rows
        table.setHeaderRows(3);
        // One of them is a footer
        table.setFooterRows(1);
        // Now let's loop over the screenings
       // List<Screening> screenings = PojoFactory.getScreenings(connection, day);
        //Movie movie;
        //for (Screening screening : screenings) {
         //   movie = screening.getMovie();
           // table.addCell(screening.getLocation());
            //table.addCell(String.format("%1$tH:%1$tM", screening.getTime()));
            //table.addCell(String.format("%d '", movie.getDuration()));
            //table.addCell(movie.getMovieTitle());
            //table.addCell(String.valueOf(movie.getYear()));
            //cell = new PdfPCell();
            //cell.setUseAscender(true);
            //cell.setUseDescender(true);
            //cell.addElement(PojoToElementFactory.getDirectorList(movie));
            //table.addCell(cell);
           // cell = new PdfPCell();
            //cell.setUseAscender(true);
            //cell.setUseDescender(true);
            //cell.addElement(PojoToElementFactory.getCountryList(movie));
            //table.addCell(cell);
        //}
        return table;
    }
	}

