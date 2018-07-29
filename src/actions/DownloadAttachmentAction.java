package actions;

import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import entity.Attachment;

public class DownloadAttachmentAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		int aId=Integer.parseInt(ActionContext.getParameter("aid"));
		TicketDao tdao=new TicketDao();
		Attachment att=tdao.attachmentById(aId);
		
		HttpServletRequest request=(HttpServletRequest)ActionContext.getServletRequest();
		HttpServletResponse response = (HttpServletResponse)ActionContext.getServletResponse();
		ServletContext ctx=ActionContext.getServletContext();
		String url=ctx.getRealPath("/WEB-INF/attachments/");
		String filename=(att.getFilePath()).replace(url, "");
		java.io.File fileDownload=new java.io.File(att.getFilePath());
		response.setContentType("APPLICATION/OCTET-STREAM"); 
		response.setHeader("Content-Disposition","attachment; filename=\""+ filename +"\""); 
		
		
	  	java.io.FileInputStream in = new java.io.FileInputStream(fileDownload);
	  	OutputStream out=response.getOutputStream(); 
	  	byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
         
        in.close();
        out.close(); 
	  	
		return null;
		
	}

}
