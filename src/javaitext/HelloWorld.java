/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaitext;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.Rectangle;
/**
 *
 * @author Neha
 */
public class HelloWorld {
    
    public static void main (String[] args){
        //Rectangle pageSize = new Rectangle (14400, 14400);
        Document doc = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Neha\\Documents\\NetBeansProjects\\JavaiText\\src\\javaitext\\HelloWorld.pdf"));
           // PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Neha\\Documents\\NetBeansProjects\\JavaiText\\src\\javaitext\\HelloWorld.pdf"));
            writer.setBoxSize(null, null);
            doc.open();
            doc.add(new Paragraph("Hello World"));
        }
        catch(Exception e){
             e.printStackTrace();
        }
        doc.close();
    }
}
