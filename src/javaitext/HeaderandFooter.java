/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaitext;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author Neha
 */
public class HeaderandFooter extends PdfPageEventHelper{
protected Phrase header;
protected PdfPTable footer;
public static void main(String[] args) {
   new HeaderandFooter().createPDF();
System.out.println("** PDF CREATED **");
}
public void createPDF() {
Document document = new Document();
try{
PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\Neha\\Downloads\\pdfFactory\\pdfFactory\\src\\pdffactory\\Header_Footer_Example.pdf"));
writer.setPageEvent(new HeaderandFooter());
document.open();
for(int i=0;i<1000;i++){
document.add(new Phrase(" Testing this document "));
}
document.close();
}catch(Exception e){
}
}
public HeaderandFooter() {
header = new Phrase("**** THIS IS HEADER PART OF THIS PDF ****");

footer = new PdfPTable(1);
footer.setTotalWidth(300);
footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
footer.addCell(new Phrase(new Chunk("**** THIS IS FOOTER PART OF THIS PDF ****")
.setAction(new PdfAction(PdfAction.FIRSTPAGE))));
}
public void onEndPage(PdfWriter writer, Document document) {
PdfContentByte cb = writer.getDirectContent();
ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header,(document.right() - document.left()) / 2+ document.leftMargin(), document.top() + 10, 0);

footer.writeSelectedRows(0, -1,(document.right() - document.left() - 300) / 2+ document.leftMargin(), document.bottom() - 10, cb);
}
}

