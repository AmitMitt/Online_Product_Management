package actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Queue;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import entity.Attachment;
import entity.Ticket;
import entity.User;

public class OpenTicketAction implements Action{

	@Override
	public String processRequest() throws Exception {
		HttpServletRequest request=(HttpServletRequest)ActionContext.getServletRequest();
		if (MultipartFormDataRequest.isMultipartFormData(request))
		  {
			  MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
			  
			  String title=mrequest.getParameter("title");
			  int pid=Integer.parseInt(mrequest.getParameter("pid"));
			  int priority=Integer.parseInt(mrequest.getParameter("priority"));
			  String description=mrequest.getParameter("description");
			  
			  Hashtable files = mrequest.getFiles();
			  int s=files.size();
				
				  if( (files != null) && (!files.isEmpty()) )
				  {
					  HttpSession session=ActionContext.getSession();	
					  TicketDao tdao=new TicketDao();
					  Ticket t=new Ticket();
					  ServletContext ac=ActionContext.getServletContext();			        
					  String basePath=ac.getRealPath("/WEB-INF/attachments");                
					  UploadBean bean=new UploadBean();
					  bean.setFolderstore(basePath);			    
					  bean.store(mrequest);	
					 // String filePath[]=new String[s];
					  Set<Attachment> set=new HashSet<Attachment>();
					  
					 for(int i=0;i<s;i++){	  
						 Attachment a=new Attachment();
					  UploadFile uf = (UploadFile) files.get("file"+(i+1)+"");
					  String fileRealName=uf.getFileName();
					  uf.setFileName(fileRealName);
					  String filePath=basePath+"\\"+fileRealName;
					  a.setFilePath(filePath);
					  set.add(a);
					 }
					 User u=(User)ActionContext.getAttribute("user",ActionContext.SessionScope);
					 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					  Date date = new Date();
					  String tDate=dateFormat.format(date);
					  
					 
					  t.setCustomerId(u.getId());
					  t.setDescription(description);
					  t.setPriority(priority);
					  t.setStatus(Ticket.Open);
					  t.setTicketDate(tDate);
					  t.setTitle(title);
					  t.setpId(pid);
					  t.setAttachment(set);
					  tdao.openTicket(t);					  
			}			 
		  }
		TicketDao dao=new TicketDao();
		Queue<Ticket> tqueue=dao.getOpenTicketList();
		ServletContext ctx = ActionContext.getServletContext();
		ctx.setAttribute("tQueue", tqueue);
		ActionContext.setAttribute("message","Ticket Opened Successfully");
		return "ticketOpen";
	}

		
}
