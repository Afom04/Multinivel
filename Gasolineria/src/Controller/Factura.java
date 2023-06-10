/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
//import com.itextpdf.layout.element.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Model.Venta;
import com.lowagie.text.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
/**
 *
 * @author Andrey Orozco
 */
public class Factura {
    SimpleDateFormat sdf; 
    Calendar cal;

    public Factura() {
        this.sdf= new SimpleDateFormat("yyyyMMddHHmmss");
        cal=Calendar.getInstance();
    }
    public void generar(Venta venta){
         // step 1: creation of a document-object        
        Document document = new Document();

        try {
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("factura_" + sdf.format(cal.getTime()) + ".pdf"));
            // step 3: we open the document
            document.open();
            
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            //--------------------- pagina 1 --------------------------
            g.setColor(Color.red);
            g.drawRect(1, 1, 2550 , 450);    
            
            g.setColor(new Color(154, 171, 237));
            g.fillOval(10, 10, 480, 100);
                        
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Gasolinera LA BOMBA", 40, 170);
            
            g.setColor(Color.BLACK);
            
            g.drawString("Factura"+ sdf.format(cal.getTime()), 16, 70);
       
            ImageIcon img = new ImageIcon(getClass().getResource("/Images/GAS.png"));
            g.drawImage(img.getImage(), 340, 210, 200, 200, null);
            
            Font font2 = new Font("Tahoma", Font.PLAIN, 15);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString("Tipo de combustible:"+venta.getNombre(), 60, 210);
            g.drawString("Cantidad"+venta.getCantidad()+" galones", 60, 230);
            g.drawString("Precio de venta:"+venta.getPrecioTotal(),60,250);
            g.drawString("Fecha de compra:"+venta.getFecha(), 60, 270);
    } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        JOptionPane.showMessageDialog(null, 
                "Se creo la factura "+ sdf.format(cal.getTime()) +" ");
}
}