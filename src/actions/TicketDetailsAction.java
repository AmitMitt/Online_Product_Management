package actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import javax.servlet.ServletContext;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import dao.TicketReplyDao;
import entity.Attachment;
import entity.Ticket;
import entity.TicketReply;

public class TicketDetailsAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(ActionContext.getParameter("tid"));
	
		List<Attachment> alist=new ArrayList<Attachment>();
		List<Attachment> list1=new ArrayList<Attachment>();
		TicketDao dao=new TicketDao();
		Ticket t=dao.getOpenTicketById(tid);
		if(t!=null){
			alist.addAll(t.getAttachment());
		}
		Iterator<Attachment> itr1=alist.iterator();
		while (itr1.hasNext()) {
			Attachment a = (Attachment) itr1.next();
			String file=a.getFilePath();
			ServletContext ac=ActionContext.getServletContext();			        
			String basePath=ac.getRealPath("/WEB-INF/attachments\\/");
			file=file.replace(basePath, "");
			a.setFilePath(file);
			list1.add(a);
		}
		TicketReplyDao tdao=new TicketReplyDao();
		ArrayList<TicketReply> trlist=tdao.byTicketId(tid);
		Queue<Ticket> list = dao.getOpenTicketList();
		ActionContext.getServletContext().setAttribute("tQueue", list);
		ActionContext.setAttribute("ticket", t);
		ActionContext.setAttribute("attachment", list1);
		ActionContext.setAttribute("trlist", trlist);
		return "ticketDetails";
	}

}
