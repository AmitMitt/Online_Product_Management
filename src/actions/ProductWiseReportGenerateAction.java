package actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;
import entity.UserProduct;

public class ProductWiseReportGenerateAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(ActionContext.getParameter("pid"));
	    ProductDao dao=new ProductDao();
	    List<UserProduct> list=dao.getProductById(pid);
	    Product prod=dao.getByProductId(pid);
	    ServletContext ctx=ActionContext.getServletContext();
	    HttpServletRequest request=(HttpServletRequest) ActionContext.getServletRequest();
	    HttpServletResponse response=(HttpServletResponse) ActionContext.getServletResponse();
	    String productName=prod.getName();
	    
	    
	    try{
	    Image img=Image.getInstance(ctx.getRealPath("/images/logo-small.png"));
        img.scaleAbsolute(100f, 40f);
        img.setAlignment(Image.MIDDLE);
        
        PdfPTable table=new PdfPTable(2);
      
        PdfPCell cell1=new PdfPCell(new Paragraph("Product Name : "+productName));
        cell1.setGrayFill(0.75f);
        PdfPCell cell2=new PdfPCell(new Paragraph("Register Counter : "+list.size()));
        cell2.setGrayFill(0.75f);
        PdfPCell cell3=new PdfPCell(new Paragraph("Product Registered By"));
        cell3.setGrayFill(0.5f);
        PdfPCell cell4=new PdfPCell(new Paragraph("Purchased On"));
        cell4.setGrayFill(0.5f);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        
        Iterator<UserProduct> itr=list.iterator();
        while(itr.hasNext()){
        	UserProduct uProd=itr.next();
        	PdfPCell cell5=new PdfPCell((new Paragraph(uProd.getUser().getName())));
            PdfPCell cell6=new PdfPCell(new Paragraph(uProd.getpDate()));
            table.addCell(cell5);
            table.addCell(cell6);
        }
        
     // step 1
        Document document = new Document();
        // step 2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        // step 3
        document.open();
        // step 4 
        document.add(img);
        document.add(new Paragraph(String.format("-----------------------------------------------PRODUCT WISE REPORT-----------------------------------------------")));
        document.add(Chunk.NEWLINE);
        document.add(table);
        // step 5
        document.close();

        // setting the content type
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", " inline; filename=ProductReport.pdf");
        // the contentlength
        response.setContentLength(baos.size());
        // write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();
    }
    catch(DocumentException e) {
        throw new IOException(e.getMessage());
    }
	    
		return null;
	}

}
