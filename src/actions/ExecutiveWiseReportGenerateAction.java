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

import dao.ExecDao;
import dao.TicketReplyDao;
import entity.TicketReply;

public class ExecutiveWiseReportGenerateAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		int eid=Integer.parseInt(ActionContext.getParameter("eid"));
		TicketReplyDao dao=new TicketReplyDao();
	    List<TicketReply> list=dao.getTicketReplayByEid(eid);
	    ExecDao edao=new ExecDao(); 
	   
	    ServletContext ctx=ActionContext.getServletContext();
	    HttpServletRequest request=(HttpServletRequest) ActionContext.getServletRequest();
	    HttpServletResponse response=(HttpServletResponse) ActionContext.getServletResponse();
	    String executiveName=edao.findById(eid).getName();
	    
	    
	    try{
	    Image img=Image.getInstance(ctx.getRealPath("/images/logo-small.png"));
        img.scaleAbsolute(100f, 40f);
        img.setAlignment(Image.MIDDLE);
        
        PdfPTable table=new PdfPTable(3);
      
        PdfPCell cell1=new PdfPCell(new Paragraph("Product Name"));
        cell1.getColspan();
        cell1.setGrayFill(0.75f);
        PdfPCell cell2=new PdfPCell(new Paragraph("Status"));
        cell2.setGrayFill(0.75f);
        PdfPCell cell3=new PdfPCell(new Paragraph("Token Date"));
        cell3.setGrayFill(0.75f);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        
        Iterator<TicketReply> itr=list.iterator();
        while(itr.hasNext()){
        	TicketReply tic=itr.next();
        	PdfPCell cell4=new PdfPCell((new Paragraph(tic.getProduct().getName())));
            PdfPCell cell5=new PdfPCell(new Paragraph(tic.getTicket().getStatus()));
            PdfPCell cell6=new PdfPCell(new Paragraph(tic.getTicket().getTicketDate()));
            table.addCell(cell4);
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
        document.add(new Paragraph(String.format("----------------------------------------------EXECUTIVE WISE REPORT----------------------------------------------")));
        document.add(Chunk.NEWLINE);
        document.add(new Paragraph(String.format("Executive Name: "+executiveName)));
        document.add(Chunk.NEWLINE);
        document.add(table);
        // step 5
        document.close();

        // setting the content type
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", " inline; filename=ExecutiveReport.pdf");
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
